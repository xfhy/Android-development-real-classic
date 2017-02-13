package com.xfhy.wenben;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private Button save=null;
	private Button read=null;
	private EditText edit = null;
	private static final String FILENAME="mymldn.txt";
	private static final String DIR = "mldndata";
	private String info = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);
        edit = (EditText)findViewById(R.id.edit);
        
        save.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				info = edit.getText().toString();
				
				//如果 sdcard存在
		        //Environment.getExternalStorageState():取得扩展存储设备的状态
		        //Environment.MEDIA_MOUNTED:可读写   如果上面读取的状态是可读写的
		        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		        {
		        	//Environment.getExternalStorageDirectory():取得扩展的存储目录
		        	//File.separator:文件分隔符,与系统有关的默认名称分隔符。此字段被初始化为包含系统属性 file.separator 值的第一个字符。在 UNIX 系统上，此字段的值为 '/'；在 Microsoft Windows 系统上，它为 '\\'。 
		        	//定义File对象
		        	File file = new File(Environment.getExternalStorageDirectory().toString()+
		        			File.separator+DIR+File.separator+FILENAME);
		        	if(!file.getParentFile().exists())  //如果父类文件夹不存在
		        	{
		        		file.getParentFile().mkdirs();  //创建文件夹
		        	}
		        	PrintStream out = null;           //打印流对象,用于输出
		        	try
		        	{
		        		//out = new PrintStream(new FileOutputStream(file,true));  //在后面追加内容
		        		out = new PrintStream(new FileOutputStream(file));  //直接在文件中添加内容
		        		
		        		//out.println("北京呵呵软件公司");
		        		//edit.setText(file.toString());
		        		out.println(info);
		        		Toast.makeText(MainActivity.this, "保存成功!", Toast.LENGTH_LONG).show();
		        	}
		        	catch (Exception e)
		        	{
		        		edit.setText(e.toString());
		        	}
		        	finally
		        	{
		        		if(out!=null)   //当打印流对象非空时才可以操作,用完后需要关闭文件流
		        		{
		        			out.close();
		        		}
		        	}
		        }
		        else
		        {
		        	edit.setText("保存失败,SD卡不存在!");
		        }
			}
        	
        });
        
        read.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
				{
					File file = new File(Environment.getExternalStorageDirectory().toString()+
							File.separator+DIR+File.separator+FILENAME);
					if(!file.getParentFile().exists())
					{
						file.getParentFile().mkdirs();
					}
					Scanner scan = null;   //扫描输入
					info = "";
					try
					{
						scan = new Scanner(new FileInputStream(file));  //实例化Scanner
						while(scan.hasNext())
						{
							info = info+scan.next()+"\n";
						}
						edit.setText(info);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(scan!=null)
						{
							scan.close();   //关闭打印流
						}
					}
				}
				else
				{
					Toast.makeText(MainActivity.this, "读取失败,SD卡不存在!", Toast.LENGTH_LONG).show();
				}
			}
        	
        });
    }
}
