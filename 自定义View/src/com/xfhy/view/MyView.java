package com.xfhy.view;
/*
 * 像我们平时画图一样，需要两个工具，纸和笔。Paint就是相当于笔，而Canvas就是纸，这里叫画布。

所以，凡有跟要要画的东西的设置相关的，比如大小，粗细，画笔颜色，透明度，字体的样式等等，
都是在Paint里设置；
同样，凡是要画出成品的东西，比如圆形，矩形，文字等相关的都是在Canvas里生成。
 * 
 * */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

//自定义的一个类,继承自View
/*
 * 新建一个视图类，派生自View，为什么要新建视图类呢，因为我们要自由的显示东西，当然要重写视图类了，
 * 在OnDraw（）函数中返回什么，
 * 这个视图就会长什么样。话不多说，新建一个派生自View的类MyView，然后重写OnDraw()函数：
 * */
public class MyView extends View {

	private Context m_context;
	//构造函数
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		m_context = context;
	}
    
	//实现View
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//定义画笔
		Paint paint = new Paint();  
		paint.setAntiAlias(true);   //设置是否抗锯齿
		paint.setColor(Color.RED);  //设置画笔颜色
		
		/*
		 *  Style.FILL   :填充内部
		 *  Style.FILL_AND_STROKE :填充内部和描边
		 *  Style.STROKE          :仅描边
		 * */
		paint.setStyle(Style.STROKE); //设置填充样式
		paint.setStrokeWidth(10);   //设置画笔宽度
		
		//参数：radius:阴影的倾斜度,dx:水平位移,dy:垂直位移,颜色
		paint.setShadowLayer(10, 15, 15, Color.BLUE);   //设置画笔阴影
		
		//设置画布背景颜色
		canvas.drawRGB(255,255,255);
		
		//在画布上画圆,画笔是上面定义那个
		/*
		 * 圆形
			void drawCircle (float cx, float cy, float radius, Paint paint)
			
			参数：
			float cx：圆心点X轴坐标 
			float cy：圆心点Y轴坐标
			float radius：圆的半径
		 * */
		canvas.drawCircle(190, 200, 150, paint);
		
		//在画布上画一条线,起点是(100,400),终点(600,800)
		canvas.drawLine(100, 400, 600, 800, paint);
		
		//画几条线,(10,10)->(100,100) (200,200)->(400,400)两两连成一条线
		float[] pts = {10,10,100,100,200,200,400,400};
		canvas.drawLines(pts, paint);
		
		//画一个点,在(500,500)处
		canvas.drawPoint(500, 500, paint);
		
		//这是连续画几个点
		float[] pts2 = {15,15,105,105,205,205,405,405};
		canvas.drawPoints(pts2, paint);
		
		//void drawRect (float left, float top, float right, float bottom, Paint paint)
		//画一个矩形
		//left：矩形的左边位置(即x,y)。top：矩形的上边位置。right：矩形的右边位置。bottom：矩形的下边位置。
		canvas.drawRect(200, 200, 400, 400, paint);
		
		//用RectF对象画一个矩形
		//RectF rect1 = new RectF(200,400, 400, 600);
		//canvas.drawRect(rect1, paint);
		
		//用Rect对象画一个矩形
		//Rect rect2 = new Rect(200,600,400,800);
		//canvas.drawRect(rect2, paint);
		
		/*
		 * 7、圆角矩形
			void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
			参数：
			RectF rect:要画的矩形
			float rx:生成圆角的椭圆的X轴半径
			float ry:生成圆角的椭圆的Y轴半径
		 * */
		//RectF rect3 = new RectF(200,600,400,800);
		//canvas.drawRoundRect(rect3,30,30,paint);
		
		/*
		 * 椭圆

			椭圆是根据矩形生成的，以矩形的长为椭圆的X轴，矩形的宽为椭圆的Y轴，建立的椭圆图形
			
			void drawOval (RectF oval, Paint paint)
			
			参数：
			RectF oval：用来生成椭圆的矩形
		 * */
		RectF rect4 = new RectF(200,600,300,800);   //左,上,右,下
		//canvas.drawOval(rect4, paint);
		
		
		/*
		 * 弧
		弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；	
		void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)	
		参数：
		RectF oval:生成椭圆的矩形
		float startAngle：弧开始的角度，以X轴正方向为0度
		float sweepAngle：弧持续的角度
		boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧
		 * */
		canvas.drawArc(rect4,0,90,false, paint);
	}  

}
