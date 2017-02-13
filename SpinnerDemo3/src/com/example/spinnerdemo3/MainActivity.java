package com.example.spinnerdemo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/*
 * 下拉列表Spinner
 * 
 * 1.准备数据源
 * 2.定义数组适配器
 * 3.为适配器设置下拉列表下拉时的菜单样式
 * 4.加载适配器到下拉列表上
 * 5.为下拉列表设置各种事件的响应,这个事件响应菜单被选中
 * 
 * 监听器:OnItemSelectedListener
 * 
 * 
 * Spinner实现下拉列表：
 1.设置数据源 List<String>或者List<Map<String,Object>>
 2.新建适配器 ArrayAdapter<String>或者SimpleAdapter
 3.adapter设置一个下拉列表样式 adapter.setDropDownViewResource(resourse);
 4.spinner加载适配器 spinner.setAdapter(adapter);
 5.为spinner设定监听器 spinner.setOnItemSelectedListener
 (new spinner.OnItemSelectedListener(){@Override @Override });
 * */
public class MainActivity extends Activity implements OnItemSelectedListener {

	private Spinner spin = null;
	private List<String> dataList;
	private ArrayAdapter adapter;
	private TextView text = null;

	private SimpleAdapter simAdapter;
	private List<Map<String, Object>> dataList2;
	private int imageid = R.drawable.ic_launcher ;
	private String[] citys = { "北京", "上海", "广州", "深圳" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spin = (Spinner) findViewById(R.id.spin);
		text = (TextView) findViewById(R.id.text);

		/*----------第一种方式,ArrayAdapter-------*/
		/*
		 * dataList = new ArrayList<String>(); adapter = new
		 * ArrayAdapter<String>(this, //上下文信息
		 * android.R.layout.simple_list_item_1, //利用android自带的样式 getData());
		 * //得到数据源
		 * 
		 * //为适配器设置下拉列表下拉时的菜单样式
		 * adapter.setDropDownViewResource(android.R.layout.
		 * simple_spinner_dropdown_item);
		 * 
		 * spin.setAdapter(adapter); //加载数据源
		 * 
		 * //设置监听器 spin.setOnItemSelectedListener(this);
		 */

		/*----------第二种方式,SimpleAdapter-------*/
		// 初始化SimpleAdapter
		dataList2 = new ArrayList<Map<String, Object>>();
		simAdapter = new SimpleAdapter(this, getSimData(), // 加载数据
				R.layout.item, // 显示视图
				new String[] { "image", "city" }, // 名字
				new int[] { R.id.image, R.id.city }); // id
		
		simAdapter.setDropDownViewResource(R.layout.item);
		spin.setAdapter(simAdapter); // 加载数据源

		// 设置监听器
		spin.setOnItemSelectedListener(this);
	}

	private List<Map<String, Object>> getSimData() {
		for (int i = 0; i < citys.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", imageid);
			map.put("city", citys[i]);
			dataList2.add(map);
		}
		return dataList2;
	}

	// 准备数据源
	private List<String> getData() {
		dataList.add("北京");
		dataList.add("上海");
		dataList.add("广州");
		dataList.add("深圳");
		return dataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
			text.setText("您想去的城市是" + simAdapter.getItem(position)); // 设置文本
		
		
		/*
		 * switch (position) { case 0: text.setText("您想去的城市是北京"); break; case 1:
		 * text.setText("您想去的城市是上海"); break; case 2: text.setText("您想去的城市是广州");
		 * break; case 3: text.setText("您想去的城市是深圳"); break;
		 * 
		 * default: break; }
		 */
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

}
