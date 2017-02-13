package com.example.helloworldd;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class DatetimeActivity extends ActionBarActivity implements OnClickListener{

	//通用的显示对话框的方法
	private void showDialog(String title,String msg)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//设置对话框的图标
		builder.setIcon(android.R.drawable.ic_dialog_info);
		//设置对话框的标题
		builder.setTitle(title);
		//设置对话框显示的信息
		builder.setMessage(msg);
		//设置对话框的按钮
		builder.setPositiveButton("确定", null);
		//显示对话框
		builder.create().show();
		Intent intent;
	}
	
	//点击事件,2个按钮公用的一个单击事件方法,通过按钮的id区分单击了哪个按钮
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())   //获得该控件的id
			{
			    case R.id.btnShowDate:
			    {
			    	//设置日期显示格式
			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	//显示当前日期   调用当前类的显示对话框的方法,并传递参数
			    	showDialog("当前日期",sdf.format(new Date()));
			    	break;
			    }
			    case R.id.btnShowTime:
			    {
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			    	//显示当前时间   调用当前类的显示对话框的方法
			    	showDialog("当前时间",sdf.format(new Date()));
			    	break;
			    }
			}
		}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //装载View
        setContentView(R.layout.activity_datetime);
        //获取控件
        Button btnShowDate = (Button)findViewById(R.id.btnShowDate);
        Button btnShowTime = (Button)findViewById(R.id.btnShowTime);
        //设置控件的监听   当前这个类已经实现了OnClickListener,so用的是this
        btnShowDate.setOnClickListener(this);
        btnShowTime.setOnClickListener(this);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.datetime, menu);
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
