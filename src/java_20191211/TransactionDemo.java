package java_20191211;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//connection pool : 해외의 db에 접속하는데 시간이 걸리니,미리 만들어두고 확보해둔 connection들.사용중과 대기중의 pool 2개.
// connection을 만드는 물리적 거리에서 오는 지연 시간을 없애는 셈.만들어져 있으니 쓰면 된다...개념은 알아 둘 것.
// 이 안의...커넥션을 오토 커밋 false로 하면 더이상 db에 반영이 안돼니 반납된(종료 아님)연결도 그대로이니...이 풀의 커넥션은 마지막에 finally에서 꼭 다시 auto로 돌려놔야 한다.
//껐다 키면 또 되긴 하는데...지속적으로 문제가 되니 명심 할 것.대부분은 문제 못잡음...

public class TransactionDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		boolean isSuccess = false;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/acorn", "acorn12", "acorn12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(50,'aaa','aaa')");
			// sql.append("");
			// 정상 쿼리
			con.setAutoCommit(false);
			// 트랜젝션의 시작,이거 안꺼두면 pstmt1 만큼은 들어가 있다.

			pstmt1 = con.prepareStatement(sql.toString());
			pstmt1.executeUpdate();

			sql.setLength(0);
			// 이거 하면...스트링버퍼 내용 싹 지워짐....

			sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(60,'bbb','bbb)");
			// 끝에 ' 하나 빠져있다,강제로 에러 내려는 용도.
			pstmt2 = con.prepareStatement(sql.toString());
			pstmt2.executeUpdate();
			// 전송 하면서 오류남.현재 트랜잭션으로 pstmt1과 같은 단위로 묶은 것.

			isSuccess = true;
			//이 끝까지 수행 된다면 성공한거니까...
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//여기가 트랜젝션의 끝+
				if (isSuccess == true) {
					con.commit();//모두 수행
				} else {
					con.rollback();//모두 수행하지 않음
					
				}
				con.setAutoCommit(true);
				//connection pool사용시 절대로 잊으면 안돼는 부분.
				//트랜잭션이 들어가지 않는 회원가입등의 부분에선 commit이 안됀다.
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
