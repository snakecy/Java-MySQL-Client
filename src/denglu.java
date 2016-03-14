import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;

public class denglu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static int yy = 0, ii = 0, jj = 0, kk = 0;
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	
	ResultSet rs = null;
	Connection conn = null;

	JPanel jp1 = new JPanel();
	JLabel label1 = new JLabel("�˺�:");
	JTextField name = new JTextField();
	JLabel label2 = new JLabel("����:");
	JPasswordField password = new JPasswordField();
	JButton inBbtn = new JButton("��½");
	JButton button;
	JButton outbtn = new JButton("�˳�");
	private final JLabel label = new JLabel("New label");
	public int leixing=0;
	public denglu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(denglu.class.getResource("/res/\u5C0F\u5C4B.jpg")));
		setResizable(false);
		System.out.println("1");

		try {
			System.out.println("2");
			Class.forName(Driver);	
			System.out.println("3");
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("4");
			

		} catch (java.lang.ClassNotFoundException e) {
			System.err.print(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getContentPane().add(jp1);
		jp1.setLayout(null);
		inBbtn.setBounds(60, 224, 70, 30);
		inBbtn.setBackground(Color.MAGENTA);
		jp1.add(inBbtn);
		outbtn.setBounds(150, 224, 90, 30);
		outbtn.setBackground(Color.MAGENTA);
		jp1.add(outbtn);
		label1.setBounds(60, 123, 70, 30);
		jp1.add(label1);
		label2.setBounds(60, 174, 70, 30);
		jp1.add(label2);
		name.setBounds(100, 124, 261, 30);
		name.setBackground(Color.CYAN);
		jp1.add(name);
		password.setBounds(100, 174, 261, 30);
		password.setBackground(Color.GREEN);
		jp1.add(password);
		this.setTitle("�Ƶ������Ϣϵͳv1.0");
		this.setBounds(340, 240, 399, 292);
		inBbtn.addActionListener(this);
		outbtn.addActionListener(this);

		getRootPane().setDefaultButton(inBbtn);
		
		button = new JButton("\u6CE8\u518C\u65B0\u5BA2\u6237");
		button.setBounds(250, 224, 124, 30);
		button.addActionListener(this);
		button.setBackground(new Color(51, 204, 0));
		jp1.add(button);
		label.setIcon(new ImageIcon(denglu.class.getResource("/res/binguan.jpg")));
		label.setBounds(0, 0, 393, 117);
		
		jp1.add(label);
		this.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �رմ���ʱ�˳�����

	}

	public static void main(String[] args) {
		System.out.println("=========");
		new denglu();
		System.out.println("=========");
	}

	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.print(ex.getMessage());
		}
		return rs;
	}

	public void actionPerformed(ActionEvent f) {

		try {

			if (f.getSource() == outbtn) {
				this.setVisible(false);
				System.exit(0);
			}
			if (f.getSource() == button) {
	new zhuce();
			}

			if (f.getSource() == inBbtn) {
				if (yy < 2) {
					String zhanghao1;
					String mima1;

					zhanghao1 = name.getText().trim().toString();
					System.out.println("��һ��"+zhanghao1);
					mima1=password.getText().toString();
					//mima1 = password.getPassword().toString().trim();
					System.out.println("��һ��"+mima1);

					if (zhanghao1.equals("")) {
						JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ����������룡");
						jj = 1;
						name.setText("");
						password.setText("");
					} else
						jj = 0;
					if (mima1.equals("") && jj == 0) {
						JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ����������룡");
						kk = 1;
						name.setText("");
						password.setText("");
					} else
						kk = 0;
					if (jj == 0 && kk == 0) {
						yy++;
						String username, password1,type;
						ResultSet rs = this.executeQuery("select *from users");

						while (rs.next()) {
							System.out.println("����ѭ��");
							
							String username_temp = rs.getString("Username").trim();
							username = new String(username_temp.getBytes("ISO-8859-1"), "GB2312");	
							System.out.println("�ڶ���"+username);
							
							String password1_temp = rs.getString("Password").trim();		
							password1 = new String(password1_temp.getBytes("ISO-8859-1"), "GB2312");	
							System.out.println("�ڶ���"+password1);
							
							String type_temp=rs.getString("Type").trim();
							type = new String(type_temp.getBytes("ISO-8859-1"), "GB2312");	
							
							System.out.println("�õ��Ĳ�ѯ����ǣ�username = " + username + ", password1 = " + password1 + ", type = " + type );
							
							if (username.equalsIgnoreCase(zhanghao1) & password1.equalsIgnoreCase(mima1)) {
								System.out.println("��½�ɹ���");
								if(type.equalsIgnoreCase("user")) 
								{
									leixing=1;
									new mainmenu(leixing);
								}
								
								if(type.equalsIgnoreCase("admin"))
								{
									leixing=2;
									new mainmenu(leixing);
								}
								ii = 1;
								this.setVisible(false);
								
							}

						}// ����while
						if (ii == 0 && jj == 0 && kk == 0) {

							System.out.println("��½ʧ�ܣ�");
							JOptionPane.showMessageDialog(null, "��½ʧ�ܣ����������룡");
							name.setText("");
							password.setText("");
						}
					}

				}// ����if(yy<2)
				else if (yy >= 2) {
					JOptionPane.showMessageDialog(null, "��¼ʧ�ܳ������Σ������˳���");
					System.exit(0);

				}
			}// ����if(f.getSource()==inBbtn)

		}// ����try
		catch (SQLException ex) {
			System.err.print(ex.getMessage());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// ����������
}// ������������

