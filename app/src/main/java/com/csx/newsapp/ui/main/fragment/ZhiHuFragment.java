package com.csx.newsapp.ui.main.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.csx.newsapp.R;
import com.csx.newsapp.bean.ZhiHuBean;
import com.csx.newsapp.ui.main.activity.ZhiHuInnerActivity;
import com.csx.newsapp.ui.main.contract.ZhiHuContract;
import com.csx.newsapp.ui.main.model.ZhiHuModel;
import com.csx.newsapp.ui.main.presenter.ZhiHuPresenter;
import com.csx.newsapp.widget.adapter.RecyclerItemClickListener;
import com.csx.newsapp.widget.adapter.ZhiHuAdapter;
import com.fifedu.rxfiflibrary.base.BaseFragment;
import com.fifedu.rxfiflibrary.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/7/12.
 * <p>
 * 知乎
 */

public class ZhiHuFragment extends BaseFragment<ZhiHuPresenter, ZhiHuModel> implements ZhiHuContract.View {
    private static final String TAG = "ZhiHuFragment";
    @BindView(R.id.zhihu_rv)
    RecyclerView zhihuRv;
    @BindView(R.id.mSwipe)
    SwipeRefreshLayout mSwipe;

    private ZhiHuAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private List<ZhiHuBean.StoriesBean> storiesBeanList;
    private List<ZhiHuBean.TopStoriesBean> topStoriesBeanList;


    @Override
    protected int getLayoutResource() {
        return R.layout.fg_zhihu_layout;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mPresenter.zhiHuRequest();//数据请求

        mSwipe.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        storiesBeanList = new ArrayList<>();
        topStoriesBeanList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getContext());

        adapter = new ZhiHuAdapter(getContext(), topStoriesBeanList, storiesBeanList);

        adapter.setRecyclerItemClickListener(new RecyclerItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Intent intent = new Intent(getContext(), ZhiHuInnerActivity.class);

                if (position <storiesBeanList.size()) {
//                    Toast.makeText(getContext(), "这是：" + position, Toast.LENGTH_SHORT).show();
                    intent.putExtra("id", storiesBeanList.get(position).getId()+"");
                    intent.putExtra("title", storiesBeanList.get(position).getTitle());
                }else {
                    int nowPostion = position - storiesBeanList.size();
//                    Toast.makeText(getContext(), "这是：" +nowPostion , Toast.LENGTH_SHORT).show();
                    intent.putExtra("id", topStoriesBeanList.get(nowPostion).getId()+"");
                    intent.putExtra("title", topStoriesBeanList.get(nowPostion).getTitle());
                }

                startActivity(intent);
            }

            @Override
            public void onItemLongClickListener(View view, int position) {

            }
        });
        zhihuRv.setLayoutManager(linearLayoutManager);
        zhihuRv.setAdapter(adapter);

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                topStoriesBeanList.clear();
                storiesBeanList.clear();
                adapter.notifyDataSetChanged();

                mPresenter.zhiHuRequest();

                mSwipe.setEnabled(false);
            }
        });

    }

    @Override
    public void returnZhiHuBean(ZhiHuBean zhiHuBean) {
        LogUtil.debug(TAG,"returnZhiHuBean");
        storiesBeanList.addAll(zhiHuBean.getStories());
        topStoriesBeanList.addAll(zhiHuBean.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading(String title) {
        LogUtil.debug(TAG, "showLoading:" + title);
    }

    @Override
    public void stopLoading() {
        LogUtil.debug(TAG, "stopLoading");
    }

    @Override
    public void showErrorTip(String msg) {
        LogUtil.debug(TAG, "showErrorTip:" + msg);
    }

}
