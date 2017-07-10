package com.csx.newsapp.ui.main.contract;

import com.csx.newsapp.bean.TopNewsBean;
import com.fifedu.rxfiflibrary.base.BaseModel;
import com.fifedu.rxfiflibrary.base.BasePresenter;
import com.fifedu.rxfiflibrary.base.BaseView;

import rx.Observable;

/**
 * Created by cuishuxiang on 2017/7/6.
 */

public interface TopNewsContract {

    interface Model extends BaseModel {
        Observable<TopNewsBean> getTopNews(String key, String topstring);
    }

    interface View extends BaseView {
        void returnTopNewsData(TopNewsBean topNewsBean);
    }

    abstract class Presenter extends BasePresenter<TopNewsContract.View, TopNewsContract.Model> {
        public abstract void topNewsRequest(String key,String topstring);
    }
}
