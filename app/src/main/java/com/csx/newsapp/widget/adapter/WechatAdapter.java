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
import com.csx.newsapp.bean.WechatBean;
import com.fifedu.rxfiflibrary.utils.LogUtil;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/4.
 *
 * 微信精选  adapter
 */

public class WechatAdapter extends RecyclerView.Adapter<WechatAdapter.ViewHolder> {
    private static final String TAG = "WechatAdapter";
    private Context context;
    private List<WechatBean.ResultBean.ListBean> list;

    private RecyclerItemClickListener onItemClick;

    public void setOnItemClick(RecyclerItemClickListener onItemClick) {
        this.onItemClick = onItemClick;
    }

    public WechatAdapter(Context context, List<WechatBean.ResultBean.ListBean> list) {
        this.list = list;
        this.context = context;
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
        if (list == null || list.size() == 0) {
            LogUtil.debug(TAG,"微信精选 adapter onBindViewHolder 异常");
            return;
        }

        holder.title_txt.setText(list.get(position).getTitle());
        holder.content_txt.setText(list.get(position).getSource());

        Glide.with(context)
                .load(list.get(position).getFirstImg())
                .error(R.mipmap.ic_launcher)//错误时显示的图片
                .into(holder.left_img);

        holder.cardview_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClickListener(v, position);
            }
        });

        holder.cardview_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClick.onItemLongClickListener(v, position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView left_img;
        private TextView title_txt;
        private TextView content_txt;
        private CardView cardview_layout;

        public ViewHolder(final View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            left_img = (ImageView) itemView.findViewById(R.id.left_img);
            title_txt = (TextView) itemView.findViewById(R.id.title_txt);
            content_txt = (TextView) itemView.findViewById(R.id.content_txt);
            cardview_layout = (CardView) itemView.findViewById(R.id.cardview_layout);

        }
    }


}
