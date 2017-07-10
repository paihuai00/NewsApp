package com.csx.newsapp.ui.main.presenter;

import com.csx.newsapp.R;
import com.csx.newsapp.bean.WechatBean;
import com.csx.newsapp.rxbase.RxSubscriber;
import com.csx.newsapp.ui.main.contract.WeChatContract;
import com.fifedu.rxfiflibrary.utils.LogUtil;

/**
 * Created by cuishuxiang on 2017/7/1.
 */

public class WeChatPresenter extends WeChatContract.Presenter{
    private static final String TAG = "WeChatPresenter";
    @Override
    public void weChatRequest(String key, String page, String page_size) {

        mRxManage.add(mModel.weChat(key, page, page_size).subscribe(new RxSubscriber<WechatBean>(mContext, false) {

            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onNext(WechatBean wechatBeanBaseRespose) {
                mView.returnWeChatResponse(wechatBeanBaseRespose);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                LogUtil.debug(TAG,message);
            }
        }));
    }
}
