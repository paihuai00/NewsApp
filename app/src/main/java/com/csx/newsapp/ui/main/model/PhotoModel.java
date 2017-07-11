package com.csx.newsapp.ui.main.model;

import com.csx.newsapp.api.Api;
import com.csx.newsapp.api.HostType;
import com.csx.newsapp.bean.PhotoBean;
import com.csx.newsapp.ui.main.contract.PhotoContract;
import com.fifedu.rxfiflibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by cuishuxiang on 2017/7/10.
 */

public class PhotoModel implements PhotoContract.Model {
    @Override
    public Observable<PhotoBean> getPhotos(String url) {
        return Api.getDefault(HostType.PHOTO)
                .getPhotos(url)
                .map(new Func1<PhotoBean, PhotoBean>() {
                    @Override
                    public PhotoBean call(PhotoBean photoBean) {
                        return photoBean;
                    }
                })
                .compose(RxSchedulers.<PhotoBean>io_main());
    }
}
