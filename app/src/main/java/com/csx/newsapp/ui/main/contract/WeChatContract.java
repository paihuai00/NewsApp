package com.csx.newsapp.ui.main.contract;

import com.csx.newsapp.bean.WechatBean;
import com.fifedu.rxfiflibrary.base.BaseModel;
import com.fifedu.rxfiflibrary.base.BasePresenter;
import com.fifedu.rxfiflibrary.base.BaseView;

import rx.Observable;

/**
 * Created by cuishuxiang on 2017/7/1.
 */

public interface WeChatContract {

    interface Model extends BaseModel {
        Observable<WechatBean> weChat(String key, String page, String page_size);
    }

    interface View extends BaseView {
        void returnWeChatResponse(WechatBean wechatBeanBaseResposeechatBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void weChatRequest(String key,String page, String page_size);
    }
}
