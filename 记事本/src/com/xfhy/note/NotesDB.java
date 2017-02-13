package com.xfhy.note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建数据库
 * @author XFHY
 *
 */
public class NotesDB extends SQLiteOpenHelper{

	public static final String TABLE_NAME = "notes";  //表名
	public static final String CONTENT = "content";   //内容
	public static final String PATH = "path";         //图片
	public static final String VIDEO = "video";       //视频
	public static final String ID = "_id";            //id
	public static final String TIME = "time";         //时间
	public NotesDB(Context context) {
		super(context, "notes", null, 1);
	}

	/**
	 * 创建数据库
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建表,ID自增,内容列,时间列
		//TABLE_NAME   CONTENT TIME
		String sql = "CREATE TABLE "+TABLE_NAME+"("
				+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				CONTENT+" TEXT NOT NULL,"+
				PATH+" TEXT ,"+
				VIDEO+" TEXT ,"+
				TIME+" TEXT )";
		/*String sql = "CREATE TABLE "+TABLE_NAME+"("
				+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				CONTENT+" TEXT NOT NULL,"+
				TIME+" TEXT NOT NULL)";*/
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//数据库升级
	}

}
