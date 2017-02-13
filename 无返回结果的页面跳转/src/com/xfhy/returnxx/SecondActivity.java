package com.xfhy.returnxx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {

	private Button back = null;
	private String content = "你好";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		/*
		 * 第二个页面通过按钮给第一页面回传数据
		 * 回传到第一个页面时其实是将数据放到Intent对象
		 * */
		back = (Button)findViewById(R.id.back);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("data", content);   //封装好数据
				
				/*
				 * 参数1:结果码(表示哪个页面)
				 * 参数2:数据
				 * */
				setResult(2,data);
				
				finish();   //销毁当前页面    则可以返回第一个页面
			}
		});
	}
}
