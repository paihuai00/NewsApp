package com.csx.newsapp.widget.download;

/**
 * Created by cuishuxiang on 2017/7/11.
 * <p>
 * 下载接口，定义5个回调方法
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();

}
