package com.xfhy.togglebuttondemo1;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

//用ToggleButton按钮(2种状态),实现开关手电筒
public class MainActivity extends Activity {

	private ToggleButton tb1 = null;
	@SuppressWarnings("deprecation")
	Camera m_Camera;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tb1 = (ToggleButton)findViewById(R.id.turn);
        //创建选择事件
        tb1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				
				/**
				 * buttonView:代表当前被点击的组件
				 * isChecked:代表当前被点击的组件的状态
				 */
				if(isChecked)   //开启闪光灯
				{
					try{
					    m_Camera = Camera.open();
			            Camera.Parameters parameters = m_Camera.getParameters();           
			            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON); // 使用闪光灯
			            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH); // 开启火炬模式常亮
			            m_Camera.setParameters(parameters);  
			        }
				 catch(Exception e)
			        {
			            e.printStackTrace();
			        }
				}
				else//关闭闪光灯
				{
					try
					{   
						Camera.Parameters mParameters;  
						mParameters = m_Camera.getParameters();  
						mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);  
						m_Camera.setParameters(mParameters);  
						m_Camera.release();
					} 
					catch(Exception ex)
					{
						 ex.printStackTrace();
					} 
				}
			}
			
        });
    }
}
