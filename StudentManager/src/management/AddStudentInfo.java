package com.xfhy.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import com.xfhy.sqlpackage.DatabaseConnect;

public class AddStudentInfo {

	// 更新学生的信息
	public static boolean updateSQL(String id, String sname, String passwrd,
			String sex, String haddress, String phone, String dorm) {
		// 调用DatabaseConnect的connDatabase()可以获得连接数据库的Connection对象
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null; // 声明PreparedStatement对象
		int reset = 0;
		// UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'
		String sql = "update student set sname = ?,passwrd = ?,sex = ?,haddress = ?,phone = ?,dorm = ? where "
				+ "id = ?";
		try {
			conn = dataConnect.connDatabase();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, sname);
			prestat.setString(2, passwrd);
			prestat.setString(3, sex);
			prestat.setString(4, haddress);
			prestat.setString(5, phone);
			prestat.setString(6, dorm);
			prestat.setString(7, id);
			reset = prestat.executeUpdate(); // 返回受到影响的行数
			if (reset > 0) {
				return true; // 受到影响的行数不为0,则成功修改
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改指定用户信息时发生异常", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE); // 提示修改指定用户信息时发生异常
		} finally {
			// 自己写的,DatabaseConnect类中的一个静态方法,用来关闭数据库连接
			DatabaseConnect.closeConnection(conn);
		}
		return false;
	}

	// 添加学生信息
	public static boolean addStuSQL(String id, String sname, String passwrd,
			String sex, String haddress, String phone, String dorm,
			String result) {
		// 调用DatabaseConnect的connDatabase()可以获得连接数据库的Connection对象
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null;
		int count = 0; // 返回数据库中操作成功的行数
		String addsql = "insert into student values(?,?,?,?,?,?,?,?)";
		try {
			conn = dataConnect.connDatabase(); // 获得连接数据库的Connection对象
			prestat = conn.prepareStatement(addsql); // 实例化PreparedStatement对象
			prestat.setString(1, id);
			prestat.setString(2, sname);
			prestat.setString(3, passwrd);
			prestat.setString(4, sex);
			prestat.setString(5, haddress);
			prestat.setString(6, phone);
			prestat.setString(7, dorm);
			prestat.setString(8, result);
			/*
			 * 在此 PreparedStatement 对象中执行 SQL 语句，该 语句必须是一个 SQL 数据操作语言（Data
			 * Manipulation Language，DML）语句， 比如 INSERT、UPDATE 或 DELETE 语句；
			 * 返回:SQL 数据操作语言 (DML) 语句的行数
			 */
			count = prestat.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加学生信息时发生异常", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE); // 提示修改指定用户信息时发生异常
		} finally {
			DatabaseConnect.closeConnection(conn);
			DatabaseConnect.closeStatement(prestat);
		}
		return false;
	}

	// 返回学生的全部信息
	public static List<Object> selectStuSQL() {
		Object[] os;
		List<Object> list = new ArrayList<Object>();
		// 调用DatabaseConnect的connDatabase()可以获得连接数据库的Connection对象
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet rs = null;
		String selectsql = "select * from student";
		try {
			conn = DatabaseConnect.connDatabase();
			prestat = conn.prepareStatement(selectsql);
			rs = prestat.executeQuery();
			while (rs.next()) {
				os = new Object[8];
				double point = rs.getDouble(8);
				os[0] = rs.getString(1);
				os[1] = rs.getString(2);
				os[2] = rs.getString(3);
				os[3] = rs.getString(4);
				os[4] = rs.getString(5);
				os[5] = rs.getString(6);
				os[6] = rs.getString(7);
				os[7] = new Double(point);
				list.add(os);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询数据库发生异常", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);
		} finally {
			DatabaseConnect.closeConnection(conn);
		}
		return list;
	}

	// 返回平均成绩
	public static double aveScoreStu() {
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet rs = null;
		double score = 0 ;
		String sql = "select avg(result) from student";
		try {
			conn = DatabaseConnect.connDatabase();
			prestat = conn.prepareStatement(sql);
			rs = prestat.executeQuery();
			while(rs.next())
			{
				score = rs.getDouble(1);   //返回的结果是从1开始的
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return score;
	}

	// 删除学生信息
	public static boolean deleteStuSQL(String id) {
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null;
		String deletesql = "delete student where id=?";
		int count = 0;
		try {
			conn = dataConnect.connDatabase();
			prestat = conn.prepareStatement(deletesql);
			prestat.setString(1, id);
			count = prestat.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败！！！", "☆★提示信息☆★",
					JOptionPane.INFORMATION_MESSAGE);
		} finally {
			DatabaseConnect.closeConnection(conn);
			DatabaseConnect.closeStatement(prestat);
		}
		return false;
	}
}
