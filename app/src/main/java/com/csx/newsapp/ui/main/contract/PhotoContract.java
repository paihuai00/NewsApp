package com.csx.newsapp.ui.main.contract;

import com.csx.newsapp.bean.PhotoBean;
import com.fifedu.rxfiflibrary.base.BaseModel;
import com.fifedu.rxfiflibrary.base.BasePresenter;
import com.fifedu.rxfiflibrary.base.BaseView;

import rx.Observable;

/**
 * Created by cuishuxiang on 2017/7/10.
 */

public interface PhotoContract {
    interface Model extends BaseModel {
        Observable<PhotoBean> getPhotos(String url);
    }

    interface View extends BaseView {
        void returnPhotoBean(PhotoBean photoBean);
    }

    abstract class PhotoPresenter extends BasePresenter<PhotoContract.View, PhotoContract.Model> {
        public abstract void photoRequest(String url);
    }


}
