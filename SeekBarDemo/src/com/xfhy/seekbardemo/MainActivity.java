package com.xfhy.seekbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/*
 * 用SeekBar制作可拖动的进度条
 * 
 * 由于拖动条可以被用户控制,所以需要对其进行事件监听,这就需要实现
 * SeekBar.OnSeekBarChangeListener接口,此接口供需要监听三个事件
 * 数值改变(onProgressChanged)
 * 开始拖动(onStartTrackingTouch)
 * 停止拖动(onStopTrackingTouch)
 * 
 * */
public class MainActivity extends Activity implements OnSeekBarChangeListener{

	private SeekBar seekBar = null;
	private TextView tv1 = null;
	private TextView tv2 = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        
        seekBar.setOnSeekBarChangeListener(this);
    }
    
    //数值改变
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		tv1.setText("数值改变啦,逗比  \n"+"进度:"+progress+"\n用户拖动:"+fromUser);
	}
	
	//开始拖动时调用
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		tv2.setText("开始拖动");
	}
	
	//停止拖动时调用
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		tv2.setText("停止拖动");
	}
}
