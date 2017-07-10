package com.csx.newsapp.ui.main.presenter;

import com.csx.newsapp.R;
import com.csx.newsapp.bean.TopNewsBean;
import com.csx.newsapp.rxbase.RxSubscriber;
import com.csx.newsapp.ui.main.contract.TopNewsContract;
import com.fifedu.rxfiflibrary.utils.LogUtil;

/**
 * Created by cuishuxiang on 2017/7/6.
 */

public class TopNewsPresenter extends TopNewsContract.Presenter {
    private static final String TAG = "TopNewsPresenter";
    @Override
    public void topNewsRequest(String key, String topstring) {
        mRxManage.add(mModel.getTopNews(key,topstring).subscribe(new RxSubscriber<TopNewsBean>(mContext,false) {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showLoading(mContext.getString(R.string.loading));
                    }

                    @Override
                    protected void _onNext(TopNewsBean topNewsBean) {
                        mView.returnTopNewsData(topNewsBean);
                        mView.stopLoading();
                    }

                    @Override
                    protected void _onError(String message) {
                        LogUtil.debug(TAG,message);
                    }
        })
        );
    }
}
