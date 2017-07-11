package com.csx.newsapp.ui.main.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.csx.newsapp.R;
import com.csx.newsapp.bean.PhotoBean;
import com.csx.newsapp.ui.main.contract.PhotoContract;
import com.csx.newsapp.ui.main.model.PhotoModel;
import com.csx.newsapp.ui.main.presenter.PhotoPresenter;
import com.csx.newsapp.widget.adapter.PhotoAdaper;
import com.fifedu.rxfiflibrary.base.BaseFragment;
import com.fifedu.rxfiflibrary.utils.LogUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/6/30.
 * <p>
 * 图片页面
 */

public class PhotoFragment extends BaseFragment<PhotoPresenter, PhotoModel> implements PhotoContract.View {
    private static final String TAG = "PhotoFragment";
    @BindView(R.id.photo_rv)
    RecyclerView photoRv;
    @BindView(R.id.fab_btn)
    FloatingActionButton fabBtn;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private PhotoAdaper adaper;
    private List<PhotoBean.ResultsBean> resultsBeanList;
    @BindView(R.id.mSwipe)
    SwipeRefreshLayout mSwipe;
    SwipeRefreshHelper mHelper;
    RecyclerAdapterWithHF adapterWithHF;

    private Calendar calendar;
    private int currentMonth;
    private int currentDay;

    @Override
    protected int getLayoutResource() {
        return R.layout.fg_photo_layout;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        calendar = Calendar.getInstance();
        currentMonth = calendar.get(Calendar.MONTH) + 1;
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        mPresenter.photoRequest(currentMonth + "/" + currentDay);//动态url
        mSwipe.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mHelper = new SwipeRefreshHelper(mSwipe);
        //刷新
        mHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                resultsBeanList.clear();
                currentMonth = calendar.get(Calendar.MONTH) + 1;
                currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                adaper.notifyDataSetChanged();

                mPresenter.photoRequest(currentMonth + "/" + currentDay);
                mHelper.refreshComplete();

            }
        });

        mHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                if (mSwipe.isRefreshing()) {
                    return;//正在下拉刷新的时候不允许上拉刷新
                }
                currentMonth -= 1;
                currentDay -= 1;
                mPresenter.photoRequest(currentMonth + "/" + currentDay);
                mHelper.loadMoreComplete(true);
                LogUtil.debug(TAG, "上拉刷新 currentMonth:" + currentMonth + " currentDay:" + currentDay);
            }
        });

        resultsBeanList = new ArrayList<>();

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        photoRv.setLayoutManager(staggeredGridLayoutManager);

        adaper = new PhotoAdaper(getContext(), resultsBeanList, R.layout.item_photo);

        adapterWithHF = new RecyclerAdapterWithHF((RecyclerView.Adapter) adaper);
        photoRv.setAdapter(adapterWithHF);

        //点击按钮，回到顶部
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoRv.scrollToPosition(0);
            }
        });
    }


    @Override
    public void returnPhotoBean(PhotoBean photoBean) {
        Log.d(TAG, "returnPhotoBean: " + photoBean.getResults().size());
        if (photoBean == null) {
            LogUtil.debug(TAG, "图片页面，数据解析错误null");
            return;
        }
        if (photoBean.getResults().size() == 0) {
            LogUtil.debug(TAG, "图片页面，数据size为 0");
            return;
        }
        resultsBeanList.addAll(photoBean.getResults());
        adaper.notifyDataSetChanged();
        mHelper.setLoadMoreEnable(true);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

}