package com.cogent.iPhonewheel.UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.cogent.iPhonewheel.Interface.OnWheelChangedListener;
import com.cogent.iPhonewheel.Interface.OnWheelScrollListener;
import com.cogent.iPhonewheel.adapter.NumbericWheelAdapter;
import com.cogent.iPhonewheel.widget.WheelView;

public class PasswordActivity extends Activity {
	
	private TextView txt_pwdstatus;
	private Button mix;

	/**滚轮是否滚动的标志*/
	private boolean wheelScrolled = false;
	
	
	private OnWheelScrollListener scrollListener = new OnWheelScrollListener() {
		
		@Override
		public void onScrollingStarted(WheelView wheel) {
			//一旦监听到滚动，将标志位设为true
			wheelScrolled = true;
			
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			//停止滚动后位置为置为false，并且更新当前滚轮状态
			wheelScrolled = false;
			updateStatus();
		}
	};
	
	private OnWheelChangedListener changedListener = new OnWheelChangedListener() {
		
		@Override
		public void onChanged(WheelView wheel, int oldValue, int newValue) {
			// TODO Auto-generated method stub
			if(!wheelScrolled){//滚动了，滚轮数据发生变化
				updateStatus();
			}
			
		}
	};
	
	
	/**
	 * 更新当前wheel的状态
	 */
	private void updateStatus(){
		txt_pwdstatus = (TextView) findViewById(R.id.pwd_status);
		StringBuilder sb = new StringBuilder();
		//其实得到的应该是下标，由于小标和显示数字相同，故没再根据下标找view内容
		sb.append(((WheelView) findViewById(R.id.passwd_1)).getCurrentItem());
		sb.append(((WheelView) findViewById(R.id.passwd_2)).getCurrentItem());
		sb.append(((WheelView) findViewById(R.id.passwd_3)).getCurrentItem());
		sb.append(((WheelView) findViewById(R.id.passwd_4)).getCurrentItem());

		txt_pwdstatus.setText(sb);
		
	
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.password);
		initWheel(R.id.passwd_1);
		initWheel(R.id.passwd_2);
		initWheel(R.id.passwd_3);
		initWheel(R.id.passwd_4);
		
		mix = (Button) findViewById(R.id.btn_mix);
		mix.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mixWheel(R.id.passwd_1);
				mixWheel(R.id.passwd_2);
				mixWheel(R.id.passwd_3);
				mixWheel(R.id.passwd_4);
			}
		});
		updateStatus();
	}
	
	/**
	 * 初始化wheel
	 * @param id wheel的id
	 */
	private void initWheel(int id){
		WheelView wheel = (WheelView) findViewById(id);
		//将数据填进去，最大值9，最小值0共10个数据
		wheel.setAdapter(new NumbericWheelAdapter(0,9));
		//设置当前显示，随机的数，math.random()得到的是>=0&&<1的随机数，故x10放大
		wheel.setCurrentItem((int) (Math.random() * 10));
		
		//为滚轮增加滚动和数据变化的监听器
		wheel.addChangingListener(changedListener);
		wheel.addScrollingListener(scrollListener);
		//数据可循环
		wheel.setCyclic(true);
		//滚轮的动画变化率
		wheel.setInterpolator(new AnticipateInterpolator());
	}
	
	/**
	 * 随机生成wheel的数据
	 * @param id wheel的id
	 */
	private void mixWheel(int id){
		WheelView wheel = (WheelView) findViewById(id);
		wheel.scroll((int) (Math.random() * 50), 3000);
	}

}
