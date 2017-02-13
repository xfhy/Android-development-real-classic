package com.xfhy.note;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class SelectAct extends ActionBarActivity implements OnClickListener{

	private Button s_delete,s_back;
	private ImageView s_img=null;
	private VideoView s_video=null;
	private TextView tv = null;   //展示具体的内容
	private NotesDB notesdb;      //获得数据库对象
	private SQLiteDatabase dbWriter; //因为要修改,所以需要获得可读写的数据库
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		
		s_delete = (Button)findViewById(R.id.s_delete);
		s_back = (Button)findViewById(R.id.s_back);
		s_img = (ImageView)findViewById(R.id.s_img);
		s_video = (VideoView)findViewById(R.id.s_video);
		tv = (TextView)findViewById(R.id.s_tv);
		
		/*int ID = getIntent().getIntExtra(NotesDB.ID, 0);
		String idimg = getIntent().getStringExtra(NotesDB.PATH);
		s_img = (ImageView)findViewById(R.id.s_img);
		//img.setImageURI(idimg);
		System.out.println(ID);*/
		notesdb = new NotesDB(this);    //获得数据库
		dbWriter = notesdb.getWritableDatabase();   //获得可读写的数据库
		
		s_back.setOnClickListener(this);
		s_delete.setOnClickListener(this);  //按钮的监听
		
		//如果图片为空,该ListView选项即没有图片,则不显示图片
		if(getIntent().getStringExtra(NotesDB.PATH).equals("null"))
		{
			s_img.setVisibility(View.GONE);   //不可见
		}
		else
		{
			s_img.setVisibility(View.VISIBLE);
		}
		
		if (getIntent().getStringExtra(NotesDB.VIDEO).equals("null"))
		{
			s_video.setVisibility(View.GONE);
		} 
		else 
		{
			s_video.setVisibility(View.VISIBLE);
		}
		
		tv.setText(getIntent().getStringExtra(NotesDB.CONTENT));
		Bitmap bitmap = BitmapFactory.decodeFile(getIntent().
				getStringExtra(NotesDB.PATH));
		s_img.setImageBitmap(bitmap);   //添加图片
		
		//添加视频
		s_video.setVideoURI(Uri.parse(getIntent().getStringExtra(NotesDB.VIDEO)));
		s_video.start();   //播放视频
	}
	
	//按钮的单击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.s_back:
			finish();
			break;
		case R.id.s_delete:
			deleteDate();
			finish();
			break;
		}
	}
	
	//用来删除东西的函数
	public void deleteDate()
	{
		dbWriter.delete(NotesDB.TABLE_NAME, "_id="+getIntent().getIntExtra(NotesDB.ID,0), null);
	}
}
