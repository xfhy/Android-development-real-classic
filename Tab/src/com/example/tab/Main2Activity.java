package com.example.tab;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class Main2Activity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		Toast.makeText(this, "哈哈,欢迎使用", Toast.LENGTH_LONG).show();
	}

	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		//输出按键代码
		Log.d("onKeyDown:KeyCode",String.valueOf(keyCode));
		//输出按键的重复次数
		Log.d("onKeyDown:RepeatCount", String.valueOf(event.getRepeatCount()));
		//如果重复次数到了200,显示提示信息
		if( event.getRepeatCount()==200 )
		{
			Toast.makeText(this, "已经按了一会儿了,累了吧,该松开了!", Toast.LENGTH_LONG).show();
		}
		//如果按下菜单按钮输出提示信息
		if(keyCode == KeyEvent.KEYCODE_MENU)  //这里的意思是按下菜单按钮
		{
			Log.d("onKeyDown","MenuKey Down");
		}
		return super.onKeyDown(keyCode, event);
	}
	
	//任意情况下扑捉键盘事件
	/*@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		//按下动作
		if(event.getAction()==KeyEvent.ACTION_DOWN)
		{
			Toast.makeText(this, "按下", Toast.LENGTH_SHORT).show();
		}
		//抬起动作
		if(event.getAction()==KeyEvent.ACTION_UP)
		{
			Toast.makeText(this,"抬起",Toast.LENGTH_SHORT).show();
		}
		return super.dispatchKeyEvent(event);
	}*/
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main2, menu);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//按下状态
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			Log.d("onTouchEvent","onTouchEvent_Action:Down");
			//输出点击处的坐标
			Toast.makeText(this, "x="+event.getX()+" y="+event.getY(), Toast.LENGTH_SHORT).show();
		}
		if(event.getAction()==MotionEvent.ACTION_UP)
		{
			Log.d("onTouchEvent","onTouchEvent_ACTION:UP");
		}
		
		return super.onTouchEvent(event);
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
