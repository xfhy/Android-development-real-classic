package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	private TextView tv;
	private RadioGroup rg;
	private RadioButton rb1;
	private RadioButton rb2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        tv = (TextView)findViewById(R.id.txetview);  //找到控件
        rg = (RadioGroup)findViewById(R.id.group);
        rb1 = (RadioButton)findViewById(R.id.button1);
        rb2 = (RadioButton)findViewById(R.id.button2);
        
        //单选按钮组监听事件
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				//如果选中的控件id为单选选项的第一个控件
				if(checkedId==R.id.button1)
				{
					tv.setText("Android新手");
					rb1.setText("我是1");
					String msg = rb1.getText().toString(); //获取按钮1的文本值
					rb2.setText(msg);
				}
				else
				{
					tv.setText("Android高手");
					rb1.setText("我是1");
					rb2.setText("我是2");
				}
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
