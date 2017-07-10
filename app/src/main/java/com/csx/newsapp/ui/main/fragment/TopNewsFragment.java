package com.csx.newsapp.ui.main.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.csx.newsapp.R;
import com.csx.newsapp.app.AppContext;
import com.csx.newsapp.bean.TopNewsBean;
import com.csx.newsapp.ui.main.activity.WeChatWebViewActivity;
import com.csx.newsapp.ui.main.contract.TopNewsContract;
import com.csx.newsapp.ui.main.model.TopNewsModel;
import com.csx.newsapp.ui.main.presenter.TopNewsPresenter;
import com.csx.newsapp.widget.adapter.RecyclerItemClickListener;
import com.csx.newsapp.widget.adapter.TopNewsAdapter;
import com.fifedu.rxfiflibrary.base.BaseFragment;
import com.fifedu.rxfiflibrary.utils.LogUtil;
import com.fifedu.rxfiflibrary.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/6/30.
 * 今日头条
 */

public class TopNewsFragment extends BaseFragment<TopNewsPresenter, TopNewsModel> implements TopNewsContract.View {
    private static final String TAG = "TopNewsFragment";

    @BindView(R.id.topnews_rv)
    RecyclerView topnewsRv;
    private LinearLayoutManager linearLayoutManager;
    @BindView(R.id.mSwipe)
    SwipeRefreshLayout mSwipe;
    private TopNewsAdapter adapter;

    private List<TopNewsBean.ResultBean.DataBean> newsList;

    private AppContext app;

    @Override
    protected int getLayoutResource() {
        return R.layout.fg_topnews_layout;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        app = AppContext.getInstance();
        mPresenter.topNewsRequest("f6d595a6bfdf1d565662070090d2c7ba", "top");

        linearLayoutManager = new LinearLayoutManager(getContext());
        mSwipe.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        topnewsRv.setLayoutManager(linearLayoutManager);
        newsList = new ArrayList<>();

        adapter = new TopNewsAdapter(getContext(), newsList);

        adapter.setOnItemClickListener(new RecyclerItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), WeChatWebViewActivity.class);
                intent.putExtra("wb_url", newsList.get(position).getUrl());
                intent.putExtra("title", newsList.get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onItemLongClickListener(View view, int position) {

            }
        });

        topnewsRv.setAdapter(adapter);

        mSwipe.setEnabled(true);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsList.clear();
                adapter.notifyDataSetChanged();
                mPresenter.topNewsRequest("f6d595a6bfdf1d565662070090d2c7ba", "top");
            }
        });

    }

    @Override
    public void returnTopNewsData(TopNewsBean topNewsBean) {
        LogUtil.debug(TAG, topNewsBean.getResult().getData().size() + "");

        List<TopNewsBean.ResultBean.DataBean> list = topNewsBean.getResult().getData();
        if (list.size() != 0) {
            newsList.addAll(list);
            adapter.notifyDataSetChanged();
        }

        if (mSwipe.isRefreshing()) {
            mSwipe.setEnabled(false);
        }
    }

    @Override
    public void showLoading(String title) {
//        LoadingDialog.showDialogForLoading(getActivity(), title, false);
    }

    @Override
    public void stopLoading() {
        LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void showErrorTip(String msg) {
        LoadingDialog.cancelDialogForLoading();
        LogUtil.debug(TAG,"登陆发生错误");
    }

}
