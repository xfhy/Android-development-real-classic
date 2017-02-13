package com.xfhy.note;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

/**
 * 添加内容
 * @author XFHY
 *
 */
public class AddContent extends ActionBarActivity implements OnClickListener{

	String val;    //用于接收MainActivity传递
	private Button savebtn,deletebtn;
	private EditText ettext;
	private ImageView c_img;
	private VideoView v_video;
	private NotesDB notesDB;
	private SQLiteDatabase dbWriter;
	private File phoneFile,videoFile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_content);
		
		//初始化
		val = getIntent().getStringExtra("flag");
		savebtn = (Button)findViewById(R.id.save);
		deletebtn = (Button)findViewById(R.id.delete);
		ettext = (EditText)findViewById(R.id.ettext);
		c_img = (ImageView)findViewById(R.id.c_img);
		v_video = (VideoView)findViewById(R.id.v_video);
		
		//绑定点听器
		savebtn.setOnClickListener(this);  
		deletebtn.setOnClickListener(this);
		
		//获得可读写数据库
		notesDB = new NotesDB(this);
		dbWriter = notesDB.getWritableDatabase();  //获取一个写入数据的权限
		initView();
	}
	
	//初始化
	public void initView()
	{
		          /*---------MainActivity(主)传递过来的数据,进行判断--------*/
		//val是MainActivity(主)传递过来的数据
		if(val.equals("1"))  //文字 
		{
			c_img.setVisibility(View.GONE);   //设置图片和视频控件不可见
			v_video.setVisibility(View.GONE);
		}
		else if(val.equals("2")) //图片
		{
			c_img.setVisibility(View.VISIBLE); //设置图片可见
			v_video.setVisibility(View.GONE);  //视频不可见
			
			    /*------调用系统相机拍照-----*/
			Intent iimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			phoneFile = new File(Environment.getExternalStorageDirectory().
					getAbsoluteFile()+"/"+getTime()+".jpg");
			iimg.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(phoneFile));
			startActivityForResult(iimg,1);    //看返回值时需要调用这个
		}
		else if(val.equals("3"))  //视频
		{
			c_img.setVisibility(View.GONE);      //设置图片不可见
			v_video.setVisibility(View.VISIBLE); //设置视频可见
			
			/*------调用系统相机拍照-----*/
			Intent video = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
			videoFile = new File(Environment.getExternalStorageDirectory().
					getAbsoluteFile()+"/"+getTime()+".mp4");
			video.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(videoFile));
			startActivityForResult(video,2);    //看返回值时需要调用这个
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1)   //如果传递的是一张图片
		{
			//获取路径,展示内容,绝对路径
			Bitmap bitmap = BitmapFactory.decodeFile(phoneFile.
					getAbsolutePath());
			c_img.setImageBitmap(bitmap);
			
		}
		else if(requestCode==2)
		{
			v_video.setVideoURI(Uri.fromFile(videoFile));  //获取视频
			v_video.start();  //播放
		}
	}
	
	//用户点击保存或者取消
	@Override
	public void onClick(View v) {
		//如果用户点击了保存按钮,则保存用户输入的信息
		if(v.getId()==R.id.save)
		{
			addDB();     //添加文本框中的东西
			finish();   //关闭当前Activity
		}
		else if(v.getId()==R.id.delete)   //用户点击取消
		{
			finish();   //关闭当前Activity
		}
	}
	
	//添加数据进数据库
	public void addDB()
	{
		ContentValues values = new ContentValues();   //添加时需要用到的ContentValues
		values.put(NotesDB.CONTENT,ettext.getText().toString()); //添加文字内容
		values.put(NotesDB.TIME, getTime());     //添加时间
		values.put(NotesDB.PATH, phoneFile+"");  //添加图片
		values.put(NotesDB.VIDEO, videoFile+""); //添加视频
		dbWriter.insert(NotesDB.TABLE_NAME, null, values); //将ContentValues到数据库
	}
	
	//获得当前系统时间
	public String getTime()
	{
		Date da = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(da);
		return time;
	}
}
