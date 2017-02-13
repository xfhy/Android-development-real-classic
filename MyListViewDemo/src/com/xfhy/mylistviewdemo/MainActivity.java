package com.xfhy.mylistviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

	//将要显示的数据封装到字符串数组里
	private String data[] = {"喂。。。本体你还是没有朋友？","怎么会呢【笑】","诶~。。。那么朋友的前几名是谁呢？【眯眼】","嗯。。。前两名都是姓白的，第三。。。哈比？",
			"啧，真是毫无吐槽点啊。。。姓白的是谁？","【挑眉】[我只认识两个姓白的好吗。。。",
			"【无语瞥】唐瓜你的智商怎么下线了？","要你管？！","逗比吧"};
    private ListView listView;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.listView = new ListView(this);  //初始化ListView
        
        /*
         * 用ArrayAdapter类将所有的数据进行封装
         * 而且每条数据只占一行(simple_expandable_list_item_1)
        */
        this.listView.setAdapter(new ArrayAdapter<String>(
        		this,android.R.layout.simple_expandable_list_item_1,this.data));
        
        //将ListView加入到手机界面进行显示
        setContentView(this.listView);
    }
}
