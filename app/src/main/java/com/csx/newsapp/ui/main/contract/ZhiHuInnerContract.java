package com.csx.newsapp.ui.main.contract;

import com.csx.newsapp.bean.ZhiHuInnerBean;
import com.fifedu.rxfiflibrary.base.BaseModel;
import com.fifedu.rxfiflibrary.base.BasePresenter;
import com.fifedu.rxfiflibrary.base.BaseView;

import rx.Observable;

/**
 * Created by cuishuxiang on 2017/7/12.
 */

public interface ZhiHuInnerContract {
    interface View extends BaseView {
        void returnZhiHuInnerBean(ZhiHuInnerBean zhiHuInnerBean);
    }

    interface Model extends BaseModel {
        Observable<ZhiHuInnerBean> getZhiHuInner(String id);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void returnZHInnerRequest(String id);
    }

}
