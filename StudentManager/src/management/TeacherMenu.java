package com.xfhy.management;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TeacherMenu {
	JFrame jframe = new JFrame("教师管理界面");
	JLabel scoreLabel = new JLabel("",JLabel.CENTER);

	public TeacherMenu() {
		
		JMenuBar mb = new JMenuBar();  //菜单条    菜单条只有一个
		
		JMenu stuMenu = new JMenu("学生");//菜单条上的菜单,就是第一行需要显示的东西
		JMenu scoreMenu = new JMenu("成绩");
		
		JMenuItem addItem = new JMenuItem("添加学生");  //子菜单
		JMenuItem deleteItem = new JMenuItem("删除学生");
		JMenu findItem = new JMenu("查询学生");   //如果需要添加有子菜单的菜单项,则需弄成JMenu类型即可
		JMenuItem findNameItem = new JMenuItem("姓名查询");   //这是子菜单里的菜单项
		JMenuItem findAllItem = new JMenuItem("全部查询");
		JMenuItem aveScore = new JMenuItem("平均成绩");
		
		
		//添加学生    菜单点击,监听事件
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddStudent();
				//jframe.setVisible(false);
				jframe.dispose();
			}
		});
		
		//删除学生
		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeleteStudent();
				jframe.dispose();
			}
		});
		
		//姓名查找学生
		findNameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FindStudent();
				jframe.dispose();
			}
		});
		
		//查询全部学生
		findAllItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AllStudent();
				jframe.dispose();
			}
		});
		
		//显示成绩
		aveScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double score = AddStudentInfo.aveScoreStu();  //求平均成绩
				Font font = new Font("楷体",Font.BOLD,35);
				scoreLabel.setFont(font);
				scoreLabel.setText("平均成绩是"+Double.toString(score));
			}
		});
		
		stuMenu.add(addItem);      //添加子菜单
		stuMenu.addSeparator();   //添加横线
		stuMenu.add(deleteItem);
		stuMenu.addSeparator();
		stuMenu.add(findItem);
		scoreMenu.add(aveScore);
		
		findItem.add(findNameItem);  //子菜单里的菜单项
		findItem.addSeparator();
		findItem.add(findAllItem);
		
		mb.add(stuMenu);  //菜单栏上的主菜单
		mb.add(scoreMenu);
		jframe.setJMenuBar(mb);   //设置菜单栏
		jframe.add(scoreLabel);
		
		// 宽度,高度
		Dimension d = new Dimension(400, 300); // 创建一个Dimension对象,用来设置窗口大小的
		Point p = new Point(100, 100); // 创建一个Point,用来设置窗口的初始位置
		jframe.setSize(d); // 设置窗体大小
		jframe.setLocation(p);
		jframe.setResizable(false); // 设置窗口大小不可变
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭方式
		jframe.setVisible(true); // 设置窗体可见
	}

	public static void main(String[] args) {
		TeacherMenu tm = new TeacherMenu();
	}

}
