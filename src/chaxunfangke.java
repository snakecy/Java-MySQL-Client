import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
public class chaxunfangke extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JButton button,button_1;
	
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	
	ResultSet rs = null;
	Connection conn = null;
	Statement stmt;
	private JLabel label_6;
	private JTextField textField_6;
	
	public chaxunfangke() {
		setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		setTitle("\u67E5\u8BE2\u623F\u5BA2");
		getContentPane().setLayout(null);
		setLocation(300,10);                     
		setSize(430, 402);
		
		JLabel label = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(10, 10, 87, 39);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBackground(Color.GREEN);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setBounds(107, 10, 293, 36);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(10, 59, 87, 39);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(161, 59, 57, 39);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		label_3.setBounds(25, 244, 64, 39);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 14));
		label_4.setBounds(10, 126, 87, 39);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 14));
		label_5.setBounds(10, 185, 87, 39);
		getContentPane().add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GREEN);
		textField_1.setBounds(71, 60, 71, 36);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("宋体", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GREEN);
		textField_2.setBounds(228, 60, 173, 36);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("宋体", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GREEN);
		textField_3.setBounds(99, 245, 71, 36);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("宋体", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.GREEN);
		textField_4.setBounds(91, 126, 306, 36);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("宋体", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.GREEN);
		textField_5.setBounds(91, 186, 306, 36);
		getContentPane().add(textField_5);
		
		

		button = new JButton("\u67E5\u8BE2");
		button.addActionListener(this);
		button.setBackground(Color.WHITE);
		button.setFont(new Font("宋体", Font.BOLD, 14));
		button.setBounds(59, 308, 119, 39);
		getContentPane().add(button);
		getRootPane().setDefaultButton(button);
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(this); 
			
		button_1.setFont(new Font("宋体", Font.BOLD, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(240, 308, 119, 39);
		getContentPane().add(button_1);
		
		label_6 = new JLabel("\u6B20\u6B3E\uFF1A");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 14));
		label_6.setBounds(206, 244, 87, 39);
		getContentPane().add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.BLACK);
		textField_6.setFont(new Font("宋体", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.GREEN);
		textField_6.setBounds(272, 245, 84, 36);
		getContentPane().add(textField_6);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new chaxunfangke();
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
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button){
			String tt=textField.getText().toString().trim();
			if(tt.equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "身份证号不能为空！请重新输入！");
			
			}else {				
				String sql = "select * from roomin where ID = '"+tt+"'";				
				try {
					conn = DriverManager.getConnection(url,user,pwd);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					System.out.println("打印返回值="+rs);
					if ( rs== null ) { 
						System.out.println("不存在该用户");
						new Alert();
					}	
					else { 
						System.out.println("保存成功...");
						System.out.println("select * from roomin where ID=" + "'" +tt+"'");
						
						rs.next();					
						String t1=rs.getString("Room_num").toString();
						String t3=rs.getString("Name").toString();
						String t4=rs.getString("WID").toString();
						String t5=rs.getString("Start_time").toString();
						String t6=rs.getString("End_time").toString();
						String t7=rs.getString("Paid").toString();
						textField_1.setText(t1);
						textField_2.setText(t3);
						textField_3.setText(t4);
						textField_4.setText(t5);
						textField_5.setText(t6);
						textField_6.setText(t7);	
						stmt.close();   
						conn.close();		
						rs.close();
					}									
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			} 
		}
		if(e.getSource()==button_1){			
			this.dispose();;
		}		
	}
}
