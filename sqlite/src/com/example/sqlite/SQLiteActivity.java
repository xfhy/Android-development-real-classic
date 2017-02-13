package com.example.sqlite;

import com.example.sqlite3.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SQLiteActivity extends ActionBarActivity {

	private Button create = null;
	private Button updateData = null;
	private Button insert = null;
	private Button update = null;
	private Button query = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        create = (Button)findViewById(R.id.create);
        updateData = (Button)findViewById(R.id.updateData);
        insert = (Button)findViewById(R.id.insert);
        update = (Button)findViewById(R.id.update);
        query = (Button)findViewById(R.id.query);
        create.setOnClickListener(new createListener());  //设置监听器
        updateData.setOnClickListener(new updateDaListen()); 
        insert.setOnClickListener(new insertListener()); 
        update.setOnClickListener(new updateListener()); 
        query.setOnClickListener(new queryListener()); 
    }
    
    //数据库地址data/data/com.example.sqlite/databases
    //创建数据库按钮的监听器
    class createListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		                                             //这个Activity,数据库版本
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		//第一次创建数据库,会调用onCreate()
    		SQLiteDatabase sq = dbHelper.getReadableDatabase();
    	}
    }
    
    //updateData按钮的监听器
    class updateDaListen implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		                                            //将数据库的版本更新了,要调用onUpgrade()
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db",2);
    		SQLiteDatabase sq = dbHelper.getReadableDatabase();
    	}
    }
    
    //添加数据库按钮的监听器
    class insertListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		//生成ContentValues对象,往数据库中添加东西时,需要用ContentValues
    		ContentValues values = new ContentValues();
    		//向该对象中插入键值对,其中键是列名,值是希望插入列的元素,值必须和列的数据类型匹配
    		values.put("id", 1);
    		values.put("name", "zhangsan");
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		SQLiteDatabase db = dbHelper.getWritableDatabase();
    		//调用insert方法,将数据插入进去数据库
    		//表名                                          需要添加的数据
    		db.insert("user", null, values);
    		System.out.println("insert");
    	}
    }
    
    //更新数据库按钮的监听器
    //更新操作 :相当于执行SQL中的update语句
    //update table_name SET XXCOL=XX where XXOL=XXX
    class updateListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		//通过辅助类,得到一个可以操作的数据库
    		SQLiteDatabase db = dbHelper.getWritableDatabase(); 
    		ContentValues values = new ContentValues();
    		values.put("name", "xfhy");
    		
    		//更新语句
    		//表名,值,id位置(where子句),id的值
    		db.update("user", values, "id=?", new String[]{"1"});
    		System.out.println("update success!");
    	}
    }
    
    //查询数据库按钮的监听器
    class queryListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		Log.d("mydebug", "myfirstdebugMsg");  //前面是名称,后面是信息
    		// TODO Auto-generated method stub
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		SQLiteDatabase db = dbHelper.getReadableDatabase();
    		/*参数列表:表,查询那些列,位置,id=多少,分组,分组结果进行限制,对查询出来的结果进行排序
    		 * query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
    		 * */
    		Cursor cursor = db.query("user", new String[]{"id","name"}, "id=?", new String[]{"1"}, null, null, null);
    		
    		//往数据库的下面移动,一行一行的,而且在查找,找到时则利用
    		while(cursor.moveToNext())
    		{ 
    			                               //获得列号
    			String name = cursor.getString(cursor.getColumnIndex("name"));
    			System.out.println("query---->"+name);
    		}
    		System.out.println("query---->success!");
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sqlite, menu);
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
