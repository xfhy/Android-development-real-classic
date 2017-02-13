package com.xfhy.mysqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	private static final String databasename = "xfhy.db";  //数据库名称
	private static final int databaseverson=1;   //数据库版本
	private static final String tablename="mytab";    //数据表名称
	
	//构造函数
	public MyDatabaseHelper(Context context) 
	{
		super(context, databasename, null, databaseverson);   
	}

	/**
	 * 创建数据库
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//create table tablename(id integer primary key,name varchar(50) not null,birthday date not null)
		String sql = "create table "+tablename+"("+"id integer primary key,"+
		"name varchar(50) not null,"+
		"birthday date not null)";
		db.execSQL(sql);

	}

	//当数据库需要升级时,调用此方法,一般在此方法中将数据表删除,并且在删除表之后往往会调用onCreate()方法重新创建新的数据表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "drop table if exists "+tablename;
		db.execSQL(sql);
		this.onCreate(db);    //创建表

	}

}
