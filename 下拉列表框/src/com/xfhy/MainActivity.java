package com.xfhy;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定layout里面的ListView
        ListView list = (ListView)findViewById(R.id.ListView01);
        //生成动态数组,加入数据
        ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
        for(int i=0; i<10; i++)
        {
        	HashMap<String,Object> map = new HashMap<String,Object>();  //建立hash表 map
        	map.put("ItemImage", R.drawable.windows);  //图片,从drawable中得到,放到hash表中
        	map.put("ItemTitle","Level"+(i+1));   //列表标题
        	//map.put("ItemText", "Finished in Min 54Secs,70 Moves!");
        	map.put("ItemText", "第"+(i+1)+"个项目");  //列表文本
        	listItem.add(map);  //将当前的这个hash表map添加到listItem中当成一个元素
        }
        //生成适配器的Item和动态数组对应的元素
        SimpleAdapter myAdapter = new SimpleAdapter(this,listItem,  //数据源
        		R.layout.activity_main,     //ListItem的XML实现
        		//动态数组与ImageItem对应的子项
        		new String[]{"ItemImage","ItemTitle","ItemText"},
        		//ImageItem的XML文件里面的一个ImageView,两个TextView ID
        		new int[]{R.id.ItemImage,R.id.ItemText,R.id.ItemTitle}
        		);
        //添加并且显示
        list.setAdapter(myAdapter);
        //添加点击   当类型点击
        list.setOnItemClickListener(new OnItemClickListener()
        {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				setTitle("点击第"+(arg2+1)+"个项目");
			}
        	
        });
        
        //添加长按点击
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener()
        {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				// TODO Auto-generated method stub
				menu.setHeaderTitle("长按菜单-ContextMenu"); //常按之后,出来的标题
				menu.add(0,0,0,"弹出长按菜单0");   //标题栏下面的子选项
				menu.add(0,1,0,"弹出长按菜单1");
				menu.add(0,2,0,"弹出长按菜单2");
				menu.add(0,3,0,"弹出长按菜单3");
			}
        	
        });
        
        
        
    }
    
    //长按菜单响应函数
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
    	setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目");
		return super.onContextItemSelected(item);
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
