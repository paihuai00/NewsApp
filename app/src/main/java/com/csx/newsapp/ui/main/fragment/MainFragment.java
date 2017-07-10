package com.csx.newsapp.ui.main.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.csx.newsapp.R;
import com.fifedu.rxfiflibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cuishuxiang on 2017/7/1.
 *
 * 主页 由 TabLayout + ViewPager + Fragment 组成
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager;
    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;

    private List<Fragment> fragmentList;
    private TopNewsFragment nbaFragment;
    private PhotoFragment photoFragment;
    private WechatFragment wechatFragment;

    private ViewPagerAdapter viewPagerAdapter;

    private boolean isFirst = true;

    @Override
    protected int getLayoutResource() {
        return R.layout.fg_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        //设置ToolBar
//        getActivity().setSupportActionBar(mainToolbar);

        initViewPager();
    }

    private void initViewPager() {
        if (isFirst) {
            //添加fragment数据
            fragmentList = new ArrayList<>();
            nbaFragment = new TopNewsFragment();
            photoFragment = new PhotoFragment();
            wechatFragment = new WechatFragment();

            fragmentList.add(wechatFragment);
            fragmentList.add(nbaFragment);
            fragmentList.add(photoFragment);

            viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList);

            mainViewPager.setAdapter(viewPagerAdapter);

            mainTab.setupWithViewPager(mainViewPager);
            mainTab.getTabAt(0).select();//设置  默认选择 0 位上的tab

            isFirst = false;
        }

    }

    /**
     * 主页，ViewPager 的适配器
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;
        private String[] strings = new String[]{"微信精选", "今日头条", "美女"};

        public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }

}
