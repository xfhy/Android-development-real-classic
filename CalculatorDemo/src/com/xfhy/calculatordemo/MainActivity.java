package com.xfhy.calculatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{

	private EditText et_input = null;
	private Button btn_C = null;
	private Button btn_del = null;
	private Button btn_div = null;
	private Button btn_mul = null;
	private Button btn_7 = null;
	private Button btn_8 = null;
	private Button btn_9 = null;
	private Button btn_sub = null;
	private Button btn_4 = null;
	private Button btn_5 = null;
	private Button btn_6 = null;
	private Button btn_add = null;
	private Button btn_1 = null;
	private Button btn_2 = null;
	private Button btn_3 = null;
	private Button btn_eq = null;
	private Button btn_0 = null;
	private Button btn_point = null;
	boolean clearflag = true;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et_input = (EditText)findViewById(R.id.et_input);
        btn_C = (Button)findViewById(R.id.btn_C);
        btn_del = (Button)findViewById(R.id.btn_del);
        btn_div = (Button)findViewById(R.id.btn_div);
        btn_mul = (Button)findViewById(R.id.btn_mul);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_sub = (Button)findViewById(R.id.btn_sub);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_eq = (Button)findViewById(R.id.btn_eq);
        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_point = (Button)findViewById(R.id.btn_point);
        
        //设置按钮的点击事件
        btn_C.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_eq.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_point.setOnClickListener(this);
    }
    @Override
	public void onClick(View v) {
    	String str = et_input.getText().toString();
		switch (v.getId()) {
		case R.id.btn_0:
			if(clearflag==false)
			{
				et_input.setText("0");
				clearflag=true;
			}
			else
				et_input.append("0");
			break;
		case R.id.btn_1:
			if(clearflag==false)
			{
				et_input.setText("1");
				clearflag=true;
			}
			else
				et_input.append("1");
			break;
		case R.id.btn_2:
			if(clearflag==false)
			{
				et_input.setText("2");
				clearflag=true;
			}
			else
				et_input.append("2");
			break;
		case R.id.btn_3:
			if(clearflag==false)
			{
				et_input.setText("3");
				clearflag=true;
			}
			else
				et_input.append("3");
			break;
		case R.id.btn_4:
			if(clearflag==false)
			{
				et_input.setText("4");
				clearflag=true;
			}
			else
				et_input.append("4");
			break;
		case R.id.btn_5:
			if(clearflag==false)
			{
				et_input.setText("5");
				clearflag=true;
			}
			else
				et_input.append("5");
			break;
		case R.id.btn_6:
			if(clearflag==false)
			{
				et_input.setText("6");
				clearflag=true;
			}
			else
				et_input.append("6");
			break;
		case R.id.btn_7:
			if(clearflag==false)
			{
				et_input.setText("7");
				clearflag=true;
			}
			else
				et_input.append("7");
			break;
		case R.id.btn_8:
			if(clearflag==false)
			{
				et_input.setText("8");
				clearflag=true;
			}
			else
				et_input.append("8");
			break;
		case R.id.btn_9:
			if(clearflag==false)
			{
				et_input.setText("9");
				clearflag=true;
			}
			else
				et_input.append("9");
			break;
		case R.id.btn_C:
			et_input.setText("");
			break;
		case R.id.btn_del:
			if(clearflag==false)
			{
				et_input.setText("");
				clearflag=true;
			}
			else
				delOpera();   //删除最后一位
			
			break;
		case R.id.btn_div:
			if(clearflag==false)
			{
				et_input.setText(" "+((Button)v).getText()+" ");
				clearflag=true;
			}
			else
				et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.btn_mul:
			if(clearflag==false)
			{
				et_input.setText(" "+((Button)v).getText()+" ");
				clearflag=true;
			}
			else
				et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.btn_sub:
			if(clearflag==false)
			{
				et_input.setText(" "+((Button)v).getText()+" ");
				clearflag=true;
			}
			else
			    et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.btn_add:
			if(clearflag==false)
			{
				et_input.setText(" "+((Button)v).getText()+" ");
				clearflag=true;
			}
			else
			    et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.btn_eq:
			clearflag=false;
			getResult();
			break;
		case R.id.btn_point:
			if(clearflag==false)
			{
				et_input.setText(".");
				clearflag=true;
			}
			else
				et_input.append(".");
			break;

		default:
			break;
		}
		
	}
    
    //删除时进行的操作
    private void delOpera()
    {
    	String str = et_input.getText().toString();
    	String temp = null;
    	if(str.length()>=1)    //删除时至少有1个
		{
    		/*
    		 * //看看末尾是不是 空格+运算符+空格
    		 * 是的话则直接将  空格+运算符+空格 全部删除
    		 * */
    		temp = str.substring(str.length()-1,str.length());   
    		if(temp.equals(" "))
    		{
    			str = str.substring(0,str.length()-3);
    		}
    		else
    		{
    			str = str.substring(0,str.length()-1);
    		}
			
			et_input.setText(str);
		}
    }
    
    //计算结果
    private void getResult()
    {
    	String exp = et_input.getText().toString();
    	if(exp==null || exp.equals(""))
    	{
    		return ;
    	}
    	if(!exp.contains(" "))   //用户输入了一个数字,直接点击等号
    	{
    		return ;
    	}
    	String s1 = exp.substring(0,exp.indexOf(" "));   //截取前面个数字
    	exp = exp.substring(s1.length(),exp.length());   //除去前面的那个数字
    	exp = exp.trim();                                //除去空格
    	String opera = exp.substring(0,1);               //获取首位(即运算符)
    	
    	String s2 = exp.substring(1,exp.length());       //获取第二个数字
    	//Log.i("tag",s2);
    	
    	double d1=0,d2=0,result=0;
    	if(!s1.equals("") && !s2.equals(""))
    	{
    		try
    		{
    			d1 = Double.parseDouble(s1);   //对其进行异常处理,放置出现错误
    			d2 = Double.parseDouble(s2);
    		}
    		catch (ClassCastException e)
    		{
    			Toast.makeText(MainActivity.this, "您的输入有错或暂时未实现此功能",
    					0).show();
    			return ;    //遇到错误,即刻退出
    		}
    		catch (Exception e2)
    		{
    			Toast.makeText(MainActivity.this, "您的输入有错或暂时未实现此功能",
    					0).show();
    			return ;
    		}
			
    		if(opera.equals("+"))
        	{
        		result = d1+d2;
        	}
        	else if(opera.equals("-"))
        	{
        		result = d1-d2;
        	}
        	else if(opera.equals("×"))
        	{
        		result = d1*d2;
        	}
        	else if(opera.equals("÷"))
        	{
        		try
        		{
        			result = d1/d2;
        			String str = Double.toString(result);
        			if(str.equals("Infinity"))
        			{
        				Toast.makeText(MainActivity.this, "0不能做除数",
            					0).show();
        				//return ;
        			}
        		}
        		catch (ArithmeticException e)
        		{
        			Toast.makeText(MainActivity.this, "算术异常,请检查输入",
        					0).show();
        		}
        		catch (Exception e)
        		{
        			Toast.makeText(MainActivity.this, "算术异常,请检查输入",
        					0).show();
        		}
        		
        	}
    	}
    	else if(s1.equals("") && !s2.equals(""))
    	{
    		//d1 = Double.parseDouble(s1);   //对其进行异常处理,放置出现错误
			d2 = Double.parseDouble(s2);
    		if(opera.equals("+"))
        	{
        		result = 0+d2;
        	}
        	else if(opera.equals("-"))
        	{
        		result = 0-d2;
        	}
        	else if(opera.equals("×"))
        	{
        		result = 0*d2;
        	}
        	else if(opera.equals("÷"))
        	{
        		result = 0/d2;
        	}
    	} 
    	else if(s1.equals("") && s2.equals(""))   //两个都是空的
    	{
    		Toast.makeText(MainActivity.this, "逗比,只有运算符怎么计算啊",
					0).show();
    	}
    	
    	//如果不是除法时
    	if(!s1.contains(".") && !s2.contains(".") && !opera.equals("÷"))
		{
			int r = (int)result;
			et_input.setText(r+"");
		}
		else
			et_input.setText(result+"");
    }
    
}
