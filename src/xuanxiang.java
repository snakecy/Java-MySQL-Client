import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@SuppressWarnings("serial")
public class xuanxiang extends JFrame implements ActionListener{
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";

	ResultSet rs = null;

	Connection conn = null;
	private JButton button;	
	private JLabel thx;
	Container container = getContentPane();
	
	
	public xuanxiang()  {
		super("选项设置"); // 调用父类构造函数
		
		getContentPane().setLayout(null);
		//getContentPane().setBackground(Color.ORANGE);		
		
		setBackground(new Color(0, 128, 0));
		setResizable(false);
		setLocation(300,10);                     
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 关闭窗口时退出程序
		setTitle("\u6DFB\u52A0\u5BA2\u6237");
		getContentPane().setLayout(null);
		
		thx = new JLabel("谢谢使用");		
		thx.setFont(new Font("宋体", Font.BOLD, 20));
		thx.setBounds(150, 20, 150, 120);		
		getContentPane().add(thx);
		
		button = new JButton("退出");
		button.addActionListener(this); 
		button.setFont(new Font("宋体", Font.BOLD, 14));
		button.setBounds(150, 100, 80, 20);
		getContentPane().add(button);		
		setVisible(true); // 设置窗口可视
				
		
		Calendar c = Calendar.getInstance();
	    SimpleDateFormat simpleDateTimeFormat =new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss" );
	    c = Calendar.getInstance(Locale.CHINESE);
	    System.out.println(simpleDateTimeFormat.format(c.getTime()));
		getRootPane().setDefaultButton(button);	
		
	}

	public static void main(String[] args) throws SQLException {
			new xuanxiang();
	}

	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		try{		
		
		if(e.getSource()== button){
			System.exit(0);
		}
		}
		catch(Exception ex){
			 System.err.print(ex.getMessage());
			 }
	}
}
