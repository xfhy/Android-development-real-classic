package com.xfhy.management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 登录的那个界面
 * @author XFHY
 *
 */
public class Login {

	private JLabel userlab = new JLabel("用户名:",JLabel.CENTER);   //创建标签,中心
	private JTextField usertext = new JTextField(15);   //创建长度为25的文本框
	private JLabel passwdlab = new JLabel("密   码:",JLabel.CENTER);
	private JPasswordField passwdText = new JPasswordField(15);  //创建长度为25的密码框
	private JLabel loginlab = new JLabel("",JLabel.CENTER); //显示在界面最下面的登录状态
	private final DefaultComboBoxModel loginType = new DefaultComboBoxModel();  //下拉框的内容
	private JComboBox loginTypeChan =null;
	
	public Login()
	{
		final JFrame jframe = new JFrame("登录界面");
		JPanel userPanel = new JPanel();    //创建一个user的面板
		JPanel passwdPanel = new JPanel();  //创建一个密码的面板
		JPanel buttonPanel = new JPanel();  //创建一个按钮的面板
		JPanel labelPanel = new JPanel();   //创建一个登录状态的面板
		JButton submit = new JButton("登录");
		JButton reset = new JButton("重置");
		Font font = new Font("楷体",Font.BOLD,35);
		loginlab.setFont(font);
		loginlab.setForeground(Color.BLUE);
		labelPanel.add(loginlab);   //添加登录信息到面板
		
		loginType.addElement("Student");
		loginType.addElement("Teacher");
		loginTypeChan = new JComboBox(loginType);
		
		//注册登录按钮事件监听器
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//得到用户登录的类型
				String loginPeople = loginTypeChan.getItemAt(loginTypeChan.getSelectedIndex()).
						toString();
				String user = usertext.getText();  //用户id
				String passwd = new String(passwdText.getPassword());  //获得密码
				LoginCheck flag = new LoginCheck(loginPeople,user,passwd);
				flag.connDatabase();  //连接数据库
				if(flag.prepared())
				{
					loginlab.setForeground(Color.GREEN);
					loginlab.setText("登录成功!");
					if(loginPeople.equals("Student"))
					{
						//JOptionPane 类一个组件，它提供了标准的方法，弹出一个标准的对话框，或者通知用户的东西。
						JOptionPane.showMessageDialog(null,"学生登录成功！！！","☆★提示信息☆★",
								JOptionPane.INFORMATION_MESSAGE);
						//jframe.setVisible(false);
						jframe.dispose();   //销毁该登录界面
						new StudentInfo(user);
					}
					else if(loginPeople.equals("Teacher"))
					{
						JOptionPane.showMessageDialog(null,"老师登录成功！！！","☆★提示信息☆★",
								JOptionPane.INFORMATION_MESSAGE);
						jframe.dispose();   //销毁该登录界面
						new TeacherMenu();
					}
				}
				else
				{
					loginlab.setForeground(Color.RED);
					loginlab.setText("登录失败!");
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				usertext.setText("");
				passwdText.setText("");
				loginlab.setForeground(Color.BLUE);
				loginlab.setText("请重新登录!");
			}
		});
		
		jframe.setLayout(new GridLayout(4,1));
		
		//将各自的组件添加到面板里
		userPanel.add(userlab);
		userPanel.add(usertext);
		passwdPanel.add(passwdlab);
		passwdPanel.add(passwdText);
		buttonPanel.add(loginTypeChan);
		buttonPanel.add(submit);
		buttonPanel.add(reset);
		
		//将面板添加到容器中
		jframe.add(userPanel);
		jframe.add(passwdPanel);
		jframe.add(buttonPanel);
		jframe.add(labelPanel);
		
        //宽度,高度
		Dimension d = new Dimension(300,200);  //创建一个Dimension对象,用来设置窗口大小的
		Point p = new Point(100,100);          //创建一个Point,用来设置窗口的初始位置
		jframe.setSize(d);  //设置窗体大小
		jframe.setLocation(p);
		jframe.setResizable(false);   //设置窗口大小不可变
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //设置窗口关闭方式
		jframe.setVisible(true);  //设置窗体可见
	}
	
	public static void main(String[] args) {
		
		Login login = new Login();
	}

}
