import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import java.sql.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.text.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class mainmenu extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	JButton button_4,button_5,button_3,button_2,button;	
	public String fangjianhao="";
	public int type;
	javax.swing.Timer mouseTimer = null;
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	ResultSet rs = null;
	Connection conn = null;
	
	String t101,t102,t103,t104,t105,t106,
	t201,t202,t203,t204,t205,t206,
	t301,t302,t303,t304,t305,t306,
	t401,t402,t403,t404,t405,t406,
	t501,t502,t503,t504,t505,t506,
	t601,t602,t603,t604,t605,t606;
	
	private int danjianshu=0,biaojianshu=0,guibinshu=0,zangfangshu=0,yudingshu=0;
	
	public mainmenu(int leixing) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainmenu.class.getResource("/res/\u5C0F\u5C4B.jpg")));
		setLocation(300,10);                     
		setSize(783, 580);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
		
		type=leixing;
		
		setTitle("\u4E3B\u83DC\u5355");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setBounds(0, 0, 777, 552);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u5F53\u524D\u65E5\u671F\uFF1A");
		label.setBounds(10, 6, 80, 18);
		label.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		panel.add(label);
		
		textField = new JTextField();
		textField.setBackground(new Color(51, 153, 255));
		textField.setEditable(false);
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setBounds(87, 4, 106, 21);
		textField.setColumns(10);
		Calendar c = Calendar.getInstance();
	    SimpleDateFormat simpleDateTimeFormat =new SimpleDateFormat( " yyyy-MM-dd " );
	    c = Calendar.getInstance(Locale.CHINESE);
	    System.out.println(simpleDateTimeFormat.format(c.getTime()));
	    textField.setText(simpleDateTimeFormat.format(c.getTime()));;
		panel.add(textField);
		System.out.println("执行地址");
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u623F\u95F4\u72B6\u51B5\uFF1A");
		label_1.setBounds(214, 6, 553, 18);
		label_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		panel.add(label_1);
		
		
		
		button = new JButton("\u6362\u623F");
		button.addActionListener(this);
		button.setForeground(Color.RED);
		button.setFont(new Font("宋体", Font.BOLD, 14));
		button.setBounds(149, 36, 93, 25);
	   //	panel.add(button);
		
		button_2 = new JButton("\u9009\u9879");
		if(leixing==1)
		button_2.setEnabled(false);
		button_2.addActionListener(this);
		button_2.setFont(new Font("宋体", Font.BOLD, 14));
		button_2.setForeground(Color.RED);
		button_2.setBounds(670, 35, 93, 26);
		panel.add(button_2);
		
		button_3 = new JButton("\u62A5\u8868");
		button_3.addActionListener(this);
		button_3.setFont(new Font("宋体", Font.BOLD, 14));
		button_3.setForeground(Color.RED);
		button_3.setBounds(384, 36, 93, 25);
		//button_3.addActionListener(this);
		panel.add(button_3);   //添加报表按钮
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(204, 204, 0));
		panel_1.setForeground(Color.MAGENTA);
		panel_1.setBounds(0, 67, 641, 485);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ResultSet rs = this.executeQuery(" select Room_state from room ");
		
		
		JLabel label_7 = new JLabel("101");
		
		rs.next();
		System.out.println("rs");
		t101 = rs.getString("Room_state");
		t101=t101.trim();
		System.out.println(t101);
		//if(t101.equals("空")) 0=空
		if(t101.equals("0"))
		{
		label_7.setIcon(new ImageIcon(mainmenu.class.getResource("/res/单人间.png")));
		}
		
		else if(t101.equals("1")) //1=入住
		{
			danjianshu++;
		label_7.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t101.equals("2"))  //2=预订
		{
			yudingshu++;
			label_7.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
			}
		else if(t101.equals("3"))   //3=脏房
		{zangfangshu++;
			label_7.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
			}
			
		
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("宋体", Font.BOLD, 14));
		label_7.setBounds(10, 10, 84, 60);
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="101";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t101.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t101.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t101.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t101.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="101";
			    	if(t101.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t101.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t101.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t101.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_7);
		
		System.out.println("是否102");
		final JLabel label_8 = new JLabel("102");
		//label_8.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5165\u4F4F.png")));
		rs.next();
		t102 = rs.getString("Room_state");
		t102=t102.trim();
		if(t102.equals("0"))
		{
		label_8.setIcon(new ImageIcon(mainmenu.class.getResource("/res/单人间.png")));

		}
		
		else if(t102.equals("1"))
		{danjianshu++;
		label_8.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));

		}
		else if(t102.equals("2"))
		{yudingshu++;
		label_8.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));

		}
		else if(t102.equals("3"))
		{zangfangshu++;
		label_8.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));

		}
		
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("宋体", Font.BOLD, 14));
		label_8.setBounds(105, 10, 84, 60);
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="102";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t102.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t102.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t102.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t102.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="102";
			    	if(t102.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t102.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t102.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t102.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("103");
		//label_9.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5355\u4EBA\u95F4.png")));
		rs.next();
		t103 = rs.getString("Room_state");
		t103=t103.trim();
		System.out.println(t103);
		if(t103.equals("0"))
		{
		label_9.setIcon(new ImageIcon(mainmenu.class.getResource("/res/单人间.png")));
		}
		
		else if(t103.equals("1"))
		{danjianshu++;
		label_9.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t103.equals("2"))
		{yudingshu++;
		label_9.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t103.equals("3"))
		{zangfangshu++;
		label_9.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("宋体", Font.BOLD, 14));
		label_9.setBounds(208, 10, 84, 60);
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="103";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t103.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t103.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t103.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t103.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="103";
			    	if(t103.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t103.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t103.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t103.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("104");
		//label_10.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5355\u4EBA\u95F4.png")));
		rs.next();
		t104 = rs.getString("Room_state");
		t104=t104.trim();
		System.out.println(t104);
		if(t104.equals("0"))
		{
		label_10.setIcon(new ImageIcon(mainmenu.class.getResource("/res/单人间.png")));
		}
		
		else if(t104.equals("1"))
		{danjianshu++;
		label_10.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t104.equals("2"))
		{yudingshu++;
		label_10.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t104.equals("3"))
		{zangfangshu++;
		label_10.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		
		label_10.setForeground(Color.BLUE);
		label_10.setFont(new Font("宋体", Font.BOLD, 14));
		label_10.setBounds(314, 10, 84, 60);
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="104";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t104.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t104.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t104.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t104.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="104";
			    	if(t104.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t104.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t104.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t104.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("105");
		//label_11.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5355\u4EBA\u95F4.png")));
		rs.next();
		t105 = rs.getString("Room_state");
		t105=t105.trim();
		System.out.println(t105);
		if(t105.equals("0"))
		{
		label_11.setIcon(new ImageIcon(mainmenu.class.getResource("/res/单人间.png")));
		}
		
		else if(t105.equals("1"))
		{danjianshu++;
		label_11.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t105.equals("2"))
		{yudingshu++;
		label_11.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t105.equals("3"))
		{zangfangshu++;
		label_11.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_11.setForeground(Color.BLUE);
		label_11.setFont(new Font("宋体", Font.BOLD, 14));
		label_11.setBounds(419, 10, 84, 60);
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="105";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t105.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t105.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t105.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t105.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="105";
			    	if(t105.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t105.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t105.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t105.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("106");
		//label_12.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5355\u4EBA\u95F4.png")));
		rs.next();
		t106 = rs.getString("Room_state");
		t106=t106.trim();
		System.out.println(t106);
		if(t106.equals("0"))
		{
		label_12.setIcon(new ImageIcon(mainmenu.class.getResource("/res/单人间.png")));
		}
		
		else if(t106.equals("1"))
		{danjianshu++;
		label_12.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t106.equals("2"))
		{yudingshu++;
		label_12.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t106.equals("3"))
		{zangfangshu++;
		label_12.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_12.setForeground(Color.BLUE);
		label_12.setFont(new Font("宋体", Font.BOLD, 14));
		label_12.setBounds(526, 10, 84, 60);
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="106";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t106.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t106.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t106.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t106.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="106";
			    	if(t106.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t106.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t106.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t106.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("201");
		//label_13.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t201 = rs.getString("Room_state");
		t201=t201.trim();
		System.out.println(t201);
		if(t201.equals("0"))
		{
			label_13.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t201.equals("1"))
		{biaojianshu++;
			label_13.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t201.equals("2"))
		{yudingshu++;
			label_13.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t201.equals("3"))
		{zangfangshu++;
			label_13.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_13.setForeground(Color.BLUE);
		label_13.setFont(new Font("宋体", Font.BOLD, 14));
		label_13.setBounds(10, 90, 84, 60);
		label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="201";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t201.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t201.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t201.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t201.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="201";
			    	if(t201.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t201.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t201.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t201.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("202");
		//label_14.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t202 = rs.getString("Room_state");
		t202=t202.trim();
		if(t202.equals("0"))
		{
			label_14.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t202.equals("1"))
		{biaojianshu++;
			label_14.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t202.equals("2"))
		{yudingshu++;
			label_14.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t202.equals("3"))
		{zangfangshu++;
			label_14.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_14.setForeground(Color.BLUE);
		label_14.setFont(new Font("宋体", Font.BOLD, 14));
		label_14.setBounds(105, 90, 84, 60);
		label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="202";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t202.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t202.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t202.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t202.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="202";
			    	if(t202.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t202.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t202.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t202.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("203");
		//label_15.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t203 = rs.getString("Room_state");
		t203=t203.trim();
		if(t203.equals("0"))
		{
			label_15.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t203.equals("1"))
		{biaojianshu++;
			label_15.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t203.equals("2"))
		{yudingshu++;
			label_15.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t203.equals("3"))
		{zangfangshu++;
			label_15.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_15.setForeground(Color.BLUE);
		label_15.setFont(new Font("宋体", Font.BOLD, 14));
		label_15.setBounds(208, 90, 84, 60);
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="203";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t203.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t203.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t203.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t203.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="203";
			    	if(t203.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t203.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t203.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t203.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("204");
		//label_16.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u810F\u623F.png")));
		rs.next();
		t204 = rs.getString("Room_state");
		t204=t204.trim();
		if(t204.equals("0"))
		{
			label_16.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t204.equals("1"))
		{biaojianshu++;
			label_16.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t204.equals("2"))
		{yudingshu++;
			label_16.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t204.equals("3"))
		{zangfangshu++;
			label_16.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_16.setForeground(Color.BLUE);
		label_16.setFont(new Font("宋体", Font.BOLD, 14));
		label_16.setBounds(314, 90, 84, 60);
		label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="204";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t204.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t204.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t204.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t204.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="204";
			    	if(t204.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t204.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t204.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t204.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("205");
		//label_17.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t205 = rs.getString("Room_state");
		t205=t205.trim();
		if(t205.equals("0"))
		{
			label_17.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t205.equals("1"))
		{biaojianshu++;
			label_17.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t205.equals("2"))
		{yudingshu++;
			label_17.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t205.equals("3"))
		{zangfangshu++;
			label_17.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_17.setForeground(Color.BLUE);
		label_17.setFont(new Font("宋体", Font.BOLD, 14));
		label_17.setBounds(419, 90, 84, 60);
		label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="205";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t205.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t205.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t205.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t205.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="205";
			    	if(t205.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t205.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t205.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t205.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("206");
		//label_18.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t206 = rs.getString("Room_state");
		t206=t206.trim();
		if(t206.equals("0"))
		{
			label_18.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t206.equals("1"))
		{biaojianshu++;
			label_18.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t206.equals("2"))
		{yudingshu++;
			label_18.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t206.equals("3"))
		{zangfangshu++;
			label_18.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_18.setForeground(Color.BLUE);
		label_18.setFont(new Font("宋体", Font.BOLD, 14));
		label_18.setBounds(526, 90, 84, 60);
		label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="206";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t206.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t206.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t206.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t206.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="206";
			    	if(t206.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t206.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t206.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t206.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("301");
		//label_19.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t301 = rs.getString("Room_state");
		t301=t301.trim();
		if(t301.equals("0"))
		{
			label_19.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t301.equals("1"))
		{biaojianshu++;
			label_19.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t301.equals("2"))
		{yudingshu++;
			label_19.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t301.equals("3"))
		{zangfangshu++;
			label_19.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_19.setForeground(Color.BLUE);
		label_19.setFont(new Font("宋体", Font.BOLD, 14));
		label_19.setBounds(10, 173, 84, 60);
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="301";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t301.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t301.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t301.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t301.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="301";
			    	if(t301.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t301.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t301.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t301.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("302");
		//label_20.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t302 = rs.getString("Room_state").trim();
		if(t302.equals("0"))
		{
			label_20.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t302.equals("1"))
		{biaojianshu++;
			label_20.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t302.equals("2"))
		{yudingshu++;
			label_20.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t302.equals("3"))
		{zangfangshu++;
			label_20.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_20.setForeground(Color.BLUE);
		label_20.setFont(new Font("宋体", Font.BOLD, 14));
		label_20.setBounds(105, 173, 84, 60);
		label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="302";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t302.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t302.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t302.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t302.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="302";
			    	if(t302.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t302.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t302.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t302.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_20);
		
		JLabel label_21 = new JLabel("303");
		//label_21.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5165\u4F4F.png")));
		rs.next();
		t303 = rs.getString("Room_state").trim();
		if(t303.equals("0"))
		{
			label_21.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t303.equals("1"))
		{biaojianshu++;
			label_21.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t303.equals("2"))
		{yudingshu++;
			label_21.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t303.equals("3"))
		{zangfangshu++;
			label_21.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_21.setForeground(Color.BLUE);
		label_21.setFont(new Font("宋体", Font.BOLD, 14));
		label_21.setBounds(208, 173, 84, 60);
		label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="303";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t303.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t303.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t303.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t303.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="303";
			    	if(t303.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t303.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t303.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t303.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_21);
		
		JLabel label_22 = new JLabel("304");
		//label_22.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t304 = rs.getString("Room_state").trim();
		if(t304.equals("0"))
		{
			label_22.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t304.equals("1"))
		{biaojianshu++;
			label_22.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t304.equals("2"))
		{yudingshu++;
			label_22.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t304.equals("3"))
		{zangfangshu++;
			label_22.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_22.setForeground(Color.BLUE);
		label_22.setFont(new Font("宋体", Font.BOLD, 14));
		label_22.setBounds(314, 173, 84, 60);
		label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="304";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t304.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t304.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t304.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t304.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="304";
			    	if(t304.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t304.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t304.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t304.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_22);
		
		JLabel label_23 = new JLabel("305");
		//label_23.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t305 = rs.getString("Room_state").trim();
		if(t305.equals("0"))
		{
			label_23.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t305.equals("1"))
		{biaojianshu++;
			label_23.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t305.equals("2"))
		{yudingshu++;
			label_23.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t305.equals("3"))
		{zangfangshu++;
			label_23.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_23.setForeground(Color.BLUE);
		label_23.setFont(new Font("宋体", Font.BOLD, 14));
		label_23.setBounds(419, 173, 84, 60);
		label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="305";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t305.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t305.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t305.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t305.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="305";
			    	if(t305.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t305.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t305.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t305.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_23);
		
		JLabel label_24 = new JLabel("306");
		//label_24.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t306 = rs.getString("Room_state").trim();
		if(t306.equals("0"))
		{
			label_24.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t306.equals("1"))
		{biaojianshu++;
			label_24.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t306.equals("2"))
		{yudingshu++;
			label_24.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t306.equals("3"))
		{zangfangshu++;
			label_24.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_24.setForeground(Color.BLUE);
		label_24.setFont(new Font("宋体", Font.BOLD, 14));
		label_24.setBounds(526, 173, 84, 60);
		label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="306";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t306.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t306.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t306.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t306.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="306";
			    	if(t306.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t306.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t306.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t306.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_24);
		
		JLabel label_25 = new JLabel("401");
		//label_25.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5165\u4F4F.png")));
		rs.next();
		t401 = rs.getString("Room_state").trim();
		if(t401.equals("0"))
		{
			label_25.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t401.equals("1"))
		{biaojianshu++;
			label_25.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t401.equals("2"))
		{yudingshu++;
			label_25.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t401.equals("3"))
		{zangfangshu++;
			label_25.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_25.setForeground(Color.BLUE);
		label_25.setFont(new Font("宋体", Font.BOLD, 14));
		label_25.setBounds(10, 251, 84, 60);
		label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="401";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t401.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t401.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t401.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t401.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="401";
			    	if(t401.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t401.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t401.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t401.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_25);
		
		JLabel label_26 = new JLabel("402");
		//label_26.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t402 = rs.getString("Room_state").trim();
		if(t402.equals("0"))
		{
			label_26.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t402.equals("1"))
		{biaojianshu++;
			label_26.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t402.equals("2"))
		{yudingshu++;
			label_26.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t402.equals("3"))
		{zangfangshu++;
			label_26.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_26.setForeground(Color.BLUE);
		label_26.setFont(new Font("宋体", Font.BOLD, 14));
		label_26.setBounds(105, 251, 84, 60);
		label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="402";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t402.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t402.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t402.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t402.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="402";
			    	if(t402.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t402.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t402.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t402.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_26);
		
		JLabel label_27 = new JLabel("403");
		//label_27.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t403 = rs.getString("Room_state").trim();
		if(t403.equals("0"))
		{
			label_27.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t403.equals("1"))
		{biaojianshu++;
			label_27.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t403.equals("2"))
		{yudingshu++;
			label_27.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t403.equals("3"))
		{zangfangshu++;
			label_27.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_27.setForeground(Color.BLUE);
		label_27.setFont(new Font("宋体", Font.BOLD, 14));
		label_27.setBounds(208, 251, 84, 60);
		label_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="403";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t403.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t403.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t403.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t403.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="403";
			    	if(t403.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t403.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t403.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t403.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_27);
		
		JLabel label_28 = new JLabel("404");
		//label_28.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t404 = rs.getString("Room_state").trim();
		if(t404.equals("0"))
		{
			label_28.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t404.equals("1"))
		{biaojianshu++;
			label_28.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t404.equals("2"))
		{yudingshu++;
			label_28.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t404.equals("3"))
		{zangfangshu++;
			label_28.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_28.setForeground(Color.BLUE);
		label_28.setFont(new Font("宋体", Font.BOLD, 14));
		label_28.setBounds(314, 251, 84, 60);
		label_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="404";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t404.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t404.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t404.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t404.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="404";
			    	if(t404.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t404.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t404.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t404.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_28);
		
		JLabel label_29 = new JLabel("405");
		//label_29.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t405 = rs.getString("Room_state").trim();
		if(t405.equals("0"))
		{
			label_29.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t405.equals("1"))
		{biaojianshu++;
			label_29.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t405.equals("2"))
		{yudingshu++;
			label_29.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t405.equals("3"))
		{zangfangshu++;
			label_29.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_29.setForeground(Color.BLUE);
		label_29.setFont(new Font("宋体", Font.BOLD, 14));
		label_29.setBounds(419, 251, 84, 60);
		label_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="405";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t405.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t405.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t405.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t405.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="405";
			    	if(t405.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t405.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t405.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t405.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_29);
		
		JLabel label_30 = new JLabel("406");
		//label_30.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t406 = rs.getString("Room_state").trim();
		if(t406.equals("0"))
		{
			label_30.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t406.equals("1"))
		{biaojianshu++;
			label_30.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t406.equals("2"))
		{yudingshu++;
			label_30.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t406.equals("3"))
		{zangfangshu++;
			label_30.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_30.setForeground(Color.BLUE);
		label_30.setFont(new Font("宋体", Font.BOLD, 14));
		label_30.setBounds(526, 251, 84, 60);
		label_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="406";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t406.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t406.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t406.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t406.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="406";
			    	if(t406.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t406.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t406.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t406.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_30);
		
		JLabel label_31 = new JLabel("501");
		//label_31.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t501 = rs.getString("Room_state").trim();
		if(t501.equals("0"))
		{
			label_31.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t501.equals("1"))
		{biaojianshu++;
			label_31.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t501.equals("2"))
		{yudingshu++;
			label_31.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t501.equals("3"))
		{zangfangshu++;
			label_31.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_31.setForeground(Color.BLUE);
		label_31.setFont(new Font("宋体", Font.BOLD, 14));
		label_31.setBounds(10, 330, 84, 60);
		label_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="501";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t501.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t501.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t501.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t501.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="501";
			    	if(t501.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t501.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t501.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t501.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_31);
		
		JLabel label_32 = new JLabel("502");
		//label_32.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t502 = rs.getString("Room_state").trim();
		if(t502.equals("0"))
		{
			label_32.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t502.equals("1"))
		{biaojianshu++;
			label_32.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t502.equals("2"))
		{yudingshu++;
			label_32.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t502.equals("3"))
		{zangfangshu++;
			label_32.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_32.setForeground(Color.BLUE);
		label_32.setFont(new Font("宋体", Font.BOLD, 14));
		label_32.setBounds(105, 330, 84, 60);
		label_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="502";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t502.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t502.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t502.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t502.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="502";
			    	if(t502.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t502.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t502.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t502.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_32);
		
		JLabel label_33 = new JLabel("503");
		//label_33.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u810F\u623F.png")));
		rs.next();
		t503 = rs.getString("Room_state").trim();
		if(t503.equals("0"))
		{
			label_33.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t503.equals("1"))
		{biaojianshu++;
			label_33.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t503.equals("2"))
		{yudingshu++;
			label_33.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t503.equals("3"))
		{zangfangshu++;
			label_33.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_33.setForeground(Color.BLUE);
		label_33.setFont(new Font("宋体", Font.BOLD, 14));
		label_33.setBounds(208, 330, 84, 60);
		label_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="503";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t503.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t503.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t503.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t503.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="503";
			    	if(t503.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t503.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t503.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t503.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_33);
		
		JLabel label_34 = new JLabel("504");
		//label_34.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t504 = rs.getString("Room_state").trim();
		if(t504.equals("0"))
		{
			label_34.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t504.equals("1"))
		{biaojianshu++;
			label_34.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t504.equals("2"))
		{yudingshu++;
			label_34.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t504.equals("3"))
		{zangfangshu++;
			label_34.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_34.setForeground(Color.BLUE);
		label_34.setFont(new Font("宋体", Font.BOLD, 14));
		label_34.setBounds(314, 330, 84, 60);
		label_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="504";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t504.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t504.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t504.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t504.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="504";
			    	if(t504.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t504.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t504.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t504.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_34);
		
		JLabel label_35 = new JLabel("505");
		//label_35.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t505 = rs.getString("Room_state").trim();
		if(t505.equals("0"))
		{
			label_35.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t505.equals("1"))
		{biaojianshu++;
			label_35.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t505.equals("2"))
		{yudingshu++;
			label_35.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t505.equals("3"))
		{zangfangshu++;
			label_35.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_35.setForeground(Color.BLUE);
		label_35.setFont(new Font("宋体", Font.BOLD, 14));
		label_35.setBounds(419, 330, 84, 60);
		label_35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="505";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t505.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t505.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订此房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t505.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t505.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="505";
			    	if(t505.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t505.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t505.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t505.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_35);
		
		JLabel label_36 = new JLabel("506");
		//label_36.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		rs.next();
		t506 = rs.getString("Room_state").trim();
		if(t506.equals("0"))
		{
			label_36.setIcon(new ImageIcon(mainmenu.class.getResource("/res/标准间.png")));
		}
		
		else if(t506.equals("1"))
		{biaojianshu++;
			label_36.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t506.equals("2"))
		{yudingshu++;
			label_36.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t506.equals("3"))
		{zangfangshu++;
			label_36.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_36.setForeground(Color.BLUE);
		label_36.setFont(new Font("宋体", Font.BOLD, 14));
		label_36.setBounds(529, 330, 84, 60);
		label_36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="506";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t506.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t506.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订此房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t506.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t506.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="506";
			    	if(t506.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t506.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t506.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t506.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_36);
		
		
		
	//====================================
		
		
		JLabel label_37 = new JLabel("601");
		//label_37.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5165\u4F4F.png")));
		rs.next();
		t601 = rs.getString("Room_state").trim();
		if(t601.equals("0"))
		{
			label_37.setIcon(new ImageIcon(mainmenu.class.getResource("/res/贵宾房.png")));
		}
		
		else if(t601.equals("1"))
		{guibinshu++;
			label_37.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t601.equals("2"))
		{yudingshu++;
			label_37.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t601.equals("3"))
		{zangfangshu++;
			label_37.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_37.setForeground(Color.BLUE);
		label_37.setFont(new Font("宋体", Font.BOLD, 14));
		label_37.setBounds(10, 415, 84, 60);
		label_37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="601";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t601.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t601.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订此房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t601.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t601.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="601";
			    	if(t601.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t601.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t601.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t601.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_37);
		
	//==================================================================================================	
		
		
		JLabel label_38 = new JLabel("602");
		//label_38.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u8D35\u5BBE\u623F.png")));
		rs.next();
		t602 = rs.getString("Room_state").trim();
		if(t602.equals("0"))
		{
			label_38.setIcon(new ImageIcon(mainmenu.class.getResource("/res/贵宾房.png")));
		}
		
		else if(t602.equals("1"))
		{guibinshu++;
			label_38.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t602.equals("2"))
		{yudingshu++;
			label_38.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t602.equals("3"))
		{zangfangshu++;
			label_38.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_38.setForeground(Color.BLUE);
		label_38.setFont(new Font("宋体", Font.BOLD, 14));
		label_38.setBounds(105, 415, 84, 60);
		label_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="602";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t602.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t602.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订此房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t602.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t602.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="602";
			    	if(t602.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t602.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t602.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t602.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_38);
		
		JLabel label_39 = new JLabel("603");
		//label_39.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u8D35\u5BBE\u623F.png")));
		rs.next();
		t603 = rs.getString("Room_state").trim();
		if(t603.equals("0"))
		{
			label_39.setIcon(new ImageIcon(mainmenu.class.getResource("/res/贵宾房.png")));
		}
		
		else if(t603.equals("1"))
		{guibinshu++;
			label_39.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t603.equals("2"))
		{yudingshu++;
			label_39.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t603.equals("3"))
		{zangfangshu++;
			label_39.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_39.setForeground(Color.BLUE);
		label_39.setFont(new Font("宋体", Font.BOLD, 14));
		label_39.setBounds(208, 415, 84, 60);
		label_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="603";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t603.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t603.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订此房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t603.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t603.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="603";
			    	if(t603.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t603.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t603.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t603.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_39);
		
		JLabel label_40 = new JLabel("604");
		//label_40.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u8D35\u5BBE\u623F.png")));
		rs.next();
		t604 = rs.getString("Room_state").trim();
		if(t604.equals("0"))
		{
			label_40.setIcon(new ImageIcon(mainmenu.class.getResource("/res/贵宾房.png")));
		}
		
		else if(t604.equals("1"))
		{guibinshu++;
			label_40.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t604.equals("2"))
		{yudingshu++;
			label_40.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t604.equals("3"))
		{zangfangshu++;
			label_40.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_40.setForeground(Color.BLUE);
		label_40.setFont(new Font("宋体", Font.BOLD, 14));
		label_40.setBounds(314, 415, 84, 60);
		label_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="604";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t604.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t604.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订此房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t604.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t604.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="604";
			    	if(t604.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t604.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t604.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t604.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_40);
		
		JLabel label_41 = new JLabel("605");
		//label_41.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u8D35\u5BBE\u623F.png")));
		rs.next();
		t605 = rs.getString("Room_state").trim();
		if(t605.equals("0"))
		{
			label_41.setIcon(new ImageIcon(mainmenu.class.getResource("/res/贵宾房.png")));
		}
		
		else if(t605.equals("1"))
		{guibinshu++;
			label_41.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t605.equals("2"))
		{yudingshu++;
			label_41.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t605.equals("3"))
		{zangfangshu++;
			label_41.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_41.setForeground(Color.BLUE);
		label_41.setFont(new Font("宋体", Font.BOLD, 14));
		label_41.setBounds(419, 415, 84, 60);
		label_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="605";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t605.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t605.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t605.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t605.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="605";
			    	if(t605.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t605.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t605.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t605.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_41);
		
		JLabel label_42 = new JLabel("606");
		//label_42.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u8D35\u5BBE\u623F.png")));
		rs.next();
		t606 = rs.getString("Room_state").trim();
		if(t606.equals("0"))
		{
			label_42.setIcon(new ImageIcon(mainmenu.class.getResource("/res/贵宾房.png")));
		}
		
		else if(t606.equals("1"))
		{guibinshu++;
			label_42.setIcon(new ImageIcon(mainmenu.class.getResource("/res/入住.png")));
		}
		else if(t606.equals("2"))
		{yudingshu++;
			label_42.setIcon(new ImageIcon(mainmenu.class.getResource("/res/预订.png")));
		}
		else if(t606.equals("3"))
		{zangfangshu++;
			label_42.setIcon(new ImageIcon(mainmenu.class.getResource("/res/脏房.png")));
		}
		label_42.setForeground(Color.BLUE);
		label_42.setFont(new Font("宋体", Font.BOLD, 14));
		label_42.setBounds(529, 415, 84, 60);
		label_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
				if(clickTimes == 1)
			    {	fangjianhao="606";
			    	mouseTimer = new javax.swing.Timer(350, new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {
					   System.out.println("Single");
					if(t606.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t606.equals("2")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要退订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new tuidingfangjian(fangjianhao);
			    		
			    	}
			    	if(t606.equals("1")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+fangjianhao+fangjianhao+fangjianhao+fangjianhao+"已入住，不可预订！");
			    		
			    	}
			    	if(t606.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要预订"+fangjianhao+"房间吗?");
			    		if(n==0)
			    			new yudingkehu(fangjianhao);
			    		
			    	}
					   mouseTimer.stop();
					   }
					   });
					   mouseTimer.restart();    	
			    }
			     
			    else  if (clickTimes == 2&& mouseTimer.isRunning()) 
			    {
			    	 mouseTimer.stop(); 
			    	fangjianhao="606";
			    	if(t606.equals("3")) JOptionPane.showMessageDialog(null, fangjianhao+"房间现在不可用！");
			    	if(t606.equals("2")) 
			    	{
			    		JOptionPane.showMessageDialog(null, fangjianhao+"房间已预订！");
			    		
			    	}
			    	if(t606.equals("1")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, fangjianhao+"确定要退房间吗?");
			    		if(n==0)
							try {
								new tuifang(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			    	if(t606.equals("0")) 
			    	{
			    		int n=JOptionPane.showConfirmDialog(null, "确定要入住"+fangjianhao+"房间吗?");
			    		if(n==0)
							try {
								new tianjiakehu(fangjianhao);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
			    		
			    	}
			      
			    }      
			}
		});
		panel_1.add(label_42);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(102, 204, 51));
		panel_2.setBounds(657, 67, 120, 483);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(51, 153, 255));
		textField_1.setBounds(336, 6, 431, 21);
		textField_1.setColumns(10);
		textField_1.setText(" 单人间:"+danjianshu+"   标准间:"+biaojianshu+
				"   贵宾房："+guibinshu+"   预订："+yudingshu+"   待整理："+zangfangshu);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("\u72B6\u6001\u6807\u793A\uFF1A");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(10, 0, 76, 34);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u5355\u4EBA\u95F4");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickTimes = e.getClickCount();
			    if (clickTimes == 2) {
			      System.out.println("Doublc Clicked!");
			    }
			}
		});
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		label_3.setForeground(Color.BLUE);
		label_3.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5355\u4EBA\u95F4.png")));
		label_3.setBounds(0, 31, 120, 62);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u6807\u51C6\u95F4");
		label_4.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u6807\u51C6\u95F4.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 14));
		label_4.setBounds(0, 103, 120, 62);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("\u5DF2\u5165\u4F4F");
		label_5.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u5165\u4F4F.png")));
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 14));
		label_5.setBounds(0, 247, 120, 62);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("\u8D35\u5BBE\u623F");
		label_6.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u8D35\u5BBE\u623F.png")));
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 14));
		label_6.setBounds(0, 175, 120, 62);
		panel_2.add(label_6);
		
		JLabel label_43 = new JLabel("\u5F85\u6574\u7406");
		label_43.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u810F\u623F.png")));
		label_43.setForeground(Color.BLUE);
		label_43.setFont(new Font("宋体", Font.BOLD, 14));
		label_43.setBounds(0, 395, 120, 62);
		panel_2.add(label_43);
		
		JLabel label_44 = new JLabel("\u9884\u8BA2");
		label_44.setIcon(new ImageIcon(mainmenu.class.getResource("/res/\u9884\u8BA2.png")));
		label_44.setForeground(Color.BLUE);
		label_44.setFont(new Font("宋体", Font.BOLD, 14));
		label_44.setBounds(0, 319, 120, 62);
		panel_2.add(label_44);
		
		button_4 = new JButton("\u67E5\u8BE2\u623F\u5BA2");
		button_4.addActionListener(this);
			
		button_4.setForeground(Color.RED);
		button_4.setFont(new Font("宋体", Font.BOLD, 14));
		button_4.setBounds(518, 37, 112, 25);
		panel.add(button_4);
		
		button_5 = new JButton("刷新");
		button_5.addActionListener(this); 
		button_5.setForeground(Color.RED);
		button_5.setFont(new Font("宋体", Font.BOLD, 14));
		button_5.setBounds(10, 36, 80, 25);
		panel.add(button_5);
		getRootPane().setDefaultButton(button_5);

		setVisible(true);


		
	}
	
	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			conn = DriverManager.getConnection(url,user,pwd);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.print(ex.getMessage());
		}
		return rs;
	}
	
	
	public void actionPerformed(ActionEvent f) {
		
		if(f.getSource()==button_5)//刷新
		{
			try {
				this.dispose();
				new mainmenu(type);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(f.getSource()==button_4)//查询房客
		{
			new chaxunfangke();		
		}
		if(f.getSource()==button)//换房
		{
			try {
				
				new huanfang();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		
		if(f.getSource()==button_3)//报表
		{int zongshu=danjianshu+biaojianshu+guibinshu;
			new DSA(zongshu,danjianshu,biaojianshu,guibinshu,yudingshu,zangfangshu);		
		}
		
		if(f.getSource()==button_2)//选项
		{
				new xuanxiang();			
		}		
		
	}
	public static void main(String[] args) throws SQLException {
		int leixing=2;
new mainmenu(leixing);
	}
}