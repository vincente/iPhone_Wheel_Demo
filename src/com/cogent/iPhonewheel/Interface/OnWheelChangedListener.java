package com.cogent.iPhonewheel.Interface;

import com.cogent.iPhonewheel.widget.WheelView;

/**
 * 滚轮改变监听器的接口
 * @author vincent E
 *
 */
public interface OnWheelChangedListener {
	/**
	 * 当前item改变时唤起回调的方法
	 * @param wheel 状态改变的那个滚轮 
	 * @param oldValue 当前item的之前的值
	 * @param newValue 当前item的新的值
	 */
	void onChanged(WheelView wheel,int oldValue,int newValue);
}
