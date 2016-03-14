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
public class tianjiakehu extends JFrame implements ActionListener{
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	ResultSet rs = null;
	PreparedStatement pstmt;

	Connection conn = null;

	JComboBox comboBox,comboBox_1;
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
	private JLabel label_9;
	private JTextField textField_7;
	private JLabel label_10;
	private JTextField textField_8;
	public tianjiakehu(String fangjianhao) throws SQLException {
		getContentPane().setBackground(Color.ORANGE);
		setBackground(new Color(0, 128, 0));
		fangjian=fangjianhao;
		setResizable(false);
		setLocation(300,10);                     
		setSize(486, 460);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // �رմ���ʱ�˳�����
		setTitle("\u6DFB\u52A0\u5BA2\u6237");
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

		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("����", Font.BOLD, 14));
		label_1.setBounds(265, 55, 54, 26);
		getContentPane().add(label_1);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("����", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setBounds(329, 57, 54, 23);

		getContentPane().add(comboBox);

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

		JLabel label_4 = new JLabel("\u4F1A\u5458\u7B49\u7EA7\uFF1A");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("����", Font.BOLD, 14));
		label_4.setBounds(10, 194, 75, 26);
		getContentPane().add(label_4);

		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("����", Font.BOLD, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		comboBox_1.setBounds(96, 197, 66, 21);
		getContentPane().add(comboBox_1);

		button = new JButton("\u6DFB\u52A0");
		button.addActionListener(this); 
		button.setFont(new Font("����", Font.BOLD, 14));
		button.setBounds(58, 388, 130, 34);
		getContentPane().add(button);

		button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("����", Font.BOLD, 14));
		button_1.setBounds(294, 388, 130, 34);
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
		label_6.setBounds(10, 237, 75, 26);
		getContentPane().add(label_6);


		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateTimeFormat =new SimpleDateFormat( "yyyy��MM��dd�� HH:mm:ss" );
		c = Calendar.getInstance(Locale.CHINESE);
		System.out.println(simpleDateTimeFormat.format(c.getTime()));


		textField_4 = new JTextField();
		textField_4.setFont(new Font("����", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(80, 239, 199, 21);
		textField_4.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_4);

		JLabel label_8 = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("����", Font.BOLD, 14));
		label_8.setBounds(10, 277, 75, 26);
		getContentPane().add(label_8);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("����", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(80, 279, 199, 21);
		textField_6.setText(simpleDateTimeFormat.format(c.getTime()));
		getContentPane().add(textField_6);

		label_9 = new JLabel("\u6B20\u6B3E\uFF1A");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("����", Font.BOLD, 14));
		label_9.setBounds(10, 352, 75, 26);
		getContentPane().add(label_9);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(90, 358, 108, 21);
		getContentPane().add(textField_7);
		getRootPane().setDefaultButton(button);

		label_10 = new JLabel("\u623F\u95F4\u4EF7\u683C\uFF1A");
		label_10.setForeground(Color.BLUE);
		label_10.setFont(new Font("����", Font.BOLD, 14));
		label_10.setBounds(10, 316, 75, 26);
		getContentPane().add(label_10);

		rs = this.executeQuery("select Room_price from room where Room_num="+"'"+fangjian+"'");
		rs.next();
		String jiage;	
		jiage=rs.getString("Room_price");
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setText(jiage);
		textField_8.setBounds(92, 319, 108, 21);
		getContentPane().add(textField_8);
		setVisible(true);
	}

	public static void main(String[] args) throws SQLException {

		String jj="103";
		new tianjiakehu(jj);
	}


	public ResultSet executeQuery(String sql){
		rs=null;
		try{
			conn=DriverManager.getConnection(url,user,pwd);
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
//			rs=stmt.executeQuery(sql);
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
					JOptionPane.showMessageDialog(null,"������������");

				String xingming,xingbie,shenfenzhenghao,lianxidianhua,huiyuandengji,
				yuangonghao,kaishishijian,jieshushijian;
				int fufei;
				yuangonghao=textField_5.getText();                 //  WID
				fangjian=textField_3.getText();                    //  Room_num
				xingming=textField.getText();                      //  Name
				xingbie=comboBox.getSelectedItem().toString();     //Sex
				shenfenzhenghao=textField_1.getText();             //ID
				lianxidianhua=textField_2.getText();                // Phone
				huiyuandengji=comboBox_1.getSelectedItem().toString();// Member_grade
				kaishishijian=textField_4.getText();                 //Start_time
				jieshushijian=textField_6.getText();               // End_time
				fufei=Integer.parseInt(textField_7.getText());       // Paid


				//ResultSet rs = this.executeQuery("insert into consumer values('"+xingming+"','"+xingbie+"','"+lianxidianhua+"','"+huiyuandengji+"','"+shenfenzhenghao+ "')");
				String msql = "insert into consumer values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(msql) ;
				pstmt.setString(1,xingming) ; // ���������˵�1������ֵ
				pstmt.setString(2,xingbie) ; // ���������˵�2������ֵ
				pstmt.setString(3,lianxidianhua) ; // ���������˵�3������ֵ
				pstmt.setString(4,huiyuandengji) ; // ���������˵�4������ֵ
				pstmt.setString(5,shenfenzhenghao) ; // ���������˵�5������ֵ				
				int i = pstmt.executeUpdate();
				if (i >= 0) {    System.out.println("����ɹ�...");   }					
				System.out.println("����ͻ���ɹ���");
				System.out.println("insert into consumer values('"+xingming+"','"+xingbie+"','"+lianxidianhua+"','"+huiyuandengji+"','"+shenfenzhenghao+ "')");
				
				
				String msql1 = "insert into roomin values(?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(msql1) ;
				pstmt.setString(1,fangjian) ; // ���������˵�1������ֵ
				pstmt.setString(2,yuangonghao) ; // ���������˵�2������ֵ
				pstmt.setString(3,kaishishijian) ; // ���������˵�3������ֵ
				pstmt.setString(4,jieshushijian) ; // ���������˵�4������ֵ
				pstmt.setFloat(5, fufei) ; // ���������˵�5������ֵ		
				pstmt.setString(6,shenfenzhenghao) ; // ���������˵�4������ֵ
				pstmt.setString(7,xingming) ; // ���������˵�5������ֵ		
				int j = pstmt.executeUpdate();
				if (j >= 0) {    System.out.println("����ɹ�...");   }				
				System.out.println("������ס��:");
				//rs = this.executeQuery("insert into roomin values('" +fangjian+"','"+yuangonghao+"','"+kaishishijian+"','"+jieshushijian+"','"+fufei+"','"+shenfenzhenghao+"','"+xingming+ "')");
				System.out.println("insert into roomin values('" +fangjian+"','"+yuangonghao+"','"+kaishishijian+"','"+jieshushijian+"','"+fufei+"','"+shenfenzhenghao+"','"+xingming+ "')");
			
				
				
				String msql2 = "update room set Room_state = 1 where Room_num = ?";				
				pstmt = conn.prepareStatement(msql2) ;
				pstmt.setString(1,textField_3.getText()) ; // ���������˵�1������ֵ				
				int k = pstmt.executeUpdate();
				if (k >= 0) {    System.out.println("����ɹ�...");   }	
				System.out.println("���뷿���:");	
				System.out.println("update room  set Room_state="+"'1'"+"  where Room_num="+"'"+textField_3.getText()+"'");
				
				
				pstmt.close();   
				conn.close();				

				JOptionPane.showMessageDialog(null,"������ϣ�");	
			}

			if(e.getSource()==button_1){
				this.dispose();
			}
		}
		catch(Exception ex){
			System.err.print(ex.getMessage());
		}
		
	}

	private ResultSet execute(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResultSet executeupdate(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
