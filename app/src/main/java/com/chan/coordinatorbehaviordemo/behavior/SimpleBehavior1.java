package com.chan.coordinatorbehaviordemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Iwfu on 2016/6/12.
 *
 * 简单的Behavior:一个TextView随着另一个TextView移动而移动
 *
 * (让View监听另一个View的状态变化)
 */
public class SimpleBehavior1 extends CoordinatorLayout.Behavior {

	public SimpleBehavior1 () {
	}

	/**
	 * 必须重写带两个参数的构造方法,因为Coordinator里利用反射去找到这个behavior
	 * 
	 * @param context
	 * @param attrs
	 */
	public SimpleBehavior1(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d("tag", "创建了" + "SimpleBehavior1");
	}

	/*
	 * 判断使用这个Behavior的View是基于哪一个View的(即要监听哪一个View)
	 * 当监听的这个dependency状态改变了,则调用onDependentViewChanged
	 */
	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child,
			View dependency) {
		Log.d("tag", "获取了dependency");
		return dependency instanceof TextView;
	}

	/*
	 * 在被监听的View的大小或者位置发生改变时调用， 这个被监听的View是由layoutDependsOn的返回值决定的,
	 * 也可以是设置的其他锚点:anchor, 如果这个Behavior改变了child（使用者）的状态，返回true
	 */
	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child,
			View dependency) {
		Log.d("tag", "child状态改变");
		int offset = dependency.getTop() - child.getTop();
		ViewCompat.offsetTopAndBottom(child, offset);
		return true;
	}
}
