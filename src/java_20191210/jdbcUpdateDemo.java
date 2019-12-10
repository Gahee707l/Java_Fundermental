package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcUpdateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true",
					 "acorn12","acorn12");
			System.out.println("db 연결 성공");
			
			
			StringBuffer sql = new StringBuffer() ;
			sql.append("UPDATE dept ");
			sql.append("SET dname = ?, loc = ? ");
			sql.append("WHERE deptno = ?");
			//sql.append("UPDATE dept SET dname = 'MINING',loc = 'SILICON' WHERE deptno = 60");
			pstmt = con.prepareStatement(sql.toString());
			//연동
			
			//pstmt.setString(1, "dept");
			pstmt.setString(1, "MINING");
			pstmt.setString(2, "SILICON");
			pstmt.setInt(3, 60);
			
			int result=pstmt.executeUpdate();
			System.out.println("갱신된 행의 수 : "+result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
