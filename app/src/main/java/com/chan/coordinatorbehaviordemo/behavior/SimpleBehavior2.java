package com.chan.coordinatorbehaviordemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Iwfu on 2016/6/12.
 *
 * 让一个ScrollView随着另一个ScrollView滑动而滑动
 */
public class SimpleBehavior2 extends CoordinatorLayout.Behavior {

	public SimpleBehavior2(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/*
	 * 返回值表明这次滑动我们要不要关心，我们要关心什么样的滑动？当然是y轴方向上的。
	 */
	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
			View child, View directTargetChild, View target,
			int nestedScrollAxes) {
		// 垂直方向滑动
		return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
	}

	/*
	 * 在被监听控件滑动时会调用这个~参数: dx ,dy表示水平和竖直方向的滑动距离
	 * consumed表示水平和竖直方向上滑动被消耗了多少,unconsumed表示未消耗的
	 */
	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child,
			View target, int dxConsumed, int dyConsumed, int dxUnconsumed,
			int dyUnconsumed) {
		int scrollY = target.getScrollY();
		child.setScrollY(scrollY);
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed,
				dyConsumed, dxUnconsumed, dyUnconsumed);
	}


	/*
	 * 模拟快速滑动，直接把Y方向的速度交给child，让他fling~~
	 */
	@Override
	public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout,
			View child, View target, float velocityX, float velocityY) {

		((NestedScrollView) child).fling((int) velocityY);
		return super.onNestedPreFling(coordinatorLayout, child, target,
				velocityX, velocityY);
	}

}
