import java.sql.*;

import javax.swing.JOptionPane;



public class tuidingfangjian {
	String Driver = "com.mysql.jdbc.Driver";	
	String url = "jdbc:mysql://127.0.0.1:3306/db_librarysys";
	String user = "root";
	String pwd = "root";
	ResultSet rs = null;
	PreparedStatement pstmt;
	Connection conn = null;	
	String fangjian;
	
	public tuidingfangjian(String fangjianhao) {
		System.out.println();
			System.out.println("����Ԥ����");			
			
			String msql5 = "delete from roombook where Room_num=?";	
			try {
				conn=DriverManager.getConnection(url,user,pwd);
				
				pstmt = conn.prepareStatement(msql5) ;				
				pstmt.setString(1,fangjianhao) ; // ���������˵�1������ֵ				
			int k = pstmt.executeUpdate();
			if (k >= 0) {    System.out.println("�˶��ɹ�...");   }	
			System.out.println("���뷿���:");	
			System.out.println("update room  set Room_state= "+"'"+"0"+"'"+" where Room_num="+"'"+fangjianhao+"'");
	
			String msql6 = " update room  set Room_state= 0 where Room_num=?";	
			pstmt = conn.prepareStatement(msql6) ;	
			pstmt.setString(1,fangjianhao) ; // ���������˵�1������ֵ				
			int kk = pstmt.executeUpdate();
			if (kk >= 0) {    System.out.println("�˶��ɹ�...");   }	
			System.out.println("���뷿���:");	
			System.out.println("update room  set Room_state= "+"'"+"0"+"'"+" where Room_num="+"'"+fangjianhao+"'");
			
			pstmt.close();   
			conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

	}
	public ResultSet executeQuery(String sql){
		rs=null;
		try{
		conn=DriverManager.getConnection(url,user,pwd);
		Statement stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		JOptionPane.showMessageDialog(null, "�˶��ɹ���");
		}
	 catch(SQLException ex){
	 System.err.print(ex.getMessage());
	 }
	 return rs;
	 
	 }
	
	
		
	public static void main(String[] args) {
	
			
	}
	
	}