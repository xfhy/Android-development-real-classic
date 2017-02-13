package com.example.progresstest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;


public class ProgressTest extends ActionBarActivity {

	private ProgressBar firstbar = null;
	private ProgressBar secondbar = null;
	private Button start = null;
	private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_test);
        firstbar = (ProgressBar)findViewById(R.id.firstbar);
        secondbar = (ProgressBar)findViewById(R.id.secondbar);
        start = (Button)findViewById(R.id.start);
        
        start.setOnClickListener(new myListener());
    }
    
    class myListener implements OnClickListener  //后面不加括号
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		if(i==0)
    		{
    			firstbar.setVisibility(View.VISIBLE);  //设置可见
    			secondbar.setVisibility(View.VISIBLE);
    		}
    		else if(i<firstbar.getMax())
    		{
    			firstbar.setProgress(i);   //设置主进度
    			firstbar.setSecondaryProgress(i+10);  //设置子进度
    			secondbar.setProgress(i);
    		}
    		else
    		{
    			i -= 210;
    			firstbar.setVisibility(View.GONE);   //设置不可见
    			secondbar.setVisibility(View.GONE);
    		}
    		i += 10;
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.progress_test, menu);
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
