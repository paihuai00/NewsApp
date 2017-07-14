package com.csx.newsapp.ui.main.presenter;

import com.csx.newsapp.bean.ZhiHuInnerBean;
import com.csx.newsapp.rxbase.RxSubscriber;
import com.csx.newsapp.ui.main.contract.ZhiHuInnerContract;
import com.fifedu.rxfiflibrary.utils.LogUtil;

/**
 * Created by cuishuxiang on 2017/7/12.
 */

public class ZhiHuInnerPresenter extends ZhiHuInnerContract.Presenter {
    private static final String TAG = "ZhiHuInnerPresenter";
    @Override
    public void returnZHInnerRequest(String id) {
        mRxManage.add(mModel.getZhiHuInner(id).subscribe(new RxSubscriber<ZhiHuInnerBean>(mContext, false) {
            @Override
            public void onStart() {
                super.onStart();
                LogUtil.debug(TAG,"onStart");
            }

            @Override
            protected void _onNext(ZhiHuInnerBean zhiHuInnerBean) {
                LogUtil.debug(TAG,"zhiHuInnerBean:");
                mView.returnZhiHuInnerBean(zhiHuInnerBean);

            }

            @Override
            protected void _onError(String message) {
                LogUtil.debug(TAG,"_onError:");
            }
        }));
    }
}
