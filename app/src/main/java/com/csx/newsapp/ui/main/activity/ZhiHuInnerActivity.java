package com.csx.newsapp.ui.main.activity;

import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.csx.newsapp.R;
import com.csx.newsapp.bean.ZhiHuInnerBean;
import com.csx.newsapp.ui.main.contract.ZhiHuInnerContract;
import com.csx.newsapp.ui.main.model.ZhiHuInnerModel;
import com.csx.newsapp.ui.main.presenter.ZhiHuInnerPresenter;
import com.csx.newsapp.widget.actionbar.MainTopBar;
import com.csx.newsapp.widget.actionbar.TopBarImp;
import com.fifedu.rxfiflibrary.base.BaseActivity;
import com.fifedu.rxfiflibrary.utils.LogUtil;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/7/12.
 * <p>
 * 知乎 inner
 */

public class ZhiHuInnerActivity extends BaseActivity<ZhiHuInnerPresenter,ZhiHuInnerModel>
        implements ZhiHuInnerContract.View,TopBarImp{
    private static final String TAG = "ZhiHuInnerActivity";
    @BindView(R.id.zhihu_inner_topbar)
    MainTopBar zhihuInnerTopbar;
    @BindView(R.id.rich_txt)
    TextView richTxt;

    private String id;
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_knows_inner;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");

        zhihuInnerTopbar.setTopBarImp(this);

        if (!StringUtils.isEmpty(id)) {
            mPresenter.returnZHInnerRequest(id);
        }

        if (!StringUtils.isEmpty(title)) {
            zhihuInnerTopbar.getMiddleTextView().setText(title);
        }

    }
    @Override
    public void returnZhiHuInnerBean(ZhiHuInnerBean zhiHuInnerBean) {
        LogUtil.debug(TAG,"returnZhiHuInnerBean");
        //将html 显示在富文本上
        RichText.from(zhiHuInnerBean.getBody()).into(richTxt);
        RichText.recycle();
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


    @Override
    public void leftTopBackListener() {
        finish();
    }

    @Override
    public void rightTopBarViewListener() {

    }
}
