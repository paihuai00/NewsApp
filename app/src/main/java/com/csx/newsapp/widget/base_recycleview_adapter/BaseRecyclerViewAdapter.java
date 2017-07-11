package com.csx.newsapp.widget.base_recycleview_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/11.
 * <p>
 * 封装一个 recycleview adapter
 */


public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRVViewHolder> {
    private Context context;
    private List<T> data;//数据使用泛型
    private int layoutId;

    public BaseRecyclerViewAdapter(Context context, List<T> data, int layoutId) {
        this.context = context;
        this.data = data;
        this.layoutId = layoutId;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return this.data;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //从holder 基类中获取holder
        return BaseRVViewHolder.getHolder(context,parent,layoutId);
    }

    @Override
    public void onBindViewHolder(BaseRVViewHolder holder, int position) {
        //调用由子类实现的抽象方法，将操作下放到子类中
        onBind(holder,data.get(position),position);
    }

    //抽象方法，让子类继承实现
    public abstract void onBind(BaseRVViewHolder holder, T t, int position);
}
