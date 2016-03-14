import java.sql.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class DSA extends JFrame  implements ActionListener{
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	
	Connection conn = null;
	ResultSet rs = null;
	private JTable table,table2,table3;

	static Object[][] rowData = new Object[30][7]; // 表格数据
	static Object[][] rowData2 = new Object[30][7]; // 表格数据
	static Object[][] rowData3 = new Object[37][4]; // 表格数据
	JButton fanhui;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public DSA(int zongshu,int danjianshu,int biaojianshu,int guibinshu,int yudingshu,int zangfangshu) {
		super("当前房间状况一览表"); // 调用父类构造函数
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("\u5F53\u524D\u623F\u95F4\u60C5\u51B5\u4E00\u89C8\u8868");
		setBounds(140, 40, 1048, 684);// 设置窗口尺寸
		setResizable(false);
		String[] columnNames = { "房间号", "身份证号", "姓名", "员工号", "开始日期", "结束日期", "欠款" }; // 列名
		String[] columnNames2 = { "房间号", "身份证号", "姓名", "联系电话", "员工号","开始日期", "结束日期" }; // 列名
		String[] columnNames3 = { "房间号", "房间类型", "房间价格", "房间状态" }; // 列名
		try {
			Class.forName(Driver);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print(e.getMessage());
		}
		fanhui=new JButton("返回");
		fanhui.setBounds(0, 616, 1031, 23);
		fanhui.addActionListener(this);
		Container container = getContentPane();
		getContentPane().setLayout(null);
		table = new JTable(rowData, columnNames); // 实例化表格
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 24, 1031, 137);
		container.add(scrollPane); // 增加组件
		
		table2 = new JTable(rowData2, columnNames2); // 实例化表格
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(0, 186, 1031, 137);
		container.add(scrollPane2); // 增加组件
		
		table3 = new JTable(rowData3, columnNames3); // 实例化表格
		JScrollPane scrollPane3 = new JScrollPane(table3);
		scrollPane3.setBounds(0, 347, 1031, 164);
		container.add(scrollPane3); // 增加组件
		
		container.add(fanhui);
		
		JLabel label = new JLabel("\u5F53\u5929\u8425\u4E1A\u989D\uFF1A");
		label.setBounds(10, 521, 95, 43);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label);
		
		ResultSet rs = this.executeQuery("select Paid from roomin");
		int count = 0;
		int zonge=0;
		int aa[]=new int[40];
		try {
			while (rs.next()) {
				aa[count] = rs.getInt("Paid"); // 初始化数组内容
				zonge=zonge+aa[count];
				count++;
			}
		} catch (SQLException ex) {
			System.err.print(ex.getMessage());
		}
		
		textField = new JTextField();
		textField.setBounds(99, 532, 95, 21);
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setText(zonge+"");
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u5165\u4F4F\u5355\u4EBA\u95F4\uFF1A");
		label_1.setBounds(10, 563, 130, 43);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 574, 41, 21);
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setText(danjianshu+"");
		getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("\u5F53\u524D\u5165\u4F4F\u6807\u51C6\u95F4\uFF1A");
		label_2.setBounds(187, 563, 124, 43);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(321, 574, 41, 21);
		textField_2.setFont(new Font("宋体", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setText(biaojianshu+"");
		getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u9884\u8BA2\u5BA2\u623F\u6570\uFF1A");
		label_3.setBounds(561, 563, 120, 43);
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(683, 574, 41, 21);
		textField_3.setFont(new Font("宋体", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setText(yudingshu+"");
		getContentPane().add(textField_3);
		
		JLabel label_4 = new JLabel("\u5F53\u524D\u5165\u4F4F\u8D35\u5BBE\u623F\uFF1A");
		label_4.setBounds(380, 563, 120, 43);
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(507, 574, 41, 21);
		textField_4.setFont(new Font("宋体", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setText(guibinshu+"");
		getContentPane().add(textField_4);
		
		JLabel label_5 = new JLabel("\u5F53\u524D\u5165\u4F4F\u603B\u623F\u95F4\u6570\uFF1A");
		label_5.setBounds(223, 521, 139, 43);
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(370, 532, 41, 21);
		textField_5.setFont(new Font("宋体", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setText(zongshu+"");
		getContentPane().add(textField_5);
		
		JLabel label_6 = new JLabel("\u5F53\u524D\u5F85\u6574\u7406\u623F\u95F4\u6570\uFF1A");
		label_6.setBounds(745, 563, 138, 43);
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 14));
		getContentPane().add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(893, 574, 41, 21);
		textField_6.setFont(new Font("宋体", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setText(zangfangshu+"");
		getContentPane().add(textField_6);
		
		JLabel label_7 = new JLabel("\u5F53\u524D\u5165\u4F4F\u4FE1\u606F\uFF1A");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("宋体", Font.BOLD, 14));
		label_7.setBounds(0, 0, 130, 26);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u5F53\u524D\u9884\u8BA2\u4FE1\u606F\uFF1A");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("宋体", Font.BOLD, 14));
		label_8.setBounds(0, 162, 130, 26);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u5F53\u524D\u623F\u95F4\u72B6\u6001\uFF1A");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("宋体", Font.BOLD, 14));
		label_9.setBounds(0, 324, 114, 26);
		getContentPane().add(label_9);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 关闭窗口时退出程序
		
		 rs = this.executeQuery("select *from roomin");
		count = 0;
		try {
			while (rs.next()) {
				rowData[count][0] = rs.getString("Room_num"); // 初始化数组内容
				System.out.println("打印房间号");
				
				
				
				rowData[count][1] = rs.getString("ID");
				System.out.println("打印身份证号");
				rowData[count][2] = rs.getString("Name");
				rowData[count][3] = rs.getString("WID");
				rowData[count][4] = rs.getString("Start_time");
				rowData[count][5] = rs.getString("End_time");
				rowData[count][6] = rs.getString("Paid");
				count++;
			}
		} catch (SQLException ex) {
			System.err.print(ex.getMessage());
		}
		
		rs = this.executeQuery("select *from roombook");
		count = 0;
		try {
			while (rs.next()) {
				rowData2[count][0] = rs.getString("Room_num"); // 初始化数组内容
				rowData2[count][1] = rs.getString("ID");
				rowData2[count][2] = rs.getString("Name");
				rowData2[count][3] = rs.getString("Phone");
				rowData2[count][4] = rs.getString("WID");
				rowData2[count][5] = rs.getString("Start_time");
				rowData2[count][6] = rs.getString("End_time");
				count++;
			}
		} catch (SQLException ex) {
			System.err.print(ex.getMessage());
		}
		
		rs = this.executeQuery("select *from room");
		count = 0;
		try {
			while (rs.next()) {
				rowData3[count][0] = rs.getString("Room_num"); // 初始化数组内容
				rowData3[count][1] = rs.getString("Room_type");
				rowData3[count][2] = rs.getString("Room_price");
				rowData3[count][3] = rs.getString("Room_state");

				count++;
			}
		} catch (SQLException ex) {
			System.err.print(ex.getMessage());
		}
		
		
		setVisible(true); // 设置窗口可视
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

	public static void main(String[] args) throws SQLException {
		new DSA(3,1,2,0,2,2);
	}

	public void actionPerformed(ActionEvent f) {
		if (f.getSource() == fanhui) {
			this.dispose();

		}
		
	}
}
