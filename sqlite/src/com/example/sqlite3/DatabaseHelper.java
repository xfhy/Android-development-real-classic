package com.example.sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * DatabaseHelper作为一个访问SQLite的助手类,提供2个方面的功能
 * 第一:getReadableDatabase(),getWritableDatabase()可以获得SQLiteDatabase对象,通过该对象可以实现增删查改
 * 第二:提供了onCreate()和onUpgrade()两个回调函数,允许我们在创建和升级数据库时,进行操作
 * */
public class DatabaseHelper extends SQLiteOpenHelper{

	//这是数据库的版本
	private static final int VERSION = 1;
	//在SQLiteOpenHelper子类当中必须有该构造函数
	//参数(依次):Activity对象,表的名字,暂时不介绍(传入空值即可),数据库版本
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		//必须通过super调用父类的构造函数
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	//构造函数2
	public DatabaseHelper(Context context,String name) {
		super(context,name,null, VERSION);
		// TODO Auto-generated constructor stub
	}
	//构造函数3
	public DatabaseHelper(Context context, String name,int version) {
		super(context, name, null, version);
	}
	//创建数据库 第一次调用是在getReadableDatabase()或者getWritableDatabase()执行后
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("create a Database");
		//execSQL执行的是sql语句
		db.execSQL("create table user(id int,name varchar(20))");
	}

	//更新数据库
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("update a Database");
	}

}
