package com.xfhy.mydialogdemo;

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
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button mybut = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mybut = (Button)findViewById(R.id.mybut);
        mybut.setOnClickListener(new OnClickListenerimpl());
    }
    private class OnClickListenerimpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			Dialog dialog = new AlertDialog.Builder(MainActivity.this)
			.setIcon(R.drawable.ic_launcher)  //设置对话框图标
			.setTitle("确定删除?")              //标题
			.setMessage("您确定删除这条信息吗?")   //内容
			.setPositiveButton("删除",          //增加一个确定按钮
					new DialogInterface.OnClickListener(){  //监听事件

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//处理监听事件
							Toast.makeText(MainActivity.this, "删除",0).show();
						}
				
			}).setNeutralButton("查看详情",    //增加普通按钮
					new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "查看详情",0).show();
						}
				
			}).setNegativeButton("取消",    //增加普通按钮
					new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "取消",0).show();
				}
			}).create();       //创建Dialog
			dialog.show();     //显示对话框
		}
    }
}
