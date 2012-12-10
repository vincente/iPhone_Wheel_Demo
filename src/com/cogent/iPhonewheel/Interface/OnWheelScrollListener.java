package com.cogent.iPhonewheel.Interface;

import com.cogent.iPhonewheel.widget.WheelView;

/**
 * 轮子滚动监听器的接口
 * @author Administrator
 *
 */
public interface OnWheelScrollListener {
	/**
	 * 轮子开始滚动时唤起回调的方法
	 * @param wheel 状态改变的那个滚轮
	 */
	void onScrollingStarted(WheelView wheel);
	/**
	 * 轮子结束滚动时唤起回调的方法
	 * @param wheel 状态改变的那个滚轮
	 */
	void onScrollingFinished(WheelView wheel);
}
