package com.csx.newsapp.ui.main.model;

import com.csx.newsapp.api.Api;
import com.csx.newsapp.api.HostType;
import com.csx.newsapp.bean.ZhiHuInnerBean;
import com.csx.newsapp.ui.main.contract.ZhiHuInnerContract;
import com.fifedu.rxfiflibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by cuishuxiang on 2017/7/12.
 */

public class ZhiHuInnerModel implements ZhiHuInnerContract.Model {
    @Override
    public Observable<ZhiHuInnerBean> getZhiHuInner(String id) {
        return Api.getDefault(HostType.ZHIHU_INNER)
                .getKnowsInners(id)
                .map(new Func1<ZhiHuInnerBean, ZhiHuInnerBean>() {
                    @Override
                    public ZhiHuInnerBean call(ZhiHuInnerBean zhiHuInnerBean) {
                        return zhiHuInnerBean;
                    }
                })
                .compose(RxSchedulers.<ZhiHuInnerBean>io_main());
    }
}
