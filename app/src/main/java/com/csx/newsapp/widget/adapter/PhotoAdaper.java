package com.csx.newsapp.widget.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.csx.newsapp.R;
import com.csx.newsapp.bean.PhotoBean;
import com.csx.newsapp.ui.main.activity.PhotoDeatilActivity;
import com.csx.newsapp.widget.base_recycleview_adapter.BaseRVViewHolder;
import com.csx.newsapp.widget.base_recycleview_adapter.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/11.
 *
 *  照片adapter ，使用封装的adapter
 */

public class PhotoAdaper extends BaseRecyclerViewAdapter<PhotoBean.ResultsBean> {
    private Context context;

    public PhotoAdaper(Context context, List<PhotoBean.ResultsBean> data, int layoutId) {

        super(context, data, layoutId);
        this.context = context;
    }

    @Override
    public void onBind(BaseRVViewHolder holder, final PhotoBean.ResultsBean resultsBean, final int position) {
        ImageView imageView = holder.getView(R.id.photo_img);
        Glide.with(context)
                .load(resultsBean.getUrl())
                .error(R.drawable.ic_empty_picture)
                .into(imageView);

        holder.setOnClickListener(R.id.photo_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "点击了：" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, PhotoDeatilActivity.class);
                intent.putExtra("img_url", resultsBean.getUrl());
                context.startActivity(intent);
            }
        });
    }
}
