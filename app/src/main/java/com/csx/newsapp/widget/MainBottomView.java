package com.csx.newsapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.csx.newsapp.R;
import com.fifedu.rxfiflibrary.utils.LogUtil;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by cuishuxiang on 2017/7/1.
 * <p>
 * 自定义一个Tab
 * 上面是图标，下面是文字
 */

public class MainBottomView extends AutoLinearLayout {
    private static final String TAG = "MainBottomView";

    AutoLinearLayout tabLayout;
    ImageView tabImg;
    TextView tabTxt;

    private Drawable bottom_imageview;
    private String bottom_textview;

    public MainBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MainBottomView);

        bottom_imageview = typedArray.getDrawable(R.styleable.MainBottomView_bottom_img);

        bottom_textview = typedArray.getString(R.styleable.MainBottomView_bottom_txt);

        initView(context);

        typedArray.recycle();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tab_main_bottom, this, true);
        tabImg = (ImageView) findViewById(R.id.tab_img);
        tabTxt = (TextView) findViewById(R.id.tab_txt);
        tabLayout = (AutoLinearLayout) findViewById(R.id.tab_layout);

        if (bottom_imageview != null) {
            tabImg.setImageDrawable(bottom_imageview);
        }

//        if (!StringUtils.isEmpty(bottom_textview)) {
//            tabTxt.setText(bottom_textview);
//        }

        if ("" != bottom_textview && bottom_textview != null) {
            tabTxt.setText(bottom_textview);
        }

    }


    public ImageView getTabImg() {
        if (tabImg == null) {
            LogUtil.debug(TAG,"主页下面的tabImg Null");
            return null;
        }
        return tabImg;
    }

    public TextView getTabTxt() {
        if (tabTxt == null) {
            LogUtil.debug(TAG,"主页下面的Tab Txt Null");
            return null;
        }
        return tabTxt;
    }
}

