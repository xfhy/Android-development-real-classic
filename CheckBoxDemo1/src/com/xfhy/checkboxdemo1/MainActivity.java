package com.xfhy.checkboxdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * CheckBox继承自CompoundButton,CompoundButton继承自Button
 * 设置CheckBox监听器是设置setOnCheckedChangeListener
 * @author XFHY
 *
 */
public class MainActivity extends Activity{

	private CheckBox basket = null;
	private CheckBox foot = null;
	private CheckBox ping = null;
	private TextView text = null;
	String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        basket = (CheckBox)findViewById(R.id.basket);
        foot = (CheckBox)findViewById(R.id.foot);
        ping = (CheckBox)findViewById(R.id.ping);
        text = (TextView)findViewById(R.id.text);
        
        basket.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked)
				{
					if(!str.contains("篮球"))
					{
						str = text.getText().toString();
						str = str+"篮球";
						Log.i("mag",str);   //输出
						text.setText(str);
					}
					text.setVisibility(View.VISIBLE);
				}
				else
				{
					if(str.contains("篮球"))
					{
						/**
						 * substring(int beginIndex, int endIndex) 
                                                            返回一个新字符串，它是此字符串的一个子字符串。
                                                            返回的字符串不包含最后的那个字符(endIndex)
						 */
						int i = str.indexOf("篮球");
						str = str.substring(0,i);
						text.setText(str);
					}
				}
			}
        });
        foot.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked)
				{
					if(!str.contains("足球"))
					{
						str = text.getText().toString();
						str = str+"足球";
						text.setText(str);
					}
					text.setVisibility(View.VISIBLE);
				}
				else
				{
					if(str.contains("足球"))
					{
						/**
						 * substring(int beginIndex, int endIndex) 
                                                            返回一个新字符串，它是此字符串的一个子字符串。
                                                            返回的字符串不包含最后的那个字符(endIndex)
						 */
						int i = str.indexOf("足球");
						str = str.substring(0,i);
						text.setText(str);
					}
				}
			}
        });
        ping.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked)
				{
					if(!str.contains("乒乓球"))
					{
						str = text.getText().toString();
						str = str+"乒乓球";
						text.setText(str);
					}
					text.setVisibility(View.VISIBLE);
				}
				else
				{
					if(str.contains("乒乓球"))
					{
						/**
						 * substring(int beginIndex, int endIndex) 
                                                            返回一个新字符串，它是此字符串的一个子字符串。
                                                            返回的字符串不包含最后的那个字符(endIndex)
						 */
						int i = str.indexOf("乒乓球");
						str = str.substring(0,i);
						text.setText(str);
					}
				}
			}
        });
        //
    }
}
