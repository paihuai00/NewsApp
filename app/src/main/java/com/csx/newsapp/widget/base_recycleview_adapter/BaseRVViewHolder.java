package com.csx.newsapp.widget.base_recycleview_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by cuishuxiang on 2017/7/11.
 *
 * 向外层暴露getView()、setOnclickListener()两个方法
 */

public class BaseRVViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private SparseArray<View> viewSparseArray;//存放item中的控件

    public BaseRVViewHolder(View itemView) {
        super(itemView);
        AutoUtils.auto(itemView);//使用Auto布局时，需要添加
        this.itemView = itemView;
        viewSparseArray = new SparseArray<>();
    }

    //提供给adapter调用，返回holder
    public static <T extends BaseRVViewHolder> T getHolder(Context context, ViewGroup viewGroup, int layoutId) {
        return (T) new BaseRVViewHolder(LayoutInflater.from(context).inflate(layoutId, viewGroup, false));
    }

    //根据Item中的控件Id获取控件
    public <T extends View> T getView(int viewId){
        //使用SparseArray进行优化
        View childreView = viewSparseArray.get(viewId);
        if (childreView == null){
            childreView = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, childreView);
        }
        return (T) childreView;
    }
    //根据Item中的控件Id向控件添加事件监听
    public BaseRVViewHolder setOnClickListener(int viewId, View.OnClickListener listener){
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
