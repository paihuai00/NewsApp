package com.csx.newsapp.ui.main.activity;

import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.csx.newsapp.R;
import com.csx.newsapp.widget.actionbar.MainTopBar;
import com.csx.newsapp.widget.actionbar.TopBarImp;
import com.fifedu.rxfiflibrary.base.BaseActivity;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/7/10.
 */

public class PhotoDeatilActivity extends BaseActivity implements TopBarImp{

    @BindView(R.id.photoView)
    PhotoView photoView;
    @BindView(R.id.photo_topbar)
    MainTopBar photoTopbar;

    private String img_url;

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        photoTopbar.setTopBarImp(this);
        img_url = getIntent().getStringExtra("img_url");

        if (!TextUtils.isEmpty(img_url)) {

            Glide.with(this)
                    .load(img_url)
                    .error(R.drawable.ic_empty_picture)
                    .into(photoView);

        }
    }

    @Override
    public void leftTopBackListener() {
        finish();
    }

    @Override
    public void rightTopBarViewListener() {

    }
}
