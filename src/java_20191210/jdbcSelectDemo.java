package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcSelectDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn", "acorn12", "acorn12");
			// 홈페이지에 나와는 있음
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno,dname,loc ");
			sql.append("FROM dept ");
			sql.append("order BY deptno");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			// select 문일때 sql문 전송...insert에서도 되긴 하는데,값은 null로 반환

			while (rs.next()) {
				int index =0;
				//int index =1;바운딩 사용시 이렇게 하는게 수가 작을때에도 여전히 여러모로 편함
				int deptno = rs.getInt(++index);
				//int deptno = rs.getInt(index++);
				//대입하고 증가
				//default connection 최대 수 : 50
				String dname = rs.getString(++index);
				String loc = rs.getString(++index);
				
				System.out.printf("%d, %s, %s %n", deptno, dname, loc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if(pstmt!=null){
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
