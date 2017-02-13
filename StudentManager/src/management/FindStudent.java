package com.xfhy.management;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindStudent {

	private JFrame jframe;
	Object[] os = new Object[8];

	public FindStudent() {
		jframe = new JFrame("查找学生界面");

		/*-----面板的定义-----*/
		JPanel findIdpanel = new JPanel(); // 查找学号面板
		JPanel findBtnpanel = new JPanel(); // 查找学号面板
		JPanel idpanel = new JPanel(); // 学号面板
		JPanel namepanel = new JPanel(); // 姓名面板
		JPanel passwdpanel = new JPanel(); // 密码面板
		JPanel sexpanel = new JPanel(); // 性别面板
		JPanel adrepanel = new JPanel(); // 地址面板
		JPanel phonepanel = new JPanel(); // 电话面板
		JPanel dormpanel = new JPanel(); // 宿舍面板
		JPanel scorepanel = new JPanel(); // 成绩面板
		JButton find = new JButton("查询学生");

		/*-----标签------*/
		JLabel findidJlabel = new JLabel("查找学生姓名"); // 标签
		JLabel idJlabel = new JLabel("学号"); // 学号标签
		JLabel nameJlabel = new JLabel("姓名"); // 姓名标签
		JLabel passwdJlabel = new JLabel("密码"); // 密码标签
		JLabel sexJlabel = new JLabel("性别"); // 性别标签
		JLabel adreJlabel = new JLabel("地址"); // 地址标签
		JLabel phoneJlabel = new JLabel("电话"); // 电话标签
		JLabel dormJlabel = new JLabel("宿舍"); // 宿舍标签
		JLabel scoreJlabel = new JLabel("成绩"); // 成绩标签

		/*-------文本框--------*/
		final JTextField findnameText = new JTextField(15);
		final JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);

		find.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String sname = findnameText.getText();
				os = StudentIdSelect.selectName(sname);
				//判断用户输入的是否是空值,    数据库查询返回的是否是空值
				if (!sname.equals("") && os[7] != null) {
					idText.setText((String) os[0]);
					nameText.setText((String) os[1]);
					passwdText.setText((String) os[2]);
					sexText.setText((String) os[3]);
					adreText.setText((String) os[4]);
					phoneText.setText((String) os[5]);
					dormText.setText((String) os[6]);
					scoreText.setText(os[7].toString());
				} else {
					JOptionPane.showMessageDialog(null, "找不到该学生!!!",
							"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE); // 提示查询指定用户信息时发生异常
				}
			}
		});

		// 添加组件到面板
		findIdpanel.add(findidJlabel);
		findIdpanel.add(findnameText);
		findBtnpanel.add(find);
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

		// 添加面板到窗口
		jframe.add(findIdpanel);
		jframe.add(findBtnpanel);
		jframe.add(idpanel);
		jframe.add(namepanel);
		jframe.add(passwdpanel);
		jframe.add(sexpanel);
		jframe.add(adrepanel);
		jframe.add(phonepanel);
		jframe.add(dormpanel);
		jframe.add(scorepanel);
		jframe.setLayout(new GridLayout(10, 1)); // 设置布局方式

		// 宽度,高度
		Dimension d = new Dimension(400, 500); // 创建一个Dimension对象,用来设置窗口大小的
		Point p = new Point(100, 100); // 创建一个Point,用来设置窗口的初始位置
		jframe.setSize(d); // 设置窗体大小
		jframe.setLocation(p); // 初始位置
		jframe.setResizable(false); // 设置窗口大小不可变
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭方式
		jframe.setVisible(true); // 设置窗体可见
	}

	public static void main(String[] args) {
		FindStudent fs = new FindStudent();
	}

}
