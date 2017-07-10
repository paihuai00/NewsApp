package com.csx.newsapp.ui.main.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.csx.newsapp.R;
import com.csx.newsapp.app.AppContext;
import com.csx.newsapp.bean.WechatBean;
import com.csx.newsapp.ui.main.activity.WeChatWebViewActivity;
import com.csx.newsapp.ui.main.contract.WeChatContract;
import com.csx.newsapp.ui.main.model.WeChatModel;
import com.csx.newsapp.ui.main.presenter.WeChatPresenter;
import com.csx.newsapp.widget.adapter.RecyclerItemClickListener;
import com.csx.newsapp.widget.adapter.WechatAdapter;
import com.fifedu.rxfiflibrary.base.BaseFragment;
import com.fifedu.rxfiflibrary.utils.LogUtil;
import com.fifedu.rxfiflibrary.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
/**
 * Created by cuishuxiang on 2017/6/30.
 * 微信精选
 */

public class WechatFragment extends BaseFragment<WeChatPresenter, WeChatModel> implements WeChatContract.View {
    private static final String TAG = WechatFragment.class.getSimpleName();
    @BindView(R.id.wechat_rv)
    RecyclerView wechatRv;//显示的列表
    @BindView(R.id.mSwipe)
    SwipeRefreshLayout mSwipe;
    private SwipeRefreshHelper swipeRefreshHelper;
    private LinearLayoutManager linearLayoutManager;
    private WechatAdapter adapter;
    private RecyclerAdapterWithHF adapterWithHF;

    private List<WechatBean.ResultBean.ListBean> weChatList;

    private String page;
    private AppContext app;

    private int currentPage = 0;

    @Override
    protected int getLayoutResource() {
        return R.layout.fg_wechat_layout;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //实例化
        app = AppContext.getInstance();
        weChatList = new ArrayList<>();
        loadData(currentPage);//初始化的时候 加载第0页

        linearLayoutManager = new LinearLayoutManager(getContext());
        wechatRv.setLayoutManager(linearLayoutManager);

        mSwipe.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshHelper = new SwipeRefreshHelper(mSwipe);

        adapter = new WechatAdapter(getContext(), weChatList);
        adapter.setOnItemClick(new RecyclerItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), WeChatWebViewActivity.class);
                intent.putExtra("wb_url", weChatList.get(position).getUrl());
                intent.putExtra("title", weChatList.get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onItemLongClickListener(View view, int position) {
                //长按点击事件
            }
        });
        adapterWithHF = new RecyclerAdapterWithHF((RecyclerView.Adapter) adapter);
        wechatRv.setAdapter(adapterWithHF);

        //下拉刷新
        swipeRefreshHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                currentPage = 0;//首先重置数据
                weChatList.clear();
                adapter.notifyDataSetChanged();

                loadData(currentPage);

                swipeRefreshHelper.refreshComplete();
            }
        });

        //上拉刷新
        swipeRefreshHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                currentPage += 1;
                loadData(currentPage);
                swipeRefreshHelper.loadMoreComplete(true);//加载完成
            }
        });
    }
    //请求数据
    private void loadData(int page) {
        //聚合数据的key直接写死到本地。请求 默认每页10条数据
        mPresenter.weChatRequest("4b00f82ba05b842bb8796d9d6272be2c", String.valueOf(page), "10");
    }

    @Override
    public void returnWeChatResponse(WechatBean wechatBeanBaseResposeechatBean) {
        LogUtil.debug(TAG, wechatBeanBaseResposeechatBean.toString());
        List<WechatBean.ResultBean.ListBean> listBeen = wechatBeanBaseResposeechatBean.getResult().getList();

        if (listBeen != null || listBeen.size() != 0) {
            weChatList.addAll(listBeen);
        }

        //每次请求10条数据，如果少于10条，就说明没有数据
        if (listBeen.size() == 10) {
            swipeRefreshHelper.setLoadMoreEnable(true);
        }else {
            swipeRefreshHelper.setLoadMoreEnable(false);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading(String title) {
        LoadingDialog.showDialogForLoading(getActivity(), title, false);
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