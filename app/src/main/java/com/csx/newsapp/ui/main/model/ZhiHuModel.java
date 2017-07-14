package com.csx.newsapp.ui.main.model;

import com.csx.newsapp.api.Api;
import com.csx.newsapp.api.HostType;
import com.csx.newsapp.bean.ZhiHuBean;
import com.csx.newsapp.ui.main.contract.ZhiHuContract;
import com.fifedu.rxfiflibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by cuishuxiang on 2017/7/12.
 */

public class ZhiHuModel implements ZhiHuContract.Model {
    @Override
    public Observable<ZhiHuBean> zhiHu() {
        return Api.getDefault(HostType.ZHIHU)
                .getKnows()
                .map(new Func1<ZhiHuBean, ZhiHuBean>() {
                    @Override
                    public ZhiHuBean call(ZhiHuBean zhiHuBean) {
                        return zhiHuBean;
                    }
                })
                .compose(RxSchedulers.<ZhiHuBean>io_main());
    }
}
