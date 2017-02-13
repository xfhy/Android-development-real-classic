package com.example.scrollviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{

	private TextView tv = null;
	private ScrollView scroll = null;
	private Button up_btn = null;
	private Button down_btn = null;
	int height=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView)findViewById(R.id.tv);
        scroll = (ScrollView)findViewById(R.id.scroll);
        up_btn = (Button)findViewById(R.id.up_btn);
        down_btn = (Button)findViewById(R.id.down_btn);   //通过按钮滑动  通过函数控制滚动条他的位置在哪里
        up_btn.setOnClickListener(this);
        down_btn.setOnClickListener(this);       //设置监听器
        
        //获取资源文件,获得文本资源,获得id
        tv.setText(getResources().getString(R.string.content));
        scroll.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {    //获得动作
				case MotionEvent.ACTION_UP:
					
					break;
				case MotionEvent.ACTION_DOWN:
					
					break;
				case MotionEvent.ACTION_MOVE:   //当移动时 
					/*
					 * 1.getScrollY()  -----滚动条滑动的距离
					 * 2.getMeasuredHeight()   --获得滚动条的长度
					 * 3.getHeight()           --获得内容的长度	(一屏幕的高度)
					 * */
					if(scroll.getScrollY()<=0)
					{
						Toast.makeText(MainActivity.this, "已经是顶部了", 0).show();
					}
					
					//底部状态
					//TextView的总高度<=一屏幕的高度+滚动条的滚动距离
					else if(scroll.getChildAt(0).getMeasuredHeight() <= 
							scroll.getHeight()+scroll.getScrollY())
					{
						Toast.makeText(MainActivity.this, "已经是底部了", 0).show();
						Log.i("tag",Integer.toString(scroll.getChildAt(0).getMeasuredHeight()));
						tv.append(MainActivity.this.getResources().getString(R.string.content));
					}
					break;

				default:
					break;
				}
				return false;
			}
        });
    }
    
	@Override
	public void onClick(View v) {
		/*
		 * 1.scrollTo   参考标准是滚动条开始的位置
		 * 2.scrollBy   
		 * */
		switch (v.getId()) {
		case R.id.up_btn:
			//scroll.scrollTo(0, height-30);
			scroll.scrollBy(0,-30);
			//height = height-30;
			break;
		case R.id.down_btn:
			//scroll.scrollTo(0, height+30);
			scroll.scrollBy(0,30);
			//height = height+30;
			break;
		default:
			
			break;
		}
	}
}
