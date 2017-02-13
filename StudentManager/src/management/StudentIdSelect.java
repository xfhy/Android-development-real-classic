package com.xfhy.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.xfhy.sqlpackage.DatabaseConnect;

/**
 * 根据传进来的ID查询数据库中的该ID的信息,再返回数据
 * @author XFHY
 *
 */
public class StudentIdSelect {

	private String id = "";
	public static Object[] selectID(String id)
	{
		DatabaseConnect dataconnect = new DatabaseConnect();
		Connection conn =  null;
		PreparedStatement prestat = null;
		ResultSet reset = null;
		String sql = "";
		Object[] os = new Object[8];  //8个属性
		try {
			conn = dataconnect.connDatabase();
			sql = "select id,sname,passwrd,sex,haddress,phone,dorm,result from student where id=?";
			prestat = conn.prepareStatement(sql);  //将id设置到sql语句中
			prestat.setString(1, id);
			reset = prestat.executeQuery();
			while(reset.next())
			{
				double point = reset.getDouble(8);
				os[0] = reset.getString(1);
				os[1] = reset.getString(2);
				os[2] = reset.getString(3);
				os[3] = reset.getString(4);
				os[4] = reset.getString(5);
				os[5] = reset.getString(6);
				os[6] = reset.getString(7);
				os[7] = new Double(point);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "查询指定用户信息时发生异常", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);		//提示查询指定用户信息时发生异常
		} finally {
			DatabaseConnect.closeConnection(conn);
		}
		return os;
	}
	public static Object[] selectName(String name)
	{
		DatabaseConnect dataconnect = new DatabaseConnect();
		Connection conn =  null;
		PreparedStatement prestat = null;
		ResultSet reset = null;
		String sql = "";
		Object[] os = new Object[8];  //8个属性
		try {
			conn = dataconnect.connDatabase();
			sql = "select id,sname,passwrd,sex,haddress,phone,dorm,result from student where sname=?";
			prestat = conn.prepareStatement(sql);  //将id设置到sql语句中
			prestat.setString(1, name);
			reset = prestat.executeQuery();
			while(reset.next())
			{
				double point = reset.getDouble(8);
				os[0] = reset.getString(1);
				os[1] = reset.getString(2);
				os[2] = reset.getString(3);
				os[3] = reset.getString(4);
				os[4] = reset.getString(5);
				os[5] = reset.getString(6);
				os[6] = reset.getString(7);
				os[7] = new Double(point);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "查询指定用户信息时发生异常", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);		//提示查询指定用户信息时发生异常
		} finally {
			DatabaseConnect.closeConnection(conn);
		}
		return os;
	}
}
