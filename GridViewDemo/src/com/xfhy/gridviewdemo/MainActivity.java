package com.xfhy.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/*
 * 如果是列表（单列多行形式）的使用ListView，如果是多行多列网状形式的优先使用GridView
 * 
 * 1、准备数据源

2、新建适配器

3、GridView加载适配器

4.GridView配置事件监听器(OnItemClickListener)

这里用的适配器是SimpleAdapter
 * */
public class MainActivity extends Activity implements OnItemClickListener{

	private GridView gridView = null;
	private List<Map<String,Object>>dataList;
	private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera
			,R.drawable.clock,R.drawable.games_control,R.drawable.messenger,
			R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,
			R.drawable.weather,R.drawable.world,R.drawable.youtube};
	private String[] iconName = {"通讯录","日历","照相机","时钟","游戏","短信","铃声","设置",
			"语音","天气","浏览器","视频"};
	private SimpleAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gridView = (GridView)findViewById(R.id.gridView);
        dataList = new ArrayList<Map<String,Object>>();
        adapter = new SimpleAdapter(this, getData(),R.layout.item, new String[]{"image","text"}, 
        		new int[]{R.id.image,R.id.text});
        
        gridView.setAdapter(adapter);
        //gridView.setNumColumns(4);   设置多少列
        
        gridView.setOnItemClickListener(this);   //加载监听器
    }
	private List<Map<String,Object>> getData() {
		for (int i = 0; i < icon.length; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("image",icon[i]);
			map.put("text",iconName[i]);
			dataList.add(map);
		}
		
		return dataList;
	}
	
	//监听点击事件   position是点击的位置
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(MainActivity.this, "我是"+iconName[position], 
				0).show();
		if(position==0)
		{
			Intent t = new Intent(MainActivity.this,Phone.class);
			startActivity(t);
		}
	}
}
