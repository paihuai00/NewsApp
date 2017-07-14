package com.csx.newsapp.widget.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.csx.newsapp.R;
import com.csx.newsapp.bean.ZhiHuBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/12.
 */

public class ZhiHuAdapter extends RecyclerView.Adapter<ZhiHuAdapter.ViewHolder> {

    private List<ZhiHuBean.StoriesBean> storiesBeanList;
    private List<ZhiHuBean.TopStoriesBean> topStoriesBeanList;
    private Context context;

    private RecyclerItemClickListener recyclerItemClickListener;

    public void setRecyclerItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    public ZhiHuAdapter(Context context, List<ZhiHuBean.TopStoriesBean> topStoriesBeanList, List<ZhiHuBean.StoriesBean> storiesBeanList) {
        this.context = context;
        this.topStoriesBeanList = topStoriesBeanList;
        this.storiesBeanList = storiesBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_wechat, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //将俩个列表数据，添加到一个list中
        if (position < storiesBeanList.size()) {
            Glide.with(context)
                    .load(storiesBeanList.get(position).getImages().get(0))
                    .error(R.drawable.ic_empty_picture)
                    .into(holder.left_img);

            holder.title_txt.setText(storiesBeanList.get(position).getTitle());

            holder.cardview_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClickListener.onItemClickListener(v, position);
                }
            });
        } else {
            final int nowPosition = position - storiesBeanList.size();
            Glide.with(context)
                    .load(topStoriesBeanList.get(nowPosition).getImage())
                    .error(R.drawable.ic_empty_picture)
                    .into(holder.left_img);

            holder.title_txt.setText(topStoriesBeanList.get(nowPosition).getTitle());

            holder.cardview_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClickListener.onItemClickListener(v, position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return storiesBeanList.size() + topStoriesBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView left_img;
        TextView title_txt;
        CardView cardview_layout;
        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            left_img = (ImageView) itemView.findViewById(R.id.left_img);
            title_txt = (TextView) itemView.findViewById(R.id.title_txt);
            cardview_layout = (CardView) itemView.findViewById(R.id.cardview_layout);
        }
    }
}

