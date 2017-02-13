package com.xfhy.mylistviewdemo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * 将ListView显示出来,用的是SimpleAdapter.
 * 本程序首先定义了一个data数组,其中定义了所要现实的数据,要想正确的通过ListView显示所有的数据,则
 * 需要将数据封装到SimpleAdapter类中,而SimpleAdapter类会自动将在List集合中保存的数据以
 * 规定的模板data_list进行数据的列表.
 * @author XFHY
 *
 */
public class MyListViewDemo2 extends ActionBarActivity {

	//将要显示的数据封装到字符串数组里
	private String data[][] = {{"01","鞋子：三速鞋"},
			{"02","黑色切割者"},
			{"03","亡者的板甲"},
			{"04","斯特拉克的挑战护手"},
			{"05","护甲防御装备：日炎或反甲"},
			{"06","法术防御装备：振奋铠甲"}};
	
	//保存所有的List数据
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	private ListView datalist;                     //定义ListView组件
	private SimpleAdapter simpleAdapter = null;    //适配器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_demo2);
        
        //取得ListView组件
        this.datalist = (ListView)findViewById(R.id.datalist);
        
        //循环设置数据
        for (int x = 0; x < this.data.length; x++) {
			Map<String,String> map = new HashMap<String,String>();  //定义Map集合
			map.put("_id",data[x][0]);   //设置_id组件显示组件
			map.put("name", data[x][1]); //设置name组件显示数据
			this.list.add(map);          //增加数据
		}
        
        this.simpleAdapter = new SimpleAdapter(this,   //实例化SimpleAdapter
        		this.list,                             //要包装的数据集合
        		R.layout.data_list,                    //要使用的显示模板
        		new String[]{"_id","name"},            //定义要显示的Map的key
        		new int[]{R.id._id,R.id.name});        //与模板中的组件匹配
        this.datalist.setAdapter(this.simpleAdapter);  //设置显示数据
    }
}
