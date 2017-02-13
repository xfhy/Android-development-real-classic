package com.example.progressdialogdemo1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 进度条对话框
 * @author XFHY
 *当数据加载完成后,一定要调用dismiss()来关闭对话框,否则会一直存在
 */
public class MainActivity extends Activity {

	private Button btn1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
				progressDialog.setTitle("This is ProgressDialog");
				progressDialog.setMessage("正在重启...");
				progressDialog.setCancelable(true);  //是否能够取消对话框
				progressDialog.show();
			}
		});
    }
}
