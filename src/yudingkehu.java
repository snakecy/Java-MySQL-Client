import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class yudingkehu extends JFrame implements ActionListener{
	
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	
	ResultSet rs = null;
	PreparedStatement pstmt;

	Connection conn = null;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton button,button_1;
	private JLabel label_5;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_6;
	String fangjian;
	public yudingkehu(String fangjianhao) {
		getContentPane().setBackground(Color.ORANGE);
		setBackground(new Color(0, 128, 0));
		fangjian=fangjianhao;
		setResizable(false);
		setLocation(300,10);                     
		setSize(460, 364);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // �رմ���ʱ�˳�����
		setTitle(" \u5BA2\u6237\u9884\u8BA2");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 14));
		label.setBounds(10, 55, 54, 26);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.BOLD, 14));
		textField.setBounds(92, 57, 98, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7*\uFF1A");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("����", Font.BOLD, 14));
		label_2.setBounds(10, 104, 87, 26);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.BOLD, 14));
		textField_1.setBounds(92, 107, 155, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("����", Font.BOLD, 14));
		label_3.setBounds(10, 148, 87, 26);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("����", Font.BOLD, 14));
		textField_2.setBounds(92, 150, 155, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("\u6DFB\u52A0");
		button.addActionListener(this); 
		button.setFont(new Font("����", Font.BOLD, 14));
		button.setBounds(55, 282, 130, 34);
		getContentPane().add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("����", Font.BOLD, 14));
		button_1.setBounds(265, 282, 130, 34);
		button_1.addActionListener(this);
		getContentPane().add(button_1);
		
		label_5 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("����", Font.BOLD, 14));
		label_5.setBounds(265, 10, 66, 26);
		getContentPane().add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("����", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(341, 13, 67, 21);
		textField_3.setText(fangjianhao);
		getContentPane().add(textField_3);
		
		JLabel label_7 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("����", Font.BOLD, 14));
		label_7.setBounds(10, 10, 66, 26);
		getContentPane().add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("����", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(92, 12, 108, 21);
		getContentPane().add(textField_5);
		
		JLabel label_6 = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("����", Font.BOLD, 14));
		label_6.setBounds(10, 195, 75, 26);
		getContentPane().add(label_6);
		
		
		Calendar c = Calendar.getInstance();
	    SimpleDateFormat simpleDateTimeFormat =new SimpleDateFormat( "yyyy��MM��dd�� HH:mm:ss" );
	    c = Calendar.getInstance(Locale.CHINESE);
	    System.out.println(simpleDateTimeFormat.format(c.getTime()));
	    
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("����", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(80, 197, 199, 21);
		textField_4.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_4);
		
		JLabel label_8 = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("����", Font.BOLD, 14));
		label_8.setBounds(10, 235, 75, 26);
		getContentPane().add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("����", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(80, 237, 199, 21);
		textField_6.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_6);
		getRootPane().setDefaultButton(button);
		setVisible(true);
	}

	public static void main(String[] args) {

		String jj="103";
new yudingkehu(jj);
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
					||textField_6.getText().equals(""))
				  JOptionPane.showMessageDialog(null,"������������");
			
			String xingming,shenfenzhenghao,lianxidianhua,fangjian,
			yuangonghao,kaishishijian,jieshushijian;
			String xingbie = null;
			String huiyuandengji=null;
			
			yuangonghao=textField_5.getText();
			fangjian=textField_3.getText();
			xingming=textField.getText();
			shenfenzhenghao=textField_1.getText();
			lianxidianhua=textField_2.getText();
			kaishishijian=textField_4.getText();
			jieshushijian=textField_6.getText();
			
			
			
			String msql = "insert into consumer values(?,?,?,?,?)";
			
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(msql) ;
			pstmt.setString(1,xingming) ; // ���������˵�1������ֵ
			pstmt.setString(2,xingbie) ; // ���������˵�2������ֵ
			pstmt.setString(3,lianxidianhua) ; // ���������˵�3������ֵ
			pstmt.setString(4,huiyuandengji) ; // ���������˵�4������ֵ
			pstmt.setString(5,shenfenzhenghao) ; // ���������˵�5������ֵ				
			int j = pstmt.executeUpdate();
			if (j >= 0) {    System.out.println("����ɹ�...");   }					
			System.out.println("����ͻ���ɹ���");
			System.out.println("insert into consumer values('"+xingming+"','"+xingbie+"','"+lianxidianhua+"','"+huiyuandengji+"','"+shenfenzhenghao+ "')");
			
			
			
			String msql4 = "insert into roombook values(?,?,?,?,?,?,?)";
			System.out.println("ִ��1");
			pstmt = conn.prepareStatement(msql4);

			
			System.out.println("ִ��11");
			pstmt.setString(1,fangjian) ; // ���������˵�1������ֵ
			System.out.println("ִ��12");
			pstmt.setString(2,yuangonghao) ; // ���������˵�2������ֵ
			System.out.println("ִ��13");
			pstmt.setString(3,kaishishijian) ; // ���������˵�3������ֵ
			System.out.println("ִ��14");
			pstmt.setString(4,jieshushijian) ; // ���������˵�4������ֵ
			System.out.println("ִ��15");
			pstmt.setString(5,shenfenzhenghao) ; // ���������˵�5������ֵ	
			System.out.println("ִ��16");
			pstmt.setString(6,xingming) ; // ���������˵�6������ֵ
			System.out.println("ִ��17");
			pstmt.setString(7,lianxidianhua) ; // ���������˵�7������ֵ	
			
			System.out.println("ִ��2");
			int i = pstmt.executeUpdate();
			System.out.println("ִ��3");
			if (i >= 0) { System.out.println("����ɹ�...");   }					
			System.out.println();
			System.out.println("insert into roombook values" +
					"('" +fangjian+"','"+yuangonghao+"','"+kaishishijian+"','"+jieshushijian+"','"+shenfenzhenghao+"','"+xingming+"','"+lianxidianhua+ "')");
			
			
			
			String msql3 = "update room set Room_state = 2 where Room_num = ?";				
			pstmt = conn.prepareStatement(msql3) ;
			pstmt.setString(1,textField_3.getText()) ; // ���������˵�1������ֵ				
			int k = pstmt.executeUpdate();
			if (k >= 0) {    System.out.println("����ɹ�...");   }	
			System.out.println("���뷿���:");	
			System.out.println("update room  set Room_state="+"'2'"+"  where Room_num="+"'"+textField_3.getText()+"'");
			
			//rs = this.executeQuery(" update room  set Room_state= "+"'"+"2"+"'"+" where Room_num="+"'"+textField_3.getText()+"'");
			
			pstmt.close();   
			conn.close();	
			JOptionPane.showMessageDialog(null,"������ϣ�");
			
			
		}
		}
		catch(Exception ex){
			 System.err.print(ex.getMessage());
			 }
		if(e.getSource()==button_1){
			this.dispose();
		}
		
	}
}
