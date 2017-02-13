package com.xfhy.radiobuttondemo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity {

	private TextView text = null;
	private RadioGroup encoding = null;
	private RadioButton utf = null;
	private RadioButton gbk = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = (TextView)findViewById(R.id.text);
        encoding = (RadioGroup)findViewById(R.id.encoding);
        utf = (RadioButton)findViewById(R.id.utf);
        gbk = (RadioButton)findViewById(R.id.gbk);
        
        encoding.setOnCheckedChangeListener(new OnCheckedChangeListenerlmp());
    }
    private class OnCheckedChangeListenerlmp implements OnCheckedChangeListener
    {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			String temp = null;
			if(utf.getId() == checkedId)
			{
				text.setText("你选择的编码是UTF");
			}
			if(gbk.getId() == checkedId)
			{
				text.setText("你选择的编码是GBK");
			}
		}
    }
}
