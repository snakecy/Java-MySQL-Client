import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Choice;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.awt.SystemColor;
public class huanfang extends JFrame implements ActionListener{

	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	ResultSet rs = null;
	PreparedStatement pstmt;
	Connection conn = null;
	private JTextField textField;
	private JTextField textField_1;
	JButton button,button_1;
	private JLabel label_5;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_6;
	private JLabel label_9;
	private JTextField textField_7;
	private JLabel label_10;
	private JTextField textField_8;
	private JButton button_2;
	private JLabel label_3;
	private JTextField textField_2;
	public huanfang() throws SQLException {
		getContentPane().setBackground(Color.ORANGE);
		setBackground(new Color(0, 128, 0));
		setResizable(false);
		setLocation(300,10);                     
		setSize(474, 484);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 关闭窗口时退出程序
		setTitle("\u6362\u623F");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(10, 102, 54, 26);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setBounds(92, 104, 98, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(265, 102, 54, 26);
		getContentPane().add(label_1);
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7*\uFF1A");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(10, 151, 87, 26);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setBounds(92, 154, 155, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		button = new JButton("\u6362\u623F");
		button.addActionListener(this); 
		button.setFont(new Font("宋体", Font.BOLD, 14));
		button.setBounds(58, 406, 130, 34);
		getContentPane().add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.BOLD, 14));
		button_1.setBounds(294, 406, 130, 34);
		button_1.addActionListener(this);
		getContentPane().add(button_1);
		
		label_5 = new JLabel("\u539F\u623F\u95F4\u53F7\uFF1A");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 14));
		label_5.setBounds(10, 10, 85, 26);
		getContentPane().add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(105, 12, 67, 21);
		getContentPane().add(textField_3);
		
		JLabel label_7 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("宋体", Font.BOLD, 14));
		label_7.setBounds(10, 206, 66, 26);
		getContentPane().add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(92, 208, 108, 21);
		getContentPane().add(textField_5);
		
		JLabel label_6 = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 14));
		label_6.setBounds(10, 255, 75, 26);
		getContentPane().add(label_6);
		
		
		Calendar c = Calendar.getInstance();
	    SimpleDateFormat simpleDateTimeFormat =new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss" );
	    c = Calendar.getInstance(Locale.CHINESE);
	    System.out.println(simpleDateTimeFormat.format(c.getTime()));
	    
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(80, 257, 199, 21);
		textField_4.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_4);
		
		JLabel label_8 = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("宋体", Font.BOLD, 14));
		label_8.setBounds(10, 295, 75, 26);
		getContentPane().add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(80, 297, 199, 21);
		textField_6.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_6);
		
		label_9 = new JLabel("\u6B20\u6B3E\uFF1A");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("宋体", Font.BOLD, 14));
		label_9.setBounds(10, 370, 75, 26);
		getContentPane().add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(90, 376, 108, 21);
		getContentPane().add(textField_7);
		getRootPane().setDefaultButton(button);
		
		label_10 = new JLabel("\u623F\u95F4\u4EF7\u683C\uFF1A");
		label_10.setForeground(Color.BLUE);
		label_10.setFont(new Font("宋体", Font.BOLD, 14));
		label_10.setBounds(10, 334, 75, 26);
		getContentPane().add(label_10);
		
//		rs = this.executeQuery("select Room_price from room where Room_num="+"'"+"'");
//			rs.next();
//		String jiage;	
//		jiage=rs.getString("Room_price");
		textField_8 = new JTextField();
		textField_8.setColumns(10);
//		textField_8.setText(jiage);
		textField_8.setBounds(92, 337, 108, 21);
		getContentPane().add(textField_8);
		
		button_2 = new JButton("\u83B7\u53D6\u539F\u6765\u5165\u4F4F\u4FE1\u606F");
		button_2.setFont(new Font("宋体", Font.BOLD, 14));
		button_2.setBounds(207, 6, 217, 34);
		getContentPane().add(button_2);
		
		label_3 = new JLabel("\u65B0\u623F\u95F4\u53F7\uFF1A");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		label_3.setBounds(10, 61, 85, 26);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(105, 64, 67, 21);
		getContentPane().add(textField_2);
		setVisible(true);
	}

	public static void main(String[] args) throws SQLException {


new huanfang();
	}

	
	public ResultSet executeQuery(String sql){
		rs=null;
		try{
		conn=DriverManager.getConnection(url,user,pwd);
		Statement stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		}
	 catch(SQLException ex){
	 System.err.print(ex.getMessage());
	 }
	 return rs;
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		if(e.getSource()==button){
			if(textField.getText().equals("")||textField_1.getText().equals("")
					||textField_2.getText().equals("")||textField_5.getText().equals("")
					||textField_6.getText().equals("")||textField_7.getText().equals(""))
				  JOptionPane.showMessageDialog(null,"请输入完整！");
			
			String xingming,shenfenzhenghao,lianxidianhua,huiyuandengji,
			yuangonghao,kaishishijian,jieshushijian;
			String fangjian;
			String xingbie=null;
			
			
			int fufei;
			yuangonghao=textField_5.getText();
			xingming=textField.getText();
			shenfenzhenghao=textField_1.getText();
			lianxidianhua=textField_2.getText();
			kaishishijian=textField_4.getText();
			jieshushijian=textField_6.getText();
			fufei=Integer.parseInt(textField_7.getText());
			fangjian=textField_3.getText();
			huiyuandengji=textField_8.getText();
			
	
			
			String msql = "insert into consumer values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(msql) ;
			System.out.println();
		
			pstmt.setString(1,xingming) ; // 这里设置了第1个？的值
			pstmt.setString(2,xingbie) ; // 这里设置了第2个？的值
			pstmt.setString(3,lianxidianhua) ; // 这里设置了第3个？的值
			pstmt.setString(4,huiyuandengji) ; // 这里设置了第4个？的值
			pstmt.setString(5,shenfenzhenghao) ; // 这里设置了第5个？的值				
			int i = pstmt.executeUpdate();
			if (i >= 0) {    System.out.println("保存成功...");   }					
			System.out.println("插入客户表成功：");
			System.out.println("insert into consumer values('"+xingming+"','"+xingbie+"','"+lianxidianhua+"','"+huiyuandengji+"','"+shenfenzhenghao+ "')");
			
			
			String msql1 = "insert into roomin values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(msql1) ;
			pstmt.setString(1,fangjian) ; // 这里设置了第1个？的值
			pstmt.setString(2,yuangonghao) ; // 这里设置了第2个？的值
			pstmt.setString(3,kaishishijian) ; // 这里设置了第3个？的值
			pstmt.setString(4,jieshushijian) ; // 这里设置了第4个？的值
			pstmt.setFloat(5, fufei) ; // 这里设置了第5个？的值		
			pstmt.setString(6,shenfenzhenghao) ; // 这里设置了第4个？的值
			pstmt.setString(7,xingming) ; // 这里设置了第5个？的值		
			int j = pstmt.executeUpdate();
			if (j >= 0) {    System.out.println("保存成功...");   }				
			System.out.println("插入入住表:");
			System.out.println("insert into roomin values('" +fangjian+"','"+yuangonghao+"','"+kaishishijian+"','"+jieshushijian+"','"+fufei+"','"+shenfenzhenghao+"','"+xingming+ "')");
		
			
			
			String msql2 = "update room set Room_state = 1 where Room_num = ?";				
			pstmt = conn.prepareStatement(msql2) ;
			pstmt.setString(1,textField_3.getText()) ; // 这里设置了第1个？的值				
			int k = pstmt.executeUpdate();
			if (k >= 0) {    System.out.println("保存成功...");   }	
			System.out.println("插入房间表:");	
			System.out.println("update room  set Room_state="+"'1'"+"  where Room_num="+"'"+textField_3.getText()+"'");
			
			
//			String msql4 = "update room set Room_state = 0 where Room_num = ?";				
//			pstmt = conn.prepareStatement(msql4) ;
//			pstmt.setString(1,textField_3.getText()) ; // 这里设置了第1个？的值				
//			int kk = pstmt.executeUpdate();
//			if (kk >= 0) {    System.out.println("保存成功...");   }	
//			System.out.println("插入房间表:");	
//			System.out.println("update room  set Room_state="+"'1'"+"  where Room_num="+"'"+textField_3.getText()+"'");
			
			
			pstmt.close();   
			conn.close();	
			
			
			
			
			
			
			
			JOptionPane.showMessageDialog(null,"插入完毕！");
			
			
		}
		
		if(e.getSource()==button_1){
			this.dispose();
		}
		}
		catch(Exception ex){
			 System.err.print(ex.getMessage());
			 }
	}
}
