package com.cogent.iPhonewheel.adapter;

import com.cogent.iPhonewheel.Interface.WheelAdapter;

/**
 * 简单数组滚轮适配器
 * @author Administrator
 *
 * @param <T>
 */
public class ArrayWheelAdapter<T> implements WheelAdapter {
	
	/**默认item长度*/
	public static final int DEFAULT_LENGTH = -1;
	
	/**items*/
	private T items[];
	
	/**length*/
	private int length;
	
	/**两个参数的构造函数*/
	public ArrayWheelAdapter(T items[],int length){
		this.items = items;
		this.length = length;
	}

	/**一个参数的构造函数*/
	public ArrayWheelAdapter(T items[]){
		this(items,DEFAULT_LENGTH);
	}
	
	
	@Override
	public int getItemsCount() {
		// TODO Auto-generated method stub
		return items.length;
	}

	@Override
	public String getItem(int index) {
		// TODO Auto-generated method stub
		if(index >= 0 && index<items.length){
			return items[index].toString();
		}
		return null;
	}

	@Override
	public int getMaximumLength() {
		// TODO Auto-generated method stub
		return length;
	}

}
