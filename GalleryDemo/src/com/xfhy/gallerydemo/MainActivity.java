package com.xfhy.gallerydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;

/*
 * 1.官方文档上Gallery已经不推荐使用了，可以用HorizontalScroll 和ViewPager代替实现
 * 2.ImageSwitcher和ImageView的功能有点类似,他们都可以用来显示图片,区别在于ImageSwitcher的效果
 * 更炫,它可以指定图片切换时的动画效果.要让ImageSwitcher显示图片则需要实现ViewFactory接口
 * 
 * 
 * Gallery组件主要用于横向显示图像列表，不过按常规做法。Gallery组件只能有限地显示指定的图像。
 * */
public class MainActivity extends Activity implements OnItemSelectedListener,ViewFactory{

	//准备数据源
	private int[] res = {R.drawable.a_1,R.drawable.a_2,R.drawable.a_3,R.drawable.a_4,
			R.drawable.a_5,R.drawable.a_6,R.drawable.a_7,
			R.drawable.a_8,R.drawable.a_9,R.drawable.a_10};
	private Gallery gallery;
	private ImageAdapter adapter;
	private ImageSwitcher is = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gallery = (Gallery)findViewById(R.id.gallery);
        is = (ImageSwitcher)findViewById(R.id.is);
        
        
        
        adapter = new ImageAdapter(res,this);
        //加载适配器
        gallery.setAdapter(adapter);
        
        
        gallery.setOnItemSelectedListener(this);
        is.setFactory(this);   //加载工厂
        
        //淡入效果
        is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        
        //淡出效果
        is.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    }

    //一般情况下,这个方法需要返回ImageView
	@Override
	public View makeView() {
		ImageView image = new ImageView(this);    //初始化图片,并设置参数(上下文信息)
		image.setScaleType(ScaleType.FIT_CENTER);   //按比例缩放图片,并且居中显示
		return image;
	}

	////会把当前选择的图片传递进来,还会传递图片的位置
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		is.setBackgroundResource(res[position%res.length]);   //设置显示,资源
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}
}
