/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.csx.newsapp.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.csx.newsapp.api.ApiConstants;
import com.fifedu.rxfiflibrary.baserx.RxBus;
import com.fifedu.rxfiflibrary.baserx.RxManager;

/**
 * 重写Behavior列表向上滑动时候 ，隐藏FAB按钮，跟下面的导航栏
 * 参考
 * http://www.jianshu.com/p/f3c81cf485e5?utm_campaign=haruki&utm_content=note&utm_medium=reader_share&utm_source=qq
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
    RxManager rxManager;
    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
        super();
        if (rxManager==null){
            rxManager=new RxManager();
        }
    }
    /**
     *  当coordinatorLayout 的子View试图开始嵌套滑动的时候被调用。当返回值为true的时候表明
     *  coordinatorLayout 充当nested scroll parent 处理这次滑动，需要注意的是只有当返回值为true
     *  的时候，Behavior 才能收到后面的一些nested scroll 事件回调（如：onNestedPreScroll、onNestedScroll等）
     *  这个方法有个重要的参数nestedScrollAxes，表明处理的滑动的方向。
     *
     * @param coordinatorLayout 和Behavior 绑定的View的父CoordinatorLayout
     * @param child  和Behavior 绑定的View
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes 嵌套滑动 应用的滑动方向，看 {@link ViewCompat#SCROLL_AXIS_HORIZONTAL},
     *                         {@link ViewCompat#SCROLL_AXIS_VERTICAL}
     * @return
     */
    @Override
    public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final FloatingActionButton child,
                                       final View directTargetChild, final View target, final int nestedScrollAxes) {
        // Ensure we react to vertical scrolling
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 进行嵌套滚动时被调用
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed target 已经消费的x方向的距离
     * @param dyConsumed target 已经消费的y方向的距离
     * @param dxUnconsumed x 方向剩下的滚动距离
     * @param dyUnconsumed y 方向剩下的滚动距离
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                               View target, int dxConsumed, int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide();
            RxBus.getInstance().post(ApiConstants.MENU_SHOW_HIDE,false);
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            RxBus.getInstance().post(ApiConstants.MENU_SHOW_HIDE,true);
            child.show();
        }
    }
}
