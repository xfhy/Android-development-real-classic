package com.xfhy.management;

import java.awt.Dimension;
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

/**
 * 删除学生(按照学号删除) 2016年7月16日13:09:10
 * 
 * @author XFHY
 * 
 */
public class DeleteStudent {
	private String id;
	private JFrame jframe;
	private JLabel idJlabel;
	final JTextField idText = new JTextField(15);

	public DeleteStudent() {
		jframe = new JFrame("删除学生界面");
		idJlabel = new JLabel("学号:");

		JPanel idpanel = new JPanel(); // 学号面板
		JPanel controlpanel = new JPanel(); // 控制面板

		// 添加学号和学号输入框到idpanel面板
		idpanel.add(idJlabel);
		idpanel.add(idText);

		JButton delete = new JButton("删除学生");
		JButton reset = new JButton("重置");
		JButton exit = new JButton("退出");

		// 删除学生
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id = idText.getText();
				if (!id.equals("")) {
					if (AddStudentInfo.deleteStuSQL(id)) {
						JOptionPane.showMessageDialog(null, "删除成功！！！",
								"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "删除失败！！！",
								"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "输入信息为空！！！",
							"☆★提示信息☆★", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// 重置当前输入框中输入的信息
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idText.setText("");
			}
		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// 这里返回老师的管理菜单界面
				new TeacherMenu();
				jframe.dispose();
			}
		});

		controlpanel.add(delete);
		controlpanel.add(reset);
		controlpanel.add(exit);

		jframe.add(idpanel);
		jframe.add(controlpanel);
		jframe.setLayout(new GridLayout(2, 1));

		// 宽度,高度
		Dimension d = new Dimension(300, 200); // 创建一个Dimension对象,用来设置窗口大小的
		Point p = new Point(100, 100); // 创建一个Point,用来设置窗口的初始位置
		jframe.setSize(d); // 设置窗体大小
		jframe.setLocation(p); // 初始位置
		jframe.setResizable(false); // 设置窗口大小不可变
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭方式
		jframe.setVisible(true); // 设置窗体可见
	}

	public static void main(String[] args) {
		DeleteStudent ds = new DeleteStudent();
	}

}
