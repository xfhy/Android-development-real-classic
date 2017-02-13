package com.xfhy.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{

	private EditText number=null;    //编辑框
	private Button one=null;         //1,2,3,4,5,6,7,8,9,*,0,#
	private Button two=null;
	private Button three=null;
	
	private Button four=null;
	private Button five=null;
	private Button six=null;
	
	private Button seven=null;
	private Button eight=null;
	private Button nine=null;
	
	private Button xing=null;
	private Button zero=null;
	private Button jin=null;
	
	private Button callbtn=null;   //Call ×
	private Button delete=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initData();   //初始化数据(绑定,添加监听器等)
        
    }
    
    @SuppressWarnings("unused")
	private void initData()
    {
    	number = (EditText)findViewById(R.id.number);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        
        xing = (Button)findViewById(R.id.xing);
        zero = (Button)findViewById(R.id.zero);
        jin = (Button)findViewById(R.id.jin);
        
        callbtn = (Button)findViewById(R.id.callbtn);
        delete = (Button)findViewById(R.id.delete);
        
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        xing.setOnClickListener(this);
        zero.setOnClickListener(this);
        jin.setOnClickListener(this);
        callbtn.setOnClickListener(this);
        delete.setOnClickListener(this);
    }
    
    //点击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.one:
			number.append("1");
			break;
        case R.id.two:
        	number.append("2");
			break;
        case R.id.three:
        	number.append("3");
			break;
			
        case R.id.four:
        	number.append("4");
			break;
        case R.id.five:
        	number.append("5");
			break;
        case R.id.six:
        	number.append("6");
			break;
			
        case R.id.seven:
        	number.append("7");
			break;
        case R.id.eight:
        	number.append("8");
			break;
        case R.id.nine:
        	number.append("9");
			break;
        case R.id.xing:       //*
        	number.append("*");
			break;  
        case R.id.zero:       //0
        	number.append("0");
			break;
			
        case R.id.jin:         //#
        	number.append("#");
			break;
        case R.id.callbtn:     //打电话事件
        	callNumber();
			break;
        case R.id.delete:      //删除末尾数字
        	deleteData();
			break;
		default:
			break;
		}
	}
	
	//删除字符串最后一位
	@SuppressWarnings("unused")
	private void deleteData()
	{
		String str = number.getText().toString();
		if(str.length()!=0)
		{
			str = str.substring(0, str.length()-1);   //切割字符串,除掉最后一位
			number.setText(str);
		}
		else
		{
			Toast.makeText(this, "没有了,还删什么删....", Toast.LENGTH_LONG).show();
		}
	}
	
	@SuppressWarnings("unused")
	private void callNumber()
	{
		String str = number.getText().toString();
		if(str.length()!=0)
		{
			//用intent启动拨打电话  
	        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+str));  
	        startActivity(intent);  
		}
		else
		{
			Toast.makeText(this, "请输入电话再拨打", Toast.LENGTH_LONG).show();
		}
	}
	
}
