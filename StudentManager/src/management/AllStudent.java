package com.xfhy.management;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AllStudent {

	private JFrame jframe;
	private List<Object> list;
	Object[] os = new Object[8];
	int countpeople = 0;
	int current = 0;

	public AllStudent() {
		list = AddStudentInfo.selectStuSQL();
		countpeople = list.size(); // 总人数
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
		JPanel countpanel = new JPanel(); // 总人数
		JPanel controlpanel = new JPanel(); // 控制面板

		/*-----标签------*/
		JLabel idJlabel = new JLabel("学  号"); // 学号标签
		JLabel nameJlabel = new JLabel("姓  名"); // 姓名标签
		JLabel passwdJlabel = new JLabel("密  码"); // 密码标签
		JLabel sexJlabel = new JLabel("性  别"); // 性别标签
		JLabel adreJlabel = new JLabel("地  址"); // 地址标签
		JLabel phoneJlabel = new JLabel("电  话"); // 电话标签
		JLabel dormJlabel = new JLabel("宿  舍"); // 宿舍标签
		JLabel scoreJlabel = new JLabel("成  绩"); // 成绩标签
		JLabel countJlabel = new JLabel("总人数");

		/*------按钮------*/
		JButton firstSt = new JButton("第一个");
		JButton upSt = new JButton("上一个");
		JButton nextSt = new JButton("下一个");
		JButton lastSt = new JButton("最后一个");

		/*-------文本框--------*/
		final JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);
		final JTextField countText = new JTextField(15);

		// 最初时,显示第一个学生的信息

		os = (Object[]) list.get(0);
		idText.setText(os[0].toString());
		nameText.setText(os[1].toString());
		passwdText.setText(os[2].toString());
		sexText.setText(os[3].toString());
		adreText.setText(os[4].toString());
		phoneText.setText(os[5].toString());
		dormText.setText(os[6].toString());
		scoreText.setText(os[7].toString());
		countText.setText(list.size() + "");

		firstSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				os = (Object[]) list.get(0);
				idText.setText(os[0].toString());
				nameText.setText(os[1].toString());
				passwdText.setText(os[2].toString());
				sexText.setText(os[3].toString());
				adreText.setText(os[4].toString());
				phoneText.setText(os[5].toString());
				dormText.setText(os[6].toString());
				scoreText.setText(os[7].toString());
				current = 0;
			}
		});

		upSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 已到达第一个
				if (current == 0) {
					JOptionPane.showMessageDialog(null, "已经是第一个了", "☆★提示信息☆★",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					os = (Object[]) list.get(current - 1);
					idText.setText(os[0].toString());
					nameText.setText(os[1].toString());
					passwdText.setText(os[2].toString());
					sexText.setText(os[3].toString());
					adreText.setText(os[4].toString());
					phoneText.setText(os[5].toString());
					dormText.setText(os[6].toString());
					scoreText.setText(os[7].toString());
					current--;
				}
			}
		});

		nextSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 已到达第一个
				if (current == (list.size() - 1)) {
					JOptionPane.showMessageDialog(null, "已经是最后一个了", "☆★提示信息☆★",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					os = (Object[]) list.get(current + 1);
					idText.setText(os[0].toString());
					nameText.setText(os[1].toString());
					passwdText.setText(os[2].toString());
					sexText.setText(os[3].toString());
					adreText.setText(os[4].toString());
					phoneText.setText(os[5].toString());
					dormText.setText(os[6].toString());
					scoreText.setText(os[7].toString());
					current++;
				}
			}
		});

		lastSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				os = (Object[]) list.get(countpeople - 1);
				idText.setText(os[0].toString());
				nameText.setText(os[1].toString());
				passwdText.setText(os[2].toString());
				sexText.setText(os[3].toString());
				adreText.setText(os[4].toString());
				phoneText.setText(os[5].toString());
				dormText.setText(os[6].toString());
				scoreText.setText(os[7].toString());
				current = countpeople - 1;
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
		countpanel.add(countJlabel);
		countpanel.add(countText);
		controlpanel.add(firstSt);
		controlpanel.add(upSt);
		controlpanel.add(nextSt);
		controlpanel.add(lastSt);

		// 添加面板到窗口
		jframe.add(idpanel);
		jframe.add(namepanel);
		jframe.add(passwdpanel);
		jframe.add(sexpanel);
		jframe.add(adrepanel);
		jframe.add(phonepanel);
		jframe.add(dormpanel);
		jframe.add(scorepanel);
		jframe.add(countpanel);
		jframe.add(controlpanel);
		jframe.setLayout(new GridLayout(10, 1)); // 设置布局方式

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
		AllStudent as = new AllStudent();
	}

}
