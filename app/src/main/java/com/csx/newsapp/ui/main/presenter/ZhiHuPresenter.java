package com.csx.newsapp.ui.main.presenter;

import com.csx.newsapp.bean.ZhiHuBean;
import com.csx.newsapp.rxbase.RxSubscriber;
import com.csx.newsapp.ui.main.contract.ZhiHuContract;
import com.fifedu.rxfiflibrary.utils.LogUtil;

/**
 * Created by cuishuxiang on 2017/7/12.
 */

public class ZhiHuPresenter extends ZhiHuContract.Presenter {
    private static final String TAG = "ZhiHuPresenter";
    @Override
    public void zhiHuRequest() {
        mRxManage.add(mModel.zhiHu().subscribe(new RxSubscriber<ZhiHuBean>(mContext, false) {
            @Override
            public void onStart() {
                super.onStart();
                LogUtil.debug(TAG,"onStart");
            }

            @Override
            protected void _onNext(ZhiHuBean zhiHuBean) {
                LogUtil.debug(TAG,"_onNext");
                mView.returnZhiHuBean(zhiHuBean);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                LogUtil.debug(TAG,"_onError");
            }
        }));
    }
}
