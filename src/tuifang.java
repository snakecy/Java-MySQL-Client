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
public class tuifang extends JFrame implements ActionListener{
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
	String fangjian;
	private JLabel label_9;
	private JTextField textField_7;
	public tuifang(String fangjianhao) throws SQLException {
		getContentPane().setBackground(Color.ORANGE);
		setBackground(new Color(0, 128, 0));
		fangjian=fangjianhao;
		setResizable(false);
		setLocation(300,10);                     
		setSize(495, 371);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 关闭窗口时退出程序
		setTitle("\u9000\u623F");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(10, 55, 54, 26);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setBounds(92, 57, 98, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7*\uFF1A");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(10, 104, 87, 26);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setBounds(92, 107, 155, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		button = new JButton("\u9000\u623F");
		button.addActionListener(this); 
		button.setFont(new Font("宋体", Font.BOLD, 14));
		button.setBounds(58, 283, 130, 34);
		getContentPane().add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.BOLD, 14));
		button_1.setBounds(294, 283, 130, 34);
		getContentPane().add(button_1);
		
		label_5 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 14));
		label_5.setBounds(265, 10, 66, 26);
		getContentPane().add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("宋体", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(341, 13, 67, 21);
		textField_3.setText(fangjianhao);
		getContentPane().add(textField_3);
		
		JLabel label_7 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("宋体", Font.BOLD, 14));
		label_7.setBounds(10, 10, 66, 26);
		getContentPane().add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(92, 12, 108, 21);
		getContentPane().add(textField_5);
		
		JLabel label_6 = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 14));
		label_6.setBounds(10, 158, 75, 26);
		getContentPane().add(label_6);
		
		
		Calendar c = Calendar.getInstance();
	    SimpleDateFormat simpleDateTimeFormat =new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss" );
	    c = Calendar.getInstance(Locale.CHINESE);
	    System.out.println(simpleDateTimeFormat.format(c.getTime()));
	    
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(93, 158, 199, 21);
		textField_4.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_4);
		
		JLabel label_8 = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("宋体", Font.BOLD, 14));
		label_8.setBounds(10, 198, 75, 26);
		getContentPane().add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(93, 198, 199, 21);
		textField_6.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_6);
		
		label_9 = new JLabel("\u6B20\u6B3E\uFF1A");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("宋体", Font.BOLD, 14));
		label_9.setBounds(10, 234, 75, 26);
		getContentPane().add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(92, 237, 108, 21);
		getContentPane().add(textField_7);
		getRootPane().setDefaultButton(button);
		
		
		rs = this.executeQuery("select *  from roomin where Room_num="+"'"+fangjian+"'");
		System.out.println("select *  from roomin where Room_num="+"'"+fangjian+"'");
		rs.next();
		System.out.println("zhixing");
String xingming,xingbie,shenfenzhenghao,huiyuandengji,
yuangonghao,kaishishijian,jieshushijian;
String fufei;
shenfenzhenghao=rs.getString("ID").trim();
xingming=rs.getString("Name").trim();
yuangonghao=rs.getString("WID").trim();
kaishishijian=rs.getString("Start_time").trim();
jieshushijian=rs.getString("End_time").trim();
fufei=rs.getString("Paid").trim();

textField_5.setText(yuangonghao);
textField.setText(xingming);
textField_1.setText(shenfenzhenghao);
textField_4.setText(kaishishijian);
textField_6.setText(jieshushijian);
textField_7.setText(fufei);

		
		
		setVisible(true);
	}

	public static void main(String[] args) {

//		String jj="103";
//			new tuifang(jj);
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
			String msql2 = "delete from roomin where Room_num = ?";
			pstmt = conn.prepareStatement(msql2) ;
			System.out.println("是否执行1");
			pstmt.setString(1,textField_3.getText()) ; // 这里设置了第1个？的值		
			System.out.println("是否执行2");						
			int k = pstmt.executeUpdate();			
			System.out.println("是否执行3");
			if (k >= 0) {    System.out.println("删除成功...");   }	
			System.out.println("删除入住信息:");	
			System.out.println("update roomin  set Room_state="+"'0'"+"  where Room_num="+"'"+textField_3.getText()+"'");
			
	
			String msql3 = "update room  set Room_state= 0 where Room_num = ?";
			pstmt = conn.prepareStatement(msql3) ;
			pstmt.setString(1,textField_3.getText()) ; // 这里设置了第1个？的值				
			int j = pstmt.executeUpdate();
			if (j >= 0) {    System.out.println("更改成功...");   }	
			System.out.println("更改房间表:");	
			System.out.println("update room  set Room_state="+"'0'"+"  where Room_num="+"'"+textField_3.getText()+"'");
			pstmt.close();   
			conn.close();			
			JOptionPane.showMessageDialog(null,"操作成功！");
			this.dispose();		
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
