package com.csx.newsapp.ui.main.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.csx.newsapp.R;
import com.csx.newsapp.widget.actionbar.MainTopBar;
import com.csx.newsapp.widget.actionbar.TopBarImp;
import com.csx.newsapp.widget.download.DownloadService;
import com.fifedu.rxfiflibrary.base.BaseActivity;
import com.fifedu.rxfiflibrary.utils.LogUtil;
import com.fifedu.rxfiflibrary.utils.NetWorkUtils;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;

import butterknife.BindView;
import rx.functions.Action1;

/**
 * Created by cuishuxiang on 2017/7/10.
 */

public class PhotoDeatilActivity extends BaseActivity implements TopBarImp {
    private static final String TAG = "PhotoDeatilActivity";
    @BindView(R.id.photoView)
    PhotoView photoView;
    @BindView(R.id.photo_topbar)
    MainTopBar photoTopbar;
    @BindView(R.id.download_fab)
    FloatingActionButton downloadFab;

    private String img_url;

    //下载相关
    private DownloadService.DownloadBinder downloadBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.debug(TAG, "onServiceConnected:" + name.toString());
            downloadBinder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtil.debug(TAG, "onServiceDisconnected:" + name.toString());
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        downloadFab = (FloatingActionButton) findViewById(R.id.download_fab);
        photoTopbar.setTopBarImp(this);
        img_url = getIntent().getStringExtra("img_url");

        LogUtil.debug(TAG, "图片地址为：" + img_url);

        if (!TextUtils.isEmpty(img_url)) {
            if (isDownLoad(img_url)) {
                downloadFab.setImageResource(R.drawable.ic_done_white);
            }else {
                downloadFab.setImageResource(R.drawable.ic_download_white);
            }
            Glide.with(this)
                    .load(img_url)
                    .error(R.drawable.ic_empty_picture)
                    .into(photoView);

        }

        initDownLoad();

        downloadFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (StringUtils.isEmpty(img_url)) {
                    LogUtil.debug(TAG, "下载地址不存在:" + img_url);
                    return;
                }
                //增加wifi网络判断
                if (!NetWorkUtils.isWifiConnected(PhotoDeatilActivity.this)) {
                    Toast.makeText(PhotoDeatilActivity.this, "当前非wifi网络，请切换wifi网络下载！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (isDownLoad(img_url)) {
                    Toast.makeText(PhotoDeatilActivity.this, "该图片已经存在！", Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = img_url;
                downloadBinder.startDownload(url);
            }
        });
    }

    //首先检查该图片是否已经下载到本地
    private boolean isDownLoad(String img_url) {

        String fileName = img_url.substring(img_url.lastIndexOf("/"));
        String directory = Environment.getExternalStoragePublicDirectory
                (Environment.DIRECTORY_DOWNLOADS).getPath();
        File file = new File(directory + fileName);

        if (file.exists()) {
            return true;
//            downloadFab.setImageResource(R.drawable.ic_check_white);
        }else {
            return false;
//            downloadFab.setImageResource(R.drawable.ic_download_white);
        }
    }

    private void initDownLoad() {
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);//启动服务
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        /**
         * 6.0 动态权限检查
         */
        if (ContextCompat.checkSelfPermission(PhotoDeatilActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            //请求权限
            ActivityCompat.requestPermissions(PhotoDeatilActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        }
        //当下载完成时候，接收RxBus，更换图标
        mRxManager.on("Download Success", new Action1<String>() {
            @Override
            public void call(String s) {
                if ("Download Success".equals(s)) {
                    LogUtil.debug(TAG, "接收到下载完成的消息！");
                    downloadFab.setImageResource(R.drawable.ic_done_white);
                }
            }
        });

    }

    @Override
    public void leftTopBackListener() {
        finish();
    }

    @Override
    public void rightTopBarViewListener() {

    }

    /**
     * 动态权限 回调方法
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用该功能！", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
