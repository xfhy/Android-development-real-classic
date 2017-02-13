package com.xfhy.timepickerdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends Activity {

	private TimePicker mydp = null;
	private TextView tv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mydp = (TimePicker)findViewById(R.id.timer2);
        tv = (TextView)findViewById(R.id.text);
        mydp.setIs24HourView(true);    //将第二个时间选择器设置为24小时制
        mydp.setCurrentHour(18);    //设置小时
        mydp.setCurrentMinute(30);   //设置分钟
        
        
        
        String hour = mydp.getCurrentHour().toString();   //获得小时
        String minute  = mydp.getCurrentMinute().toString();  //获得分钟
        tv.setText("时间是 "+hour+":"+minute);
    }
}
