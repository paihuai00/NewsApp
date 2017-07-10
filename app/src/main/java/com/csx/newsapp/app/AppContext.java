package com.csx.newsapp.app;

import android.os.Environment;

import com.bumptech.glide.RequestManager;
import com.fifedu.rxfiflibrary.app.AppConfig;
import com.fifedu.rxfiflibrary.app.AppConstants;
import com.fifedu.rxfiflibrary.app.BaseApplication;
import com.fifedu.rxfiflibrary.app.CrashHandler;
import com.fifedu.rxfiflibrary.utils.LogToFileUtil;
import com.fifedu.rxfiflibrary.utils.LogUtil;

/**
 * 作者：weidingqiang on 2017/4/21 14:50
 */

public class AppContext extends BaseApplication {

    private static final String TAG = AppContext.class.getSimpleName();

    private static AppContext instance;

    //Glide  图片请求
    public RequestManager appGlide;

    private boolean login;

    @Override
    public void onCreate() {
        super.onCreate();

        initlog();
        init();
        initLogin();
//        initPlatform();
    }

    private void initlog(){
        instance = this;
        //设置缓存路径
        String cachePath;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            // /storage/emulated/0/Android/data/com.fifedu.mhk/cache

            try {
                cachePath = getExternalCacheDir().getPath();
            }catch (Exception ex)
            {
                cachePath = getCacheDir().getPath();
            }

        } else {
            // /data/data/com.fifedu.mhk/cache
            cachePath = getCacheDir().getPath();
        }
        AppConstants.initPath(cachePath);

        // 初始化日志写文件的工具
        LogToFileUtil.init();
        LogUtil.debug("TAG", "AppContext Created");
        LogUtil.debug("TAG", "Product Model: " + android.os.Build.MODEL + "\nAPI Level: "
                + android.os.Build.VERSION.SDK + "\nVersion: " + android.os.Build.VERSION.RELEASE);


    }

    private void init() {

//        LogUtil.debug(TAG,"配置多态布局");
//        PageStateLayout.Builder.setErrorView(R.layout.page_state_error)
//                .setEmptyView(R.layout.page_state_empty);
        //初始化volley

        AppConfig.getAppConfig(this);

        LogToFileUtil.clearOldFiles();

        // 获取异常信息捕获类实例

//        开发期间不要监听 稍后放开
        CrashHandler crashHandler = CrashHandler.getInstance(getApplicationContext());

        crashHandler.setICrashHandlerListener(this);
        // 初始化
        crashHandler.init(getApplicationContext());

    }

    private void initLogin() {
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(this).remove(key);
    }

    public boolean isLogin() {
        return login;
    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }

}
