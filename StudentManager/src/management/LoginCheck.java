package com.xfhy.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 登录界面的检查
 * 与数据库连接的登录界面,连接数据库,代码如下
 * 1.定义属性(final 常量)数据库驱动程序,数据库URL,数据库登录名和密码
 * 2.构造方法,从构造方法中传入用户输入的用户名和密码
 * 3.加载驱动,实例化Connection对象,连接数据库
 * 4.使用PreparedStatement实例执行SQL语句,看看是否能得出结果,得出则登录成功!返回true
 * @author XFHY
 *
 */
public class LoginCheck {
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://localhost:1433; DatabaseName=StudMan";
	public static final String DBUSER = "XFHY";
	public static final String DBPASSEORD = "w122567";
	private String loginPeople="";
	private String name="";
	private String passwd="";
	public LoginCheck(){}  //无参构造函数
	public LoginCheck(String name,String passwd)  //有参构造函数
	{
		this.name = name;
		this.passwd = passwd;
	}
	public LoginCheck(String loginPeople,String name,String passwd)  //有参构造函数
	{
		this.loginPeople = loginPeople;
		this.name = name;
		this.passwd = passwd;
	}
	
	//连接数据库
	public Connection connDatabase()
	{
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);  //加载驱动
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSEORD);  //连接数据库
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"连接数据库失败！！！","☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return conn;
	}
	
	//使用PreparedStatement实例执行SQL语句
	public boolean prepared()
	{
		Connection conn = null;
		PreparedStatement perstat = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = connDatabase();  //初始化Connection对象
			if(loginPeople.equals("Student"))
			    sql = "select id,passwrd from student where id=? and passwrd=?";
			else
				sql = "select id,passwrd from teacher where id=? and passwrd=?";
			perstat = conn.prepareStatement(sql);  //生成PreparedStatement对象
			 //setString函数是给表的列赋值，而不能给直接赋表名~
			perstat.setString(1, name);   //传入用户名到上面的那条不完整的SQL语句中
			perstat.setString(2, passwd); //传入密码到上面的那条不完整的SQL语句中
			rs = perstat.executeQuery();  //执行查询语句,并接收返回结果
			if(rs.next())   //如果有值,则找到了合法的用户
			{
				return true;   
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"登录查询失败！！！","☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);
		} finally {
			try {
				conn.close();   //关闭数据库
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"关闭数据库失败！！！","☆★提示信息☆★",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return false;   //数据库中找不到合法的用户
	}
}
