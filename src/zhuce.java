import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
public class zhuce extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JButton button_1;
	public zhuce() {
		setBounds(11, 11, 400, 519);
		getContentPane().setBackground(new Color(153, 102, 255));
		setTitle("\u6CE8\u518C\u65B0\u5BA2\u6237");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ¹Ø±Õ´°¿ÚÊ±ÍË³ö³ÌÐò		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 255));
		panel.setBounds(0, 0, 389, 467);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u5BA2\u6237\u6CE8\u518C");
		label.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 39));
		label.setBounds(90, 10, 202, 42);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u5C06\u5982\u4E0B\u4FE1\u606F\u5C3D\u91CF\u586B\u5199\u5B8C\u6574\uFF0C\u5E26\uFF08*\uFF09\u7684");
		label_1.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 20));
		label_1.setBounds(10, 40, 369, 53);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u4E3A\u5FC5\u586B\u9879\uFF1A");
		label_2.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 20));
		label_2.setBackground(new Color(240, 240, 240));
		label_2.setBounds(10, 62, 369, 53);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u59D3\u540D\uFF1A");
		label_3.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 20));
		label_3.setBounds(20, 154, 113, 26);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u6027\u522B\uFF08*\uFF09\uFF1A");
		label_4.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 20));
		label_4.setBounds(20, 211, 113, 26);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF08*\uFF09\uFF1A");
		label_5.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 20));
		label_5.setBounds(20, 263, 166, 26);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_6.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 20));
		label_6.setBounds(20, 361, 113, 26);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.setBounds(90, 154, 118, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 310, 290, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 361, 168, 26);
		panel.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("ÃÔÄã¼òÕ±±ÊºÚ", Font.PLAIN, 23));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(139, 211, 69, 26);
		panel.add(comboBox);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.setFont(new Font("ËÎÌå", Font.BOLD, 14));
		button.setBounds(35, 420, 93, 23);
		panel.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(this);
			
		button_1.setFont(new Font("ËÎÌå", Font.BOLD, 14));
		button_1.setBounds(199, 420, 93, 23);
		panel.add(button_1);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_1) {
			this.dispose();

		}
		
	}
}
