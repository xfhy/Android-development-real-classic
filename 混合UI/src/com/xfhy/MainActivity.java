package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
	int[] images = new int[]{
    		R.drawable.j1,
    		R.drawable.j2,
    		R.drawable.j3,
    		R.drawable.j4,
    };
    int current=0;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //获取LinearLayout布局容器 activity_main的id就是root
        LinearLayout main = (LinearLayout)findViewById(R.id.root);
      //程序创建ImageView组件
        final ImageView image = new ImageView(this);
        //将ImageView组件添加到布局容器中
        main.addView(image);
        //初始化时显示第一张
        image.setImageResource(images[0]);
        image.setOnClickListener( new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(current>=4)   //下标超过4,循环到第一张图片
				{
					current=-1;
				}
				image.setImageResource(images[++current]);
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
