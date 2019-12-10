package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//메모리에 할당시켜 놓기...전에 stopwatch할때 썼다고 한다.(빠진날)
			//1.org.....Driver(는 클래스)를 메모리에 로드 시켜주는 작업이다.(뭘 하는지는 모르지만)
			//전부 이름도 다르다.잊어버렸다면...아래의 jar파일에서 패키지와 클래스들을 봐서 가져오면 된다.
			System.out.println("Driver load completed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		//sql 전송 가능한 인터페이스
		try {
			//2.db연결시도
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true",
			//												요건 일부분이 고정...url
					"acorn12",//user
					"acorn12");//password
			
			System.out.println("Connet with db completed");
			
			StringBuffer sql = new StringBuffer();
			//내용이 같아도 false,equals를 오버 라이딩 안해놔서...같은 객체냐를 판단 하기 때문.
			//먼저 db에서 test 한번 해보고 넣어볼것...
			sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(?,?,?)");
			//3.sql문을 전송할 수 있는 prstm 객체 생성 				바인딩 변수 ?,오로지 value에만 넣을 수 있다.
			pstmt = con.prepareStatement(sql.toString());
			
			//4.바인딩 변수(?) 설정
			pstmt.setInt(1, 60);
			pstmt.setString(2, "ANALYSIS");
			//각 파라미터에 데이터 타입 맞추어 삽입
			pstmt.setString(3, "LA");
			
			//5.SQL문 전송
			int result = pstmt.executeUpdate();//DML에서 사용,갱신된 행의 수가 반환 되어온다.
			System.out.println("Updated rows : "+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}

}
