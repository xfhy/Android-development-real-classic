package com.xfhy.returnxx;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class FirstActivity extends Activity {

	private Button first = null;
	private Button second = null;
	private TextView text = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        first = (Button)findViewById(R.id.first);
        second = (Button)findViewById(R.id.second);
        text = (TextView)findViewById(R.id.text);
        
        //通过点击first按钮实现页面之间的跳转,
        /*
         * 1.startActivity的方式来实现
         * 2.初始化Intent
         * */
        first.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				/*
				 * 第一个参数:上下文对象this
				 * 第二个参数:目标文件
				 * */
				Intent t = new Intent(FirstActivity.this,SecondActivity.class);
				startActivity(t);
			}
        });
        
        /*
         * 通过startActivityForresult
         * */
        second.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent t = new Intent(FirstActivity.this,SecondActivity.class);
				/*
				 * 第一个参数是Intent对象
				 * 第二个参数是请求的一个标志
				 * */
				startActivityForResult(t, 1);
			}
        });
    }
    
    /*
     * 通过startActivityForresult跳转,接收返回数据的方法
     * requestCode:请求的标识
     * resultCode:第二个页面返回的标识 
     * data:第二个页面回传的数据
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==1 && resultCode==2)   //是Second传回来的数据
    	{
    		String content = data.getStringExtra("data");
    		text.setText(content);
    	}
    }
}
