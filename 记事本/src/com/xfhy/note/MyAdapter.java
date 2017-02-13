package com.xfhy.note;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Android中Adapter类其实就是把数据源绑定到指定的View上，然后再返回该View，而返回
来的这个View就是ListView中的某一行item。这里返回来的View正是由我们的Adapter中的getVi
ew方法返回的。这样就会容易理解数据是怎样一条一条显示在ListView中的。
 * @author XFHY
 *
 */
public class MyAdapter extends BaseAdapter{

	private Context context;    //承接上下文用的对象,在构造函数中被初始化
	
	/*
	 * Cursor 是每行的集合。
		使用 moveToFirst() 定位第一行。
		你必须知道每一列的名称。
		你必须知道每一列的数据类型。
		Cursor 是一个随机的数据源。
		所有的数据都是通过下标取得。
	 * */
	
	private Cursor cursor;      //接收数据库的
	LinearLayout layout;        //线性布局
	
	public MyAdapter(Context context,Cursor cursor)
	{
		this.context = context;
		this.cursor = cursor;
	}
	
	@Override
	public int getCount() {
		//返回长度
		return cursor.getCount();
	}

	//得到位置
	@Override
	public Object getItem(int position) {
		return cursor.getPosition();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	//相当于返回一行中的数据
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		/*
		 * 在实际开发中LayoutInflater这个类还是非常有用的，它的作用类似于findViewById()。
		 * 不同点是LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化；
		 * 而findViewById()是找xml布局文件下的具体widget控件(如Button、TextView等)。
			具体作用：
			1、对于一个没有被载入或者想要动态载入的界面，都需要使用LayoutInflater.inflate()来载入；
			2、对于一个已经载入的界面，就可以使用Activiyt.findViewById()方法来获得其中的界面元素。
		 * */
		LayoutInflater inflater = LayoutInflater.from(context);
		//LinearLayout类型的,将布局设置成LinearLayout
		layout = (LinearLayout) inflater.inflate(R.layout.cell, null); 
		
		//内容
		TextView contenttv = (TextView)layout.findViewById(R.id.list_content);
		//时间
		TextView timetv = (TextView)layout.findViewById(R.id.list_time);
		
		//图片
		ImageView imgiv = (ImageView)layout.findViewById(R.id.list_img);
		//视频
		ImageView videoiv = (ImageView)layout.findViewById(R.id.list_video);
		
		//cursor是用来放数据库的
		cursor.moveToPosition(position);  //游标移动到指定位置  这个是在ListView里面
		
		//接收获取的内容
		String content = cursor.getString(cursor.getColumnIndex("content"));  
		String time = cursor.getString(cursor.getColumnIndex("time"));
		String url = cursor.getString(cursor.getColumnIndex("path"));
		String urlvideo = cursor.getString(cursor.getColumnIndex("video"));
		
		contenttv.setText(content);   //将内容设置到LinearLayout布局里
		timetv.setText(time);         //将时间设置到LinearLayout布局里
		videoiv.setImageBitmap(getVideoThumbnail(urlvideo,200,200,
				MediaStore.Images.Thumbnails.MICRO_KIND));   //添加视频缩略图
		imgiv.setImageBitmap(getImageThumbnail(url,200,200)); //将缩略图放到布局里
		return layout;                //返回布局
	}
	
	//得到缩略图                                                    地址,宽度,高度
	public Bitmap getImageThumbnail(String uri,int width,int height)
	{
		Bitmap bitmap = null;   //初始化
		
		//通过这个来处理,直接获取缩略图
		BitmapFactory.Options options = new BitmapFactory.Options();
		
		//当指定inJustDecodeBounds时候，只解析图片的长度和宽度，不载入图片
		options.inJustDecodeBounds = true;   
		bitmap = BitmapFactory.decodeFile(uri,options);    //获取这张图片
		options.inJustDecodeBounds = false;
		
		//获取当前的高度和宽度,可以获得缩略图之后的高度和宽度
		int beWidth = options.outWidth/width;   //缩略图之后的高度和宽度
		int beHeight = options.outHeight/height;
		int be=1;
		if(beWidth<beHeight)   //放在图片跑出届外
		{
			be = beWidth;
		}
		else
		{
			be = beHeight;
		}
		
		//图片太小了
		if(be<=0)
		{
			be=1;
		}
		
		//当指定inSampleSize的时候，会根据inSampleSize载入一个缩略图。
		//比如inSampleSize=4，载入的缩略图是原图大小的1/4。
		options.inSampleSize = be;
		
		//重新获取图片,这个时候就是缩略之后的图片了
		bitmap = BitmapFactory.decodeFile(uri,options); 
		bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
				ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		return bitmap;
	}
	
	private Bitmap getVideoThumbnail(String uri,int width,int height,int kind)
	{
		Bitmap bitmap = null;
		bitmap = ThumbnailUtils.createVideoThumbnail(uri, kind);  //获取缩略图
		bitmap = ThumbnailUtils.extractThumbnail(
				bitmap, width, height,ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		
		return bitmap;
	}
}
