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
import com.csx.newsapp.bean.TopNewsBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/6.
 * 今日头条 adapter
 */

public class TopNewsAdapter extends RecyclerView.Adapter<TopNewsAdapter.ViewHolder> {

    private Context context;
    private List<TopNewsBean.ResultBean.DataBean> dataBeanList;

    private RecyclerItemClickListener listener;

    public void setOnItemClickListener(RecyclerItemClickListener listener) {
        this.listener = listener;
    }

    public TopNewsAdapter(Context context, List<TopNewsBean.ResultBean.DataBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_fg_topnews, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context)
                .load(dataBeanList.get(position).getThumbnail_pic_s())
                .error(R.mipmap.ic_launcher)
                .into(holder.topnew_img);

        holder.topnew_title.setText(dataBeanList.get(position).getTitle());

        holder.topnew_name.setText(dataBeanList.get(position).getAuthor_name());

        holder.topnew_sorce.setText(dataBeanList.get(position).getCategory());

        holder.topnews_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(v, position);
            }
        });

        holder.topnews_cardview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClickListener(v,position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView topnew_img;
        private TextView topnew_title;
        private TextView topnew_name;
        private TextView topnew_sorce;

        private CardView topnews_cardview;
        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);

            topnew_img = (ImageView) itemView.findViewById(R.id.topnew_img);
            topnew_title = (TextView) itemView.findViewById(R.id.topnew_title);
            topnew_name = (TextView) itemView.findViewById(R.id.topnew_name);
            topnew_sorce = (TextView) itemView.findViewById(R.id.topnew_sorce);

            topnews_cardview = (CardView) itemView.findViewById(R.id.topnews_cardview);
        }
    }
}
