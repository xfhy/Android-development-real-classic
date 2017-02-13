package com.xfhy.usingbroadcastreceiver;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	private Button btnSendBroadcast = null;
	private Button btnRegBCR = null;
	private Button btnUnregBCR = null;
	final MyBC mybc = new MyBC();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
        btnRegBCR = (Button) findViewById(R.id.btnRegBCR);
        btnUnregBCR = (Button) findViewById(R.id.btnUnregBCR);
        
        
        btnSendBroadcast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//发送数据到广播
				//Intent i = new Intent(MainActivity.this,MyBC.class);
				Intent i = new Intent(MyBC.ACTION);   //第二种初始化Intent的方式
				i.putExtra("txt","Hello xfhy");
				sendBroadcast(i);   //发送广播
			}
		});
        
        
        btnRegBCR.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				/*
				 * 注册广播
				 * 参数:
				 * BroadcastReceiver
				 * IntentFilter filter(用来指定BroadcastReceiver的地址)
				 * */
				registerReceiver(mybc, new IntentFilter(MyBC.ACTION));
			}
        });
        
        
        
        btnUnregBCR.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				unregisterReceiver(mybc);    //注销广播
			}
        });
    }
}
