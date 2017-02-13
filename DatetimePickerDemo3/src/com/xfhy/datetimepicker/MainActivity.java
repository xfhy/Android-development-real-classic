package com.xfhy.datetimepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/*
 * 时间选择器,日期选择器
 * 1.以屏幕的方式显示选择器
 * 2.以对话框的形式显示
 * */
public class MainActivity extends Activity {

	private DatePicker datePicker = null;
	private TimePicker timePicker = null;
	private Button time = null;
	private Button date = null;
	private Calendar cal;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        time = (Button) findViewById(R.id.time);
        date = (Button) findViewById(R.id.date);
        
        //获取日历的一个对象
        cal = Calendar.getInstance();
        
        //得到日历对象中的年
        year = cal.get(Calendar.YEAR);  
        month = cal.get(Calendar.MONTH)+1;    //month是从0开始的,
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour  = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        
        //设置应用的标题
        setTitle(year+"-"+month+"-"+day+" "+hour+":"+minute);
        
        //初始化datePicker,并设置监听器,当被改变时调用
        datePicker.init(year, month, day,new OnDateChangedListener(){
			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				//设置应用的标题
		        setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
        });
        
        //设置时间
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				setTitle(hourOfDay+":"+minute);
			}
        });
        
        
        date.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
				//日期选择器,对话框形式
		        new DatePickerDialog(MainActivity.this, new OnDateSetListener(){
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						//设置应用的标题
				        setTitle(year+"-"+monthOfYear+"-"+dayOfMonth);
					}
		        }, year, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
			}
        });
        
        time.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
				new TimePickerDialog(MainActivity.this, new OnTimeSetListener(){
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						//设置应用的标题
				        setTitle(hourOfDay+":"+minute);
					}
				}, day, minute, true).show();
				//最后一个参数是返回是否是24小时制
			}
        });
        
    }
}