package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	OnClickListener listener0 = null;
	OnClickListener listener1 = null;
	OnClickListener listener2 = null;
	OnClickListener listener3 = null;
	Button button0;
	Button button1;
	Button button2;
	Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener0 = new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent0 = new Intent(MainActivity.this,Activityfream.class);
				//setTitle("FrameLayout");
				startActivity(intent0);
			}
        	
        };
        listener1 = new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1 = new Intent(MainActivity.this,ActivityRelative.class);
				startActivity(intent1);
			}
        	
        };
        listener2 = new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent2 = new Intent(MainActivity.this,Activity_linerela.class);
				startActivity(intent2);
			}
        	
        };
        listener3 = new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent3 = new Intent(MainActivity.this,Activity_Table.class);
				startActivity(intent3);
			}
        	
        };
        button0 = (Button)findViewById(R.id.button0);
        button0.setOnClickListener(listener0);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(listener1);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(listener2);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(listener3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
