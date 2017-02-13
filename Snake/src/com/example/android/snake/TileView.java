package com.example.android.snake;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;


//View 变种，用来处理 一组 贴片—— “icons”或其它可绘制的对象  
public class TileView extends View {

    /**
     * Parameters controlling the size of the tiles and their range within view.
     * Width/Height are in pixels, and Drawables will be scaled to fit to these
     * dimensions. X/Y Tile Counts are the number of tiles that will be drawn.
     */

    protected static int mTileSize; //每个tile的边长的像素数量

    protected static int mXTileCount; //屏幕内能容纳的 X方向上方块的总数量
    protected static int mYTileCount;//屏幕内能容纳的 Y方向上方块的总数量

    private static int mXOffset; //原点坐标，按pixel计。
    private static int mYOffset;


    /**
     * 存储着不同种类的bitmap图。通过resetTiles，loadTile，将游戏中的方块加载到这个数组。
     * 可以理解为 砖块字典
     */
    private Bitmap[] mTileArray;    

    /**
     * A two-dimensional array of integers in which the number represents the
     * index of the tile that should be drawn at that locations
     * 存储整个界面内每个tile位置应该绘制的tile。
     * 可看作是我们直接操作的画布。
     * 通过setTile、clearTile 进行图形显示的修改操作。 
     * 
     */
    private int[][] mTileGrid; 

    //画笔，canvas的图形绘制，需要画笔Paint实现。
    private final Paint mPaint = new Paint();

    
   public TileView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //使用TypedArray，获取在attrs.xml中为TileView定义的新属性tileSize 。
            //参考： http://weizhulin.blog.51cto.com/1556324/311453
        ////获得风格属性组
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
      //获得R.styleable.TileView_tileSize,缺省值为12
        mTileSize = a.getInt(R.styleable.TileView_tileSize, 12);
      //返回先前使用过的风格属性集，使用TypedArray后一定要使用这个。
        a.recycle();
    }

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
        mTileSize = a.getInt(R.styleable.TileView_tileSize, 12);
        a.recycle();
    }

    
    
    /**
     * Rests the internal array of Bitmaps used for drawing tiles, and
     * sets the maximum index of tiles to be inserted
     * 重置清零mTileArray，在游戏初始的时候使用。
     * 即清空砖块字典
     * @param tilecount
     */
    public void resetTiles(int tilecount) {
    	mTileArray = new Bitmap[tilecount];
    }

    
    /*
     * 当改变屏幕大小尺寸时，同时修改tile的相关计数指标。
     */
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    	//Math.floor就是求一个最接近它的整数，它的值小于或等于这个浮点数。
    	// 定义X轴贴片数量  
        mXTileCount = (int) Math.floor(w / mTileSize);
        mYTileCount = (int) Math.floor(h / mTileSize);

        //mXOffset mYOffset是绘图的起点坐标。  把下面2句去掉后,暂时没看出影响
        mXOffset = ((w - (mTileSize * mXTileCount)) / 2);
        mYOffset = ((h - (mTileSize * mYTileCount)) / 2);

        mTileGrid = new int[mXTileCount][mYTileCount];
        clearTiles();
    }

    
    /**
     * Function to set the specified Drawable as the tile for a particular
     * integer key.
     * 加载具体的砖块图片 到 砖块字典。
     * 即将对应的砖块的图片 对应的加载到 mTileArray数组中
     * @param key
     * @param tile
     */
    public void loadTile(int key, Drawable tile) {
        //这里做了一个 Drawable 到 bitmap 的转换。由于外部程序使用的时候是直接读取资源文件中的图片，
    	//是drawable格式，而我们的数组是bitmap格式，方便最终的绘制。所以，需要进行一次到 bitmap的转换。
    	Bitmap bitmap = Bitmap.createBitmap(mTileSize, mTileSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        tile.setBounds(0, 0, mTileSize, mTileSize);
        tile.draw(canvas);
        
        mTileArray[key] = bitmap;
    }

    /**
     * Used to indicate that a particular tile (set with loadTile and referenced
     * by an integer) should be drawn at the given x/y coordinates during the
     * next invalidate/draw cycle.
     * 在相应的坐标位置绘制相应的砖块
     * 记得哦，mTileGrid其实就是我们直接操作的画布。
     * @param tileindex
     * @param x
     * @param y
     */
    public void setTile(int tileindex, int x, int y) {
        mTileGrid[x][y] = tileindex;
    }

    /**
     * Resets all tiles to 0 (empty)
     * 清空图形显示。
     * 用以更新画面。
     * 调用了绘图的setTile()。
     */
    public void clearTiles() {
        for (int x = 0; x < mXTileCount; x++) {
            for (int y = 0; y < mYTileCount; y++) {
                setTile(0, x, y);
            }
        }
    }

/*
 * 将我们直接操作的画布绘制到手机界面上！
 * @see android.view.View#onDraw(android.graphics.Canvas)
 */
    //覆盖： View 中的 onDraw(...)
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mXTileCount; x++) {
            for (int y = 0; y < mYTileCount; y++) {
                if (mTileGrid[x][y] > 0) {
                    canvas.drawBitmap(mTileArray[mTileGrid[x][y]], 
                    		mXOffset + x * mTileSize,
                    		mYOffset + y * mTileSize,
                    		mPaint);
                }
            }
        }
    }

}