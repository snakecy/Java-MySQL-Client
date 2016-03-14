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
			System.out.println("插入预订表：");			
			
			String msql5 = "delete from roombook where Room_num=?";	
			try {
				conn=DriverManager.getConnection(url,user,pwd);
				
				pstmt = conn.prepareStatement(msql5) ;				
				pstmt.setString(1,fangjianhao) ; // 这里设置了第1个？的值				
			int k = pstmt.executeUpdate();
			if (k >= 0) {    System.out.println("退订成功...");   }	
			System.out.println("插入房间表:");	
			System.out.println("update room  set Room_state= "+"'"+"0"+"'"+" where Room_num="+"'"+fangjianhao+"'");
	
			String msql6 = " update room  set Room_state= 0 where Room_num=?";	
			pstmt = conn.prepareStatement(msql6) ;	
			pstmt.setString(1,fangjianhao) ; // 这里设置了第1个？的值				
			int kk = pstmt.executeUpdate();
			if (kk >= 0) {    System.out.println("退订成功...");   }	
			System.out.println("插入房间表:");	
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
		
		JOptionPane.showMessageDialog(null, "退订成功！");
		}
	 catch(SQLException ex){
	 System.err.print(ex.getMessage());
	 }
	 return rs;
	 
	 }
	
	
		
	public static void main(String[] args) {
	
			
	}
	
	}