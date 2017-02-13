package com.xfhy.management;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xfhy.sqlpackage.DatabaseConnect;

/**
 * 学生登录成功界面,显示学生的全部信息,可以编辑(学号,姓名,成绩不可被编辑)
 * 
 * @author XFHY
 * 
 */
public class StudentInfo {

	private String id = "";

	public StudentInfo() {
	}

	public StudentInfo(String id) {
		this.id = id;
		final Frame jframe = new JFrame("我的全部信息"); // 创建一个初始时,不可见的窗体,并设置窗口标题

		JPanel idpanel = new JPanel(); // 学号面板
		JPanel namepanel = new JPanel(); // 姓名面板
		JPanel passwdpanel = new JPanel(); // 密码面板
		JPanel sexpanel = new JPanel(); // 性别面板
		JPanel adrepanel = new JPanel(); // 地址面板
		JPanel phonepanel = new JPanel(); // 电话面板
		JPanel dormpanel = new JPanel(); // 宿舍面板
		JPanel scorepanel = new JPanel(); // 成绩面板
		JPanel controlpanel = new JPanel(); // 控制面板

		JLabel idJlabel = new JLabel("学号"); // 学号标签
		JLabel nameJlabel = new JLabel("姓名"); // 姓名标签
		JLabel passwdJlabel = new JLabel("密码"); // 密码标签
		JLabel sexJlabel = new JLabel("性别"); // 性别标签
		JLabel adreJlabel = new JLabel("地址"); // 地址标签
		JLabel phoneJlabel = new JLabel("电话"); // 电话标签
		JLabel dormJlabel = new JLabel("宿舍"); // 宿舍标签
		JLabel scoreJlabel = new JLabel("成绩"); // 成绩标签
		JButton ok = new JButton("确定");
		JButton edit = new JButton("编辑");
		JButton exit = new JButton("退出");

		// 文本框
		JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);

		// 文本框里的数据,通过StudentIdSelect类的selectID()方法查询到一个学生的数据,并存到Object[]数组里,再
		// 一个一个得读出数组的数据
		Object[] os = StudentIdSelect.selectID(id);
		idText.setText((String) os[0]);
		nameText.setText((String) os[1]);
		passwdText.setText((String) os[2]);
		sexText.setText((String) os[3]);
		adreText.setText((String) os[4]);
		phoneText.setText((String) os[5]);
		dormText.setText((String) os[6]);
		scoreText.setText(os[7].toString());
		
		idText.setEditable(false);
		nameText.setEditable(false);
		passwdText.setEditable(false);
		sexText.setEditable(false);
		adreText.setEditable(false);
		phoneText.setEditable(false);
		dormText.setEditable(false);
		scoreText.setEditable(false);
		
		final String idd = this.id;
		

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				/*----获取文本框内的内容-----*/
				String name = nameText.getText();
				String passwd = passwdText.getText();
				String sex = sexText.getText();
				String adre = adreText.getText();
				String phone = phoneText.getText();
				String dorm = dormText.getText();
				if(AddStudentInfo.updateSQL(idd, name, passwd, sex, adre, phone, dorm))
				{
					JOptionPane.showMessageDialog(null, "修改成功!", "☆★提示信息☆★",
							JOptionPane.INFORMATION_MESSAGE);		
				}
				else
				{
					JOptionPane.showMessageDialog(null, "修改失败!", "☆★提示信息☆★",
							JOptionPane.INFORMATION_MESSAGE);	
				}
				
			}
		});

		//ctrl+shift+f :自动整理格式   编辑按钮
		edit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				nameText.setEditable(true);
				passwdText.setEditable(true);
				sexText.setEditable(true);
				adreText.setEditable(true);
				phoneText.setEditable(true);
				dormText.setEditable(true);
			}
		});
		
		//退出按钮
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new Login();
				//System.exit(0);
				//jframe.setVisible(false);
				jframe.dispose();
			}
		});

		// 添加组件到面板
		idpanel.add(idJlabel);
		idpanel.add(idText);
		namepanel.add(nameJlabel);
		namepanel.add(nameText);
		passwdpanel.add(passwdJlabel);
		passwdpanel.add(passwdText);
		sexpanel.add(sexJlabel);
		sexpanel.add(sexText);
		adrepanel.add(adreJlabel);
		adrepanel.add(adreText);
		phonepanel.add(phoneJlabel);
		phonepanel.add(phoneText);
		dormpanel.add(dormJlabel);
		dormpanel.add(dormText);
		scorepanel.add(scoreJlabel);
		scorepanel.add(scoreText);
		controlpanel.add(ok);
		controlpanel.add(edit);
		controlpanel.add(exit);

		// 添加面板到窗口
		jframe.add(idpanel);
		jframe.add(namepanel);
		jframe.add(passwdpanel);
		jframe.add(sexpanel);
		jframe.add(adrepanel);
		jframe.add(phonepanel);
		jframe.add(dormpanel);
		jframe.add(scorepanel);
		jframe.add(controlpanel);
		jframe.setLayout(new GridLayout(9, 1)); // 设置布局方式

		// 宽度,高度
		Dimension d = new Dimension(400, 300); // 创建一个Dimension对象,用来设置窗口大小的
		Point p = new Point(100, 100); // 创建一个Point,用来设置窗口的初始位置

		jframe.setSize(d); // 设置窗体大小
		jframe.setLocation(p);

		jframe.setResizable(false); // 设置窗口大小不可变

		((JFrame) jframe).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭方式

		jframe.setVisible(true); // 设置窗体可见
	}

	public static void main(String[] args) {
		//StudentInfo si = new StudentInfo("1");
	}

}
