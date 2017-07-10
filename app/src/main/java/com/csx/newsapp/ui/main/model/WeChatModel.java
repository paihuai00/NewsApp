package com.csx.newsapp.ui.main.model;

import com.csx.newsapp.api.Api;
import com.csx.newsapp.api.HostType;
import com.csx.newsapp.bean.WechatBean;
import com.csx.newsapp.ui.main.contract.WeChatContract;
import com.fifedu.rxfiflibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by cuishuxiang on 2017/7/1.
 */

public class WeChatModel implements WeChatContract.Model {

    @Override
    public Observable<WechatBean> weChat(String key,String page, String page_size) {
        return Api.getDefault(HostType.WE_CHAT)
                .weChat(key,page, "10")
                .map(new Func1<WechatBean, WechatBean>() {
                    @Override
                    public WechatBean call(WechatBean wechatBeanBaseRespose) {
                        return wechatBeanBaseRespose;
                    }
                })
                .compose(RxSchedulers.<WechatBean>io_main());
    }


}
