package com.cogent.iPhonewheel.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IPhone_WheelDemo extends Activity {
	Button btn_city, btn_pwd, btn_time;
	IPhone_WheelDemo activity;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		btn_city = initBtn(R.id.btn_city);
		btn_pwd = initBtn(R.id.btn_pwd);
		btn_time = initBtn(R.id.btn_time);
	}

	Button initBtn(int id) {
		Button btn = (Button) findViewById(id);
		btn.setOnClickListener(new OnClick());
		return btn;
	}

	class OnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.btn_city:
				Intent intent_city = new Intent(IPhone_WheelDemo.this,CitiesActivity.class);
				startActivity(intent_city);
				break;
			case R.id.btn_pwd:
				Intent intent_pwd = new Intent(IPhone_WheelDemo.this,PasswordActivity.class);
				startActivity(intent_pwd);
				break;
			case R.id.btn_time:
				Intent intent_time = new Intent(IPhone_WheelDemo.this,TimeActivity.class);
				startActivity(intent_time);
				break;
			}

		}
		
		
	}
}