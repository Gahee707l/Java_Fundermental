package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDeleteDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("D pass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection con=null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true","acorn12","acorn12");
			//					3306,디폴트 그대로라서 port 생략
			System.out.println("C pass");
		
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append(" FROM dept ");
			sql.append("WHERE deptno = ?");
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1, 50);
			
			int result = pstmt.executeUpdate();
			System.out.println("삭제된 행의 수 : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(pstmt != null){
						pstmt.close();
					}
					if(con != null){
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

}
