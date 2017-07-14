package com.csx.newsapp.ui.main.contract;

import com.csx.newsapp.bean.ZhiHuBean;
import com.fifedu.rxfiflibrary.base.BaseModel;
import com.fifedu.rxfiflibrary.base.BasePresenter;
import com.fifedu.rxfiflibrary.base.BaseView;

import rx.Observable;

/**
 * Created by cuishuxiang on 2017/7/12.
 * 知乎 contract
 */

public interface ZhiHuContract {
    interface Model extends BaseModel {
        Observable<ZhiHuBean> zhiHu();
    }

    interface View extends BaseView {
        void returnZhiHuBean(ZhiHuBean zhiHuBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void zhiHuRequest();
    }

}
