package com.fifedu.rxfiflibrary.base;

import android.content.Context;

import com.fifedu.rxfiflibrary.baserx.RxManager;

/**
 * des:基类presenter
 * Created by weidingqiang
 * on 2017年04月24日15:47:24
 */
public abstract class BasePresenter<T,E>{
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){
    };
    public void onDestroy() {
        mRxManage.clear();
    }
}
