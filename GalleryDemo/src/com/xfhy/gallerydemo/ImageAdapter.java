package com.xfhy.gallerydemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter{

	private int res[];
	private Context context;   //上下文信息
	
	//shift+alt+s   快速管理源代码   生成构造函数,get函数等
	public ImageAdapter(int[] res,Context context) {
		this.res = res;
		this.context = context;
	}

	//返回已定义的数据源的总数量
	@Override
	public int getCount() {
		//return res.length;
		//返回数据中的最大数,则可以实现Gallery的循环
		return Integer.MAX_VALUE;
	}

	//取得适配器中的数据对象
	@Override
	public Object getItem(int position) {
		return res[position];
	}

	//取得适配器中的数据ID
	@Override
	public long getItemId(int position) {
		return position;
	}

	//取得目前欲显示的图像View,传入数组ID值使之读取与成像
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image = new ImageView(context);      //初始化ImageView
		
		//image.setBackgroundResource(res[position]);
		
		//本来是应该上面那句的,但是%长度之和就会让Gallery循环
		image.setBackgroundResource(res[position%res.length]);    //设置背景资源
		Log.i("xfhy",position+"");
		
		//设置缩略图
		image.setLayoutParams(new Gallery.LayoutParams(300,300));   //设置宽高信息等
		
		//横向xy拉伸
		image.setScaleType(ScaleType.FIT_XY);   //设置imageView的缩放模式
		return image;
	}

}
