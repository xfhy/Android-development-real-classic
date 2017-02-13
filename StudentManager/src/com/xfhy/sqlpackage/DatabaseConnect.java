package com.xfhy.sqlpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * 连接数据库用的
 * 
 * @author XFHY
 * 
 */
public class DatabaseConnect {
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://localhost:1433; DatabaseName=StudMan";
	public static final String DBUSER = "XFHY";
	public static final String DBPASSEORD = "w122567";

	// 连接数据库
	public static Connection connDatabase() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER); // 加载驱动
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSEORD); // 连接数据库
		} catch (Exception e) {
			System.out.println("Connection");
			JOptionPane.showMessageDialog(null, "连接数据库失败！！！", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return conn;
	}
    
	//专门用来关闭Connection对象的
	public static void closeConnection(Connection conn) {
		if(conn!=null){
			try {
				conn.close(); // 关闭数据库
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "关闭数据库失败！！！", "☆★提示信息☆★",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
    
	//关闭Statement对象的
	public static void closeStatement(Statement stat) {
		if (stat != null){
			try {
				stat.close(); // 关闭数据库
			} catch (Exception e2) {
				System.out.println("Statement");
				JOptionPane.showMessageDialog(null, "关闭数据库失败！！！", "☆★提示信息☆★",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//关闭
	public static void closeResultset(ResultSet results) {
		if (results != null){
			try {
				results.close(); // 关闭数据库
			} catch (Exception e2) {
				System.out.println("ResultSet");
				JOptionPane.showMessageDialog(null, "关闭数据库失败！！！", "☆★提示信息☆★",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
