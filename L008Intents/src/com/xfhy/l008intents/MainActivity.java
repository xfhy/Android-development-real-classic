package com.xfhy.l008intents;

import java.io.File;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

	private Button btnStartAty1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStartAty1 = (Button) findViewById(R.id.btnStartAty1);
        btnStartAty1.setOnClickListener(this);
        
             /*-------------打电话----------------*/
        findViewById(R.id.btnDel10086).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//打电话  给10086
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("tel:10086"));
				startActivity(i);
			}
		});
        
        /*-------------访问网页-------------*/
        findViewById(R.id.btnMovBD).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.baidu.com"));
				startActivity(i);
			}
		});
    }
    
	@Override
	public void onClick(View v) {
		
		/*//到达第二个Activity
		Intent i = new Intent();
		
		 * 参数:
		 * 第二个Activity包名的前缀
		 * 第二个包名全部
		 * 
		i.setComponent(new ComponentName("com.xfhy.l008intents", 
				"com.xfhy.l008intents.Aty1"));*/
		
		/*Intent i = new Intent("com.xfhy.l008intents.intent.action.Aty1");
		
		
	    startActivity(i);    //启动第二个Activity*/
		
		   /*-------------打开图片----------------*/
		//打开一个图片
		File f = new File("storage/sdcard0/back.png");
		Intent i = new Intent(Intent.ACTION_VIEW);   //调用系统用来查看图片的界面
		i.setDataAndType(Uri.fromFile(f), "image/*");
		startActivity(i);
		
		/*File f = new File("storage/sdcard0/back.png");
		Intent i = new Intent();
		i.setComponent(new ComponentName("com.xfhy.l008intents","com.xfhy.l008intents.ImageViewer"));
		startActivity(i);*/
	}
}
