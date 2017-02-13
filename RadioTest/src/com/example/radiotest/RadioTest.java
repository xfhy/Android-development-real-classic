package com.example.radiotest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;


public class RadioTest extends ActionBarActivity {

	private RadioGroup gendergroup = null;
	private RadioButton malebtn = null;
	private RadioButton femalebtn = null;
	private CheckBox swim = null;
	private CheckBox run = null;
	private CheckBox read = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio);
        gendergroup = (RadioGroup)findViewById(R.id.gendergroup);
        malebtn = (RadioButton)findViewById(R.id.malebtn);
        femalebtn = (RadioButton)findViewById(R.id.femalebtn);
        swim = (CheckBox)findViewById(R.id.swim);
        run = (CheckBox)findViewById(R.id.run);
        read = (CheckBox)findViewById(R.id.read);
        gendergroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(checkedId)
				{
				    case R.id.malebtn:
				    	Toast.makeText(RadioTest.this, "男", Toast.LENGTH_SHORT).show();
					    break;
				    case R.id.femalebtn:
				    	Toast.makeText(RadioTest.this, "女", Toast.LENGTH_SHORT).show();
					    break;
				}
			}
        	
        });
        swim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					Toast.makeText(getApplicationContext(),"游泳被选中...", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(),"不喜欢游泳", Toast.LENGTH_SHORT).show();
				}
			}
        	
        });
        run.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					Toast.makeText(getApplicationContext(),"跑步被选中...", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(),"不喜欢跑步", Toast.LENGTH_SHORT).show();
				}
			}
        	
        });
        read.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					Toast.makeText(getApplicationContext(),"阅读被选中...", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(),"不喜欢阅读", Toast.LENGTH_SHORT).show();
				}
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.radio_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
