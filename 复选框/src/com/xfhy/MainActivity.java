package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox CB1 = (CheckBox)findViewById(R.id.checkBox1);  //获取对象
        final CheckBox CB2 = (CheckBox)findViewById(R.id.checkBox2);
        final CheckBox CB3 = (CheckBox)findViewById(R.id.checkBox3);
        final CheckBox CB4 = (CheckBox)findViewById(R.id.checkBox4);
        //单选按钮RadioGroup、复选框CheckBox都有OnCheckedChangeListener事件
        CB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				/*
				 * 这个方法是用于复选框的。即CheckBox对象。区分CheckBox是否被选中，isChecked有两种返回值：
            1 当CheckBox对象的复选框被选中时，isChecked()返回true，即1；
            2 当CheckBox对象的复选框没有被选中时，isChecked()返回false，即0.
				 * */
				if(isChecked)  //如果被选中
				{
					Toast.makeText(getApplicationContext(), CB1.getText()+"被选中",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB1.getText()+"被取消", Toast.LENGTH_SHORT).show();
			}
		});
        CB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)  //如果被选中
				{
					Toast.makeText(getApplicationContext(), CB2.getText()+"被选中",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB2.getText()+"被取消", Toast.LENGTH_SHORT).show();
			}
		});
        CB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub自动存根法判断状态
				if(isChecked)  //如果被选中
				{
					Toast.makeText(getApplicationContext(), CB3.getText()+"被选中",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB3.getText()+"被取消", Toast.LENGTH_SHORT).show();
			}
		});
        CB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)  //如果被选中
				{
					Toast.makeText(getApplicationContext(), CB4.getText()+"被选中",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB4.getText()+"被取消", Toast.LENGTH_SHORT).show();
			}
		});
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
