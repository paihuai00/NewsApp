package com.csx.newsapp.ui.main.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.csx.newsapp.R;
import com.csx.newsapp.ui.main.fragment.MainFragment;
import com.csx.newsapp.ui.main.fragment.MineFragment;
import com.csx.newsapp.ui.main.fragment.PhotoFragment;
import com.csx.newsapp.widget.MainBottomView;
import com.fifedu.rxfiflibrary.base.BaseActivity;
import com.zhy.autolayout.AutoFrameLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主要的activity  是由 三个fragment 构成
 */

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

//    @BindView(main_toolbar)
//    Toolbar mainToolbar;
    @BindView(R.id.main_framelayout)
    AutoFrameLayout mainFramelayout;
    @BindView(R.id.main_tab)
    MainBottomView mainTab;
    @BindView(R.id.photo_tab)
    MainBottomView photoTab;
    @BindView(R.id.mine_tab)
    MainBottomView mineTab;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private MainFragment mainFragment;//首页
    private PhotoFragment photoFragment;//美女
    private MineFragment mineFragment;//我的

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
//        mainToolbar.setTitle("好奇日报");
        showFragment(0);//默认选择
    }


    @OnClick({R.id.main_tab, R.id.photo_tab, R.id.mine_tab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_tab:
                showFragment(0);
//                mainToolbar.setTitle("好奇日报");
                break;
            case R.id.photo_tab:
                showFragment(1);
//                mainToolbar.setTitle("美女");
                break;
            case R.id.mine_tab:
                showFragment(2);
//                mainToolbar.setTitle("我的");
                break;
        }
    }

    private void showFragment(int i) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        hindFragment(fragmentTransaction);
        switch (i) {
            case 0:
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    fragmentTransaction.add(R.id.main_framelayout, mainFragment);
                } else {
                    fragmentTransaction.show(mainFragment);
                }
                mainTab.getTabTxt().setTextColor(getResources().getColor(R.color.deep_yellow));
                mainTab.getTabImg().setImageDrawable(getResources().getDrawable(R.drawable.ic_home_selected));
                break;
            case 1:

                if (photoFragment == null) {
                    photoFragment = new PhotoFragment();
                    fragmentTransaction.add(R.id.main_framelayout, photoFragment);
                } else {
                    fragmentTransaction.show(photoFragment);
                }
                photoTab.getTabTxt().setTextColor(getResources().getColor(R.color.deep_yellow));
                photoTab.getTabImg().setImageDrawable(getResources().getDrawable(R.drawable.ic_girl_selected));
                break;
            case 2:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.main_framelayout, mineFragment);
                } else {
                    fragmentTransaction.show(mineFragment);
                }
                mineTab.getTabTxt().setTextColor(getResources().getColor(R.color.deep_yellow));
                mineTab.getTabImg().setImageDrawable(getResources().getDrawable(R.drawable.ic_care_selected));
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * 隐藏所有的tab
     * @param fragmentTransaction
     */
    private void hindFragment(FragmentTransaction fragmentTransaction) {
        //恢复所有默认图标
        mainTab.getTabImg().setImageResource(R.drawable.ic_home_normal);
        photoTab.getTabImg().setImageResource(R.drawable.ic_girl_normal);
        mineTab.getTabImg().setImageResource(R.drawable.ic_care_normal);

        //恢复所有字体颜色
        mainTab.getTabTxt().setTextColor(getResources().getColor(R.color.bottom_color_normal));
        photoTab.getTabTxt().setTextColor(getResources().getColor(R.color.bottom_color_normal));
        mineTab.getTabTxt().setTextColor(getResources().getColor(R.color.bottom_color_normal));

        if (mainFragment != null) {
            fragmentTransaction.hide(mainFragment);
        }

        if (photoFragment != null) {
            fragmentTransaction.hide(photoFragment);
        }

        if (mineFragment != null) {
            fragmentTransaction.hide(mineFragment);
        }

    }
}
