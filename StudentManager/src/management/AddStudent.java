package com.xfhy.management;

import java.awt.Dimension;
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

/**
 * 添加学生信息 2016年7月15日20:53:34
 * 
 * @author XFHY
 * 
 */
public class AddStudent {

	private JFrame jframe;

	public AddStudent() {
		jframe = new JFrame("添加学生界面");
		/*-----面板的定义-----*/
		JPanel idpanel = new JPanel(); // 学号面板
		JPanel namepanel = new JPanel(); // 姓名面板
		JPanel passwdpanel = new JPanel(); // 密码面板
		JPanel sexpanel = new JPanel(); // 性别面板
		JPanel adrepanel = new JPanel(); // 地址面板
		JPanel phonepanel = new JPanel(); // 电话面板
		JPanel dormpanel = new JPanel(); // 宿舍面板
		JPanel scorepanel = new JPanel(); // 成绩面板
		JPanel controlpanel = new JPanel(); // 控制面板

		/*-----标签------*/
		JLabel idJlabel = new JLabel("*学号"); // 学号标签
		JLabel nameJlabel = new JLabel("*姓名"); // 姓名标签
		JLabel passwdJlabel = new JLabel("*密码"); // 密码标签
		JLabel sexJlabel = new JLabel("性别"); // 性别标签
		JLabel adreJlabel = new JLabel("地址"); // 地址标签
		JLabel phoneJlabel = new JLabel("电话"); // 电话标签
		JLabel dormJlabel = new JLabel("宿舍"); // 宿舍标签
		JLabel scoreJlabel = new JLabel("成绩"); // 成绩标签

		/*------按钮------*/
		JButton addSt = new JButton("添加学生");
		JButton reset = new JButton("重置");
		JButton exit = new JButton("退出");

		/*-------文本框--------*/
		final JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);

		// 添加学生信息到数据库按钮 监听器
		addSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = idText.getText();
				String sname = nameText.getText();
				String passwrd = passwdText.getText();
				String sex = sexText.getText();
				String haddress = adreText.getText();
				String phone = phoneText.getText();
				String dorm = dormText.getText();
				String result = scoreText.getText();
				if (!id.equals("") && !sname.equals("") && !passwrd.equals("")) {
					if (AddStudentInfo.addStuSQL(id, sname, passwrd, sex, haddress,
							phone, dorm, result)) {
						JOptionPane.showMessageDialog(null, "添加学生信息成功~",
								"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "添加学生信息时发生异常",
								"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE); // 提示修改指定用户信息时发生异常
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "打了*的不能为空",
							"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// 重置当前输入框中输入的信息
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idText.setText("");
				nameText.setText("");
				passwdText.setText("");
				sexText.setText("");
				adreText.setText("");
				phoneText.setText("");
				dormText.setText("");
				scoreText.setText("");
			}
		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// 这里返回老师的管理菜单界面
				new TeacherMenu();
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
		controlpanel.add(addSt);
		controlpanel.add(reset);
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
		jframe.setLocation(p); // 初始位置
		jframe.setResizable(false); // 设置窗口大小不可变
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭方式
		jframe.setVisible(true); // 设置窗体可见
	}

	public static void main(String[] args) {
		AddStudent addStudent = new AddStudent();
	}

}
