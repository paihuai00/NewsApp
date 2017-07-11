package com.fifedu.rxfiflibrary.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.blankj.utilcode.util.BarUtils;
import com.fifedu.rxfiflibrary.R;
import com.fifedu.rxfiflibrary.baserx.RxManager;
import com.fifedu.rxfiflibrary.managers.AppManagers;
import com.fifedu.rxfiflibrary.utils.TUtil;
import com.umeng.analytics.MobclickAgent;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;




/**
 * 基类
 */

/***************使用例子*********************/
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AutoLayoutActivity {
    public T mPresenter;
    public E mModel;
    public Context mContext;
    public RxManager mRxManager;
    private boolean isConfigChange=false;

    private Unbinder unbinder;

    //activity 管理器
    private AppManagers appManagers;

    //退出事件
    private long exitTime = 0;

    //顶部状态栏高度
    protected int statusBarHeight;

    //顶部状态栏view
    private View statusBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null && getSupportActionBar().isShowing()) {
            getSupportActionBar().hide();
        }
        isConfigChange=false;
        mRxManager=new RxManager();
        appManagers = AppManagers.getInstance();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        unbinder=ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel=TUtil.getT(this,1);
        if(mPresenter!=null){
            mPresenter.mContext=this;
        }
        this.initPresenter();
        this.initView();

    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        //设置昼夜主题
        initTheme();
        // 把actvity放到application栈中管理
        appManagers.addActivity(this);
        // 无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
//        SetStatusBarColor();

    }
    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int getLayoutId();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();
    //初始化view
    public abstract void initView();


    /**
     * 设置主题
     */
    private void initTheme() {
//        ChangeModeController.setTheme(this, R.style.DayTheme, R.style.NightTheme);
    }
    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(){
//        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this,R.color.main_color));
    }
    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(int color){
//        StatusBarCompat.setStatusBarColor(this,color);
    }
    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar(){
//        StatusBarCompat.translucentStatusBar(this);

        //设置浸式状态栏，在布局中添加一个view 动态设置颜色，高度
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && findViewById(R.id.status_bar_top) != null) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            statusBarHeight = BarUtils.getStatusBarHeight(this.getBaseContext());

            statusBar = findViewById(R.id.status_bar_top);
            ViewGroup.LayoutParams params2 = statusBar.getLayoutParams();
            params2.height = statusBarHeight;
            statusBar.setLayoutParams(params2);
            statusBar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 关闭activity
     */
    protected void killActivity(Activity activity) {
        appManagers.killActivity(activity);
    }

    /**
     * 通过类名启动Activity
     *
     * @param pClass
     */
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    protected void openActivity(Class<?> pClass, Bundle bundle) {
        Intent intent = new Intent(this, pClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        startActivity(intent);
    }

    protected void openActivity(String action) {
        openActivity(action, null);
    }

    /**
     * 通过Action启动Activity，并且含有Bundle数据
     */
    protected void openActivity(String action, Bundle bundle) {
        Intent intent = new Intent(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //友盟统计
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //友盟统计
        MobclickAgent.onPause(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange=true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        if(mRxManager!=null) {
            mRxManager.clear();
        }
        if(!isConfigChange){
            AppManagers.getInstance().killActivity(this);
        }
        unbinder.unbind();
    }

    //-------------------------------------------------------------------//
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            appManagers.exit(this);
        }
    }
}
