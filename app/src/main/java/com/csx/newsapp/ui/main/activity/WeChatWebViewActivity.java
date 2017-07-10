package com.csx.newsapp.ui.main.activity;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.StringUtils;
import com.csx.newsapp.R;
import com.csx.newsapp.widget.actionbar.MainTopBar;
import com.csx.newsapp.widget.actionbar.TopBarImp;
import com.fifedu.rxfiflibrary.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/7/4.
 * <p>
 * 微信列表，点击item  跳转的WebView
 */

public class WeChatWebViewActivity extends BaseActivity implements TopBarImp{
    private static final String TAG = "WeChatWebViewActivity";

    @BindView(R.id.wechat_webview)
    WebView wechatWebview;
    WebSettings webSettings;

    @BindView(R.id.web_topbar)
    MainTopBar webTopbar;
    @BindView(R.id.web_progressbar)
    ProgressBar webProgressbar;

    private String wb_url;

    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wc_webview;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        wb_url = getIntent().getStringExtra("wb_url");
        title = getIntent().getStringExtra("title");
        webTopbar.setTopBarImp(this);
        if (!TextUtils.isEmpty(title)) {
            webTopbar.getMiddleTextView().setText(title);
        }

        webSettings = wechatWebview.getSettings();

        webSettings.setJavaScriptEnabled(true);//设置支持javaScript
        // 设置可以访问文件
        webSettings.setAllowFileAccess(true);
        // 设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);

        // 设置Web视图
        wechatWebview.setWebViewClient(new WebViewClient());

        wechatWebview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if (newProgress == 100) {
                    webProgressbar.setProgress(newProgress);
                    webProgressbar.setVisibility(View.INVISIBLE);
                }else {
                    if (View.INVISIBLE == webProgressbar.getVisibility()) {
                        webProgressbar.setVisibility(View.VISIBLE);
                    }
                    webProgressbar.setProgress(newProgress);
                }

                super.onProgressChanged(view, newProgress);
            }
        });

        if (!StringUtils.isEmpty(wb_url)) {
            wechatWebview.loadUrl(wb_url);
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
