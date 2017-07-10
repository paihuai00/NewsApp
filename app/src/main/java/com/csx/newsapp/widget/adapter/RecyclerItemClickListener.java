package com.csx.newsapp.widget.adapter;

import android.view.View;

/**
 * Created by cuishuxiang on 2017/7/7.
 */

public interface RecyclerItemClickListener {

    void onItemClickListener(View view, int position);

    void onItemLongClickListener(View view, int position);

}
