package com.xfhy.usingservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
 * 比如QQ的在后台监听用户的好友发过来的信息,则这个无法用Activity来完成,这就需要Service来实现.
    建立Service步骤:新建一个类,继承自Service,再到AndroidManifest里面去配置Service信息,eg:<service android:name="com.xfhy.l003usingservice.EhoService"></service>
    打开服务:startService(serviceIntent);     //serviceIntent是Intent对象实例
    关闭服务:stopService(serviceIntent);
    生命周期:a.onCreate()  创建   b.onDestroy()  销毁
    
    当用startService打开的服务,则关闭了Activity之后服务还在运行
    当用bindService "打开"(其实是先onCreate,再onBind) 的服务,则关闭了Activity之后服务就销毁了
    
    本例还写了与Service通信的方法,获取Service的数据
 * */
public class MainActivity extends Activity implements OnClickListener, ServiceConnection{

	private Button open = null;
	private Button close = null;
	private Intent serviceIntent;
	private Button btnBindService = null;
	private Button btnUnbindService = null;
	private EhoService ehoService = null;
	private Button getNumber = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        open = (Button) findViewById(R.id.open);
        close = (Button) findViewById(R.id.close);
        btnBindService = (Button) findViewById(R.id.btnBindService);
        btnUnbindService = (Button) findViewById(R.id.btnUnbindService);
        getNumber = (Button) findViewById(R.id.getNumber);
        
        serviceIntent = new Intent(MainActivity.this,EhoService.class);
        
        open.setOnClickListener(this);
        close.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnbindService.setOnClickListener(this);
        getNumber.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.open:
			//请求操作系统创建服务,不能new 出来
			startService(serviceIntent);
			break;
		case R.id.close:
			stopService(serviceIntent);
			break;
		case R.id.btnBindService:
			//这个方法是用来监听服务(Service)的状态的
			//如果调用这个时,Service未打开则先onCreate再onBind
			/*
			 * 参数:
			 * Intent对象
			 * 接收信息作为服务开始和停止
			 * 第3个参数Context.BIND_AUTO_CREATE表明只要绑定存在，就自动建立 Service；
			 * */
			bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
			break;
		case R.id.btnUnbindService:
			/*
			 * 解除绑定Service
			 * 如果已经绑定了Service,则需要unbind解除绑定(现在是还没有停止服务),再stop(现在停止服务)
			 * */
			unbindService(this);
			ehoService = null;
			break;
		case R.id.getNumber:
			if(ehoService!=null)
			{
				Log.i("tag","呵呵:"+ehoService.getNumber()+"");
			}
			break;
		default:
			break;
		}
	}
	
	//当成功绑定Service则会执行到这个方法onServiceConnected
	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		Log.i("tag","onServiceConnected");
		
		ehoService = ((EhoService.EchoServiceBinder) service).getService();
	}
	
	//当Service崩溃时触发onServiceDisconnected
	@Override
	public void onServiceDisconnected(ComponentName name) {
		
	}
}
