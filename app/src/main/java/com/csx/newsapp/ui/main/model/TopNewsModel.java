package com.csx.newsapp.ui.main.model;

import com.csx.newsapp.api.Api;
import com.csx.newsapp.api.HostType;
import com.csx.newsapp.bean.TopNewsBean;
import com.csx.newsapp.ui.main.contract.TopNewsContract;
import com.fifedu.rxfiflibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by cuishuxiang on 2017/7/6.
 */

public class TopNewsModel implements TopNewsContract.Model {
    @Override
    public Observable<TopNewsBean> getTopNews(String key, String topstring) {
        return Api.getDefault(HostType.WE_CHAT)
                .getTopNews(key, topstring)
                .map(new Func1<TopNewsBean, TopNewsBean>() {
                    @Override
                    public TopNewsBean call(TopNewsBean topNewsBean) {
                        return topNewsBean;
                    }
                })
                .compose(RxSchedulers.<TopNewsBean>io_main());
    }
}
