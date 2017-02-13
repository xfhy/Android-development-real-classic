package com.xfhy.mylistviewdemo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	//显示图片
	private int[] pic = new int[]{R.drawable.sansuxie,R.drawable.heiqie,
			R.drawable.landun,R.drawable.riyan,
			R.drawable.nvyao,R.drawable.bingshuang};  
	//定义显示的数据
	private String data[][] = new String[][]{{"三速鞋","魔乐科技"},
			{"黑色切割者","李兴华"},{"兰顿之兆","李兴华"},{"日炎","MLDN"},
			{"女妖面纱","李兴华"},{"冰霜之锤","李奇"}};
	private int[] price = new int[]{800,3500,3000,2700,2900,3100};
	//保存所有的List数据
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	private ListView datalist;    //定义ListView组件
	private SimpleAdapter simpleAdapter = null;
	private TextView info = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        info = (TextView)findViewById(R.id.info);
        this.datalist = (ListView)super.findViewById(R.id.datalist); //获得ListView控件
        for (int x = 0; x < this.data.length; x++) {
        	//定义Map集合,待会儿添加进List中,simpleAdapter需要List
			Map<String,String> map = new HashMap<String,String>(); 
			map.put("pic", String.valueOf(this.pic[x]));  //添加图片的ID(转为String)
			map.put("goods", this.data[x][0]);            //添加物品
			map.put("author", data[x][1]);                //添加作者
			map.put("price", String.valueOf(price[x]));    //添加收费类型
			map.put("score", String.valueOf(R.drawable.wuxing));  //五星评价
			this.list.add(map);    //增加map进List(添加数据)
		}
        
        this.simpleAdapter = new SimpleAdapter(this,   //实例化SimpleAdapter
        		this.list,                             //要包装的数据集合
        		R.layout.data_list,                    //要使用的显示模板
        		new String[]{"pic","goods","author","price","score"}, //定义显示key
        		new int[]{R.id.pic,R.id.goods,R.id.author,R.id.price,R.id.score}); //与模板中的组件匹配
        this.datalist.setOnItemClickListener(new OnItemClickListenerlmpl());  //点击事件
        this.datalist.setOnItemLongClickListener(new OnItemClickListenerlong());
        this.datalist.setAdapter(this.simpleAdapter);  //设置显示数据
        
      
    }
    
    //实现点击
    private class OnItemClickListenerlmpl implements OnItemClickListener
    {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Map<String,String> map = (Map<String,String>)MainActivity.
					this.simpleAdapter.getItem(position);
			String title = map.get("goods");
			String author = map.get("author");
			MainActivity.this.info.setText(title+" "+author);
			
		}
    	
    }
    
    private class  OnItemClickListenerlong implements OnItemLongClickListener
    {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			/*Map<String,String> map = (Map<String,String>)MainActivity.
					this.simpleAdapter.getItem(position);
			String title = map.get("goods");
			String price = map.get("price");
			String author = map.get("author");
			MainActivity.this.info.setText(title+" "+price+" "+author);*/
			
			//弄个对话框试试
			Dialog diglog = new AlertDialog.Builder(MainActivity.this).setTitle("你他妈长按我干啥?").
					setMessage("暴击+40%").setIcon(R.drawable.emoji).create();	
			diglog.show();
			
			return false;
		}
    	
    }
}
