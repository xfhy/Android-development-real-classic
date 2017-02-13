package com.example.mydialogdemo3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 通过对话框显示一组单选按钮,而后根据用户选择的选项,在文本框中显示数据
 * @author XFHY
 *
 */
public class MainActivity extends Activity {

	private Button mybut = null;
	private TextView mych = null;
	private String fruitData[] = new String[]{"苹果","西瓜","水蜜桃"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mych = (TextView)findViewById(R.id.mych);
        mybut = (Button)findViewById(R.id.mybut);
        mybut.setOnClickListener(new OnClickListenerlmpl());  //设置单击事件
    }
    
    //实现监听
    private class OnClickListenerlmpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			Dialog dialog = new AlertDialog.Builder(MainActivity.this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("请选择你喜欢吃的水果?")
			.setNegativeButton("取消", 
					new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
						}
				
			})
			//在按钮上设置了一个单击事件,会将默认的选择项(fruitData,字符串数组定义)
			//直接在对话框中进行显示
			.setItems(fruitData, new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					//设置文字
					MainActivity.this.mych.setText("您选择的水果是:"+fruitData[which]);
				}
				
			}).create();
			dialog.show();   //显示对话框
		}
    }
}
/*
 * 此程序开发简单,所以直接在Activity中进行了相关的显示数据定义,而在实际的开发中,建议读者要将信息的显示
 * 和代码进行分离,这样也符合MVC设计模式的要求.
 * 
 * 以上程序是直接将所有的要显示的文字信息通过对象数组的形式在Activity中进行了定义,可以再直接在一个
 * 资源文件中定义.
 * 
 * 
 * */
