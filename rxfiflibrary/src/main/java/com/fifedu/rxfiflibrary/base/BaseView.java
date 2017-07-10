package com.fifedu.rxfiflibrary.base;

/**
 * des:baseview
 * Created by weidingqiang
 * on 2016.07.11:53
 */
public interface BaseView {
    /*******内嵌加载*******/
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
