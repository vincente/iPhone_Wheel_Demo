package com.cogent.iPhonewheel.UI;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.cogent.iPhonewheel.Interface.OnWheelChangedListener;
import com.cogent.iPhonewheel.adapter.ArrayWheelAdapter;
import com.cogent.iPhonewheel.widget.WheelView;

public class CitiesActivity extends Activity {
	private TextView txt_result;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.cities);
		txt_result = (TextView) findViewById(R.id.txt_result);

		String countries[] = new String[] { "中国", "美国", "英国", "日本" };
		final WheelView country = (WheelView) findViewById(R.id.wheel_country);
		// 国家显示3条数据
		country.setVisibleItems(3);
		// 设置滚轮数据可循环
		country.setCyclic(true);
		// 设置自定义的数组滚轮适配器
		country.setAdapter(new ArrayWheelAdapter<String>(countries));
		final String cities[][] = new String[][] {
				new String[] { "北京", "上海", "广州", "深圳", "哈尔滨", "三亚", "香港", "澳门" },
				new String[] { "纽约", "洛杉矶", "芝加哥", "华盛顿", "旧金山", "休斯顿",
						"圣安东尼奥", "新奥尔良" },
				new String[] { "伦敦", "伯明翰", "格拉斯哥", "曼彻斯特", "利物浦", "苏格兰",
						"爱丁堡", "纽卡斯尔" },
				new String[] { "东京", "大阪", "名古屋", "横滨", "神户", "仙台", "福冈", "广岛" }, };

		final WheelView city = (WheelView) findViewById(R.id.wheel_city);
		// 城市显示5条数据
		city.setVisibleItems(5);
		// 设置滚轮数据可循环
		city.setCyclic(true);

		// 增加监听，当国家信息变化时，城市信息随之变化
		country.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				city.setAdapter(new ArrayWheelAdapter<String>(cities[newValue]));
				// 当前显示的数据的位置
				city.setCurrentItem(cities[newValue].length / 2);
				int currentCountry = country.getCurrentItem();
				int currentCity = city.getCurrentItem();
				String countryStr = country.getAdapter()
						.getItem(currentCountry);
				String cityStr = city.getAdapter().getItem(currentCity);
				Log.i("PDA", "国家：" + countryStr + "||" + "城市：" + cityStr);
				txt_result.setText("您选择的是：" + countryStr + "" + cityStr);
			}

		});
		country.setCurrentItem(-1);

		// 城市信息变化时，也随之动态改变文字
		city.addChangingListener(new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				int currentCountry = country.getCurrentItem();
				int currentCity = city.getCurrentItem();
				String countryStr = country.getAdapter()
						.getItem(currentCountry);
				String cityStr = city.getAdapter().getItem(currentCity);
				Log.i("PDA", "国家：" + countryStr + "||" + "城市：" + cityStr);
				if (txt_result == null) {
					txt_result.setText("");
				}
				txt_result.setText("您选择的是：" + countryStr + "" + cityStr);
			}
		});

	}

}
