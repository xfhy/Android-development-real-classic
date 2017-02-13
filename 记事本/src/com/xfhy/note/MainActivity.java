package com.xfhy.note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	private NotesDB notesDB;     //数据库
	private MyAdapter adapter;
	private SQLiteDatabase dbReader;  //需要一个读取的权限
	private Button textbtn,imgbtn,videobtn;  //3个按钮
	private ListView lv;
	Intent intent;
	
	/*
	 * Cursor 是每行的集合。
		使用 moveToFirst() 定位第一行。
		你必须知道每一列的名称。
		你必须知道每一列的数据类型。
		Cursor 是一个随机的数据源。
		所有的数据都是通过下标取得。
	 * */
	Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();     //初始化
    }
    
    //初始化
    public void initView()
    {
    	lv = (ListView)findViewById(R.id.list);
    	textbtn = (Button)findViewById(R.id.text);
        imgbtn = (Button)findViewById(R.id.img);
        videobtn = (Button)findViewById(R.id.video);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
        notesDB = new NotesDB(this);   //实例化数据库
        dbReader = notesDB.getReadableDatabase();   //获得可以读的数据库
        lv.setOnItemClickListener(new OnItemClickshort());  //设置ListView点击事件
    }
    
    /**
     * 点击时发生的事件	
     */
	@Override
	public void onClick(View v) {
		intent = new Intent(this,AddContent.class);   //启动下一个Activity
		switch (v.getId()) {
		case R.id.text:   //点击文字按钮
			intent.putExtra("flag", "1");  //传递Activity数据,1
			startActivity(intent);
			break;
		case R.id.img:   //点击图文按钮
			intent.putExtra("flag", "2");  //传递Activity数据,2
			startActivity(intent);
			break;
		case R.id.video:  //点击视频按钮
			intent.putExtra("flag","3");  //传递Activity数据,3
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	//用于查询,这个方法在onResume中被调用
	public void selectDB()
	{
		cursor = dbReader.query(NotesDB.TABLE_NAME, null, null, null, null, null, null);
		adapter = new MyAdapter(this, cursor);
		lv.setAdapter(adapter);   //将adapter绑定ListView
	}
	
	/**
	 * protected void onResume() 在 Activity 从 Pause 状态转换到 Active
	 *  状态时被调用。
      onResume是activity获得用户焦点，在与用户交互
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		selectDB();
	}
	
	private class OnItemClickshort implements OnItemClickListener
	{
		/*
		 *  parent 相当于listview Y适配器的一个指针，可以通过它来获得Y里装着的一切东西，
		 *  再通俗点就是说告诉你，你点的是Y，不是X - -
		 view 是你点b item的view的句柄，就是你可以用这个view，来获得b里的控件的id后操作控件
		 position 是b在Y适配器里的位置（生成listview时，适配器一个一个的做item，然后把他们按顺序排好队，
		 在放到listview里，意思就是这个b是第position号做好的）
		 id 是b在listview Y里的第几行的位置（很明显是第2行），大部分时候position和id的值是一样的，
		 如果需要的话，你可以自己加个log把position和id都弄出来在logcat里瞅瞅，看了之后心里才踏实。
		 * */
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			cursor.moveToPosition(position);   //移动到指定的位置,cursor用来装数据的
			Intent i = new Intent(MainActivity.this,SelectAct.class);  //需要启动的Activity
			
			//因为需要删除,所以需要用到该ListView的ID
			i.putExtra(NotesDB.ID, cursor.getInt(cursor.   //ID
					getColumnIndex(NotesDB.ID)));
			i.putExtra(NotesDB.CONTENT, cursor.getString(cursor.   //文字数据
					getColumnIndex(NotesDB.CONTENT)));
			i.putExtra(NotesDB.TIME,cursor.getString(cursor.       //时间
					getColumnIndex(NotesDB.TIME)));
			i.putExtra(NotesDB.PATH, cursor.getString(cursor.      //图片
					getColumnIndex(NotesDB.PATH)));
			i.putExtra(NotesDB.VIDEO,
					cursor.getString(cursor.getColumnIndex(NotesDB.VIDEO)));
			startActivity(i);     //用户点击之后跳转到详情页
		}
	}
}

