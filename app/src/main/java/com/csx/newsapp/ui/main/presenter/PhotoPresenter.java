package com.csx.newsapp.ui.main.presenter;

import android.util.Log;

import com.csx.newsapp.bean.PhotoBean;
import com.csx.newsapp.rxbase.RxSubscriber;
import com.csx.newsapp.ui.main.contract.PhotoContract;

/**
 * Created by cuishuxiang on 2017/7/10.
 */

public class PhotoPresenter extends PhotoContract.PhotoPresenter {
    private static final String TAG = "PhotoPresenter";
    @Override
    public void photoRequest(String url) {
        mRxManage.add(mModel.getPhotos(url).subscribe(new RxSubscriber<PhotoBean>(mContext,false) {
            @Override
            public void onStart() {
                super.onStart();
                Log.d(TAG, "onStart: ");
            }

            @Override
            protected void _onNext(PhotoBean photoBean) {
                mView.returnPhotoBean(photoBean);
                Log.d(TAG, "_onNext: ");
            }

            @Override
            protected void _onError(String message) {
                Log.d(TAG, "_onError: ");
            }
        }));
    }
}
