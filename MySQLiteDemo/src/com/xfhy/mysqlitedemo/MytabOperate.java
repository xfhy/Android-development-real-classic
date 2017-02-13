package com.xfhy.mysqlitedemo;

import android.database.sqlite.SQLiteDatabase;

public class MytabOperate {

	private static final String TABLENAME="mytab";   //表名称
	private SQLiteDatabase db = null;                //SQLiteDatabase
	public MytabOperate(SQLiteDatabase db)   //构造方法
	{
		this.db = db;
	}
	
	 //添加
	public void insert(String name,String birthday) 
	{
		String sql = "INSERT INTO " + TABLENAME +"(name,birthday) VALUES('"+
				name+"','"+birthday+"')";   //sql语句
		this.db.execSQL(sql);     //执行SQL语句
		this.db.close();    //用完数据库,记得关闭
	}
	
	//更新
	public void update(int id,String name,String birthday)
	{
		String sql = "UPDATE "+TABLENAME+" SET name='"+name+"',birthday='"+birthday+"' WHERE id="+id;
		this.db.execSQL(sql);  //执行SQL语句
		this.db.close();   //用完数据库,记得关闭
	}
	
	//删除
	public void delete(int id)
	{
		String sql = "delete from "+TABLENAME+" WHERE id="+id;
		this.db.execSQL(sql);
		this.db.close();
	}
}
