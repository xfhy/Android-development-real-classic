package com.example.contentproviderdemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
         * 右边是查询联系人信息
         * 左边是查询出来的信息的存放处(很多行),相当于指针,一行一行的,是一行一行的往下读取的
         * */
        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        
        while(c.moveToNext())
        {
        	String str = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Log.i("tag",str);
        }
        
    }
}
