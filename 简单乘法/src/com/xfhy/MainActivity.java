package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private EditText ed1; 
	private EditText ed2; 
	private Button btn_mul; 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        btn_mul = (Button)findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float a1 = Float.parseFloat(ed1.getText().toString());
				float a2 = Float.parseFloat(ed2.getText().toString());
				float a3 = a1*a2;
				//System.out.print(a3);  a3“—≤‚ ‘’˝»∑
				Intent intent = new Intent();
				intent.putExtra("mul", String.valueOf(a3));
				intent.setClass(MainActivity.this, ResultActivity.class);
				MainActivity.this.startActivity(intent);
			}
        	
        }
         );
        //Toast.makeText(this,String.valueOf(a3), Toast.LENGTH_LONG).show();
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
