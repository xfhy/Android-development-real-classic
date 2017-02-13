package com.xfhy.qqlogin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 1.创建SharedPreferences对象,初始化(getSharedPreferences("config",MODE_PRIVATE);)
 *第一个参数是保存数据的文件名,第二个是只有自己的程序才可以访问
 *2.Editor editor = sp.edit();通过SharedPreferences文件的edit()方法返回一个Editor对象
 *再通过该Editor对象putString()方法
 * @author XFHY
 *
 */

public class MainActivity extends Activity {

	private EditText qq=null;
	private EditText password=null;
	private CheckBox cb_jizhu=null;
	private Button bt_ok=null;
	private Button bt_region=null;
	
	/**
	 * android系统下用于数据存储的一个方便的api
	 */
	private SharedPreferences sp;  
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //初始化,用来存储数据的,config是文件名,MODE_PRIVATE表示这个是只有自己的应用程序才可以访问这个数据
        sp = getSharedPreferences("config",MODE_PRIVATE);
        
        qq = (EditText)findViewById(R.id.qq);
        password = (EditText)findViewById(R.id.password);
        cb_jizhu = (CheckBox)findViewById(R.id.cb_jizhu);
        
        //获取sp里面存储的数据
        String saveqq = sp.getString("qqnumber","0");
        String savepass = sp.getString("password1", "0");
        if(!saveqq.equals("0"))
        {
        	qq.setText(saveqq);
            password.setText(savepass);
        }
        
        bt_ok = (Button)findViewById(R.id.bt_ok);
        bt_region = (Button)findViewById(R.id.bt_region);
        
        bt_ok.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String qqnumber = qq.getText().toString();
				String password1 = password.getText().toString();
				if(TextUtils.isEmpty(qqnumber) || TextUtils.isEmpty(password1))
				{
					Toast.makeText(MainActivity.this, "QQ号码或者密码为空", 0).show();
				}
				else
				{
					//检查用户是否勾选了记住密码选项,勾选了则把用户名和密码记录下来
					if(cb_jizhu.isChecked())
					{
						//获取到一个参数文件的编辑器
						Editor editor = sp.edit();
						
						//往SharedPreferences文件中存储数据
						editor.putString("qqnumber", qqnumber);
						editor.putString("password1", password1);
						editor.commit();  //把数据保存到sp里面
						Toast.makeText(getApplicationContext(), "用户信息已经保存", 0).show();
					}
				}
			}
        });
    }
}
