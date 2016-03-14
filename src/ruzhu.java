import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;;
public class ruzhu extends JFrame implements ActionListener{
	public ruzhu() {
		setResizable(false);
		setTitle("\u5BA2\u6237\u5165\u4F4F");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u623F\u95F4\u53F7");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("ËÎÌו", Font.BOLD, 14));
		label.setBounds(0, 0, 89, 26);
		getContentPane().add(label);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new ruzhu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
