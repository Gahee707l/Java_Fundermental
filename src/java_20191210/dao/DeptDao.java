package java_20191210.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20191210.dto.DeptDto;

//emp table을 이렇게 만들어 올것...
public class DeptDao {
	// 1.singleton pattern
	// DataAccessObject :new 막아놓고,싱글턴 패턴으로 하나만 쓰도록 만들어져있다.
	// 이런게 나중에 jsp로 감

	static {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// static 메소드라서,그 초기화 블록에 넣으면 됨.성능차이는 크게는...X
			// 이건 한번만 하면 됨
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	//single이라는 변수는 static 메소드(get instance)에서사용해야 하니 static변수로 설정해야 한다.
	public static DeptDao single;
	//				클래스 이름
	private DeptDao() {
	}
	//외부에서 deptdao 객체를 생성하기 위해선,getinstance메소드를 이용해야 한다.
	public static DeptDao getInstance() {
		//따라서 이 메서드에서의 deptdao 객체는 단 하나만 생성할 수 있게 코딩해야 한다.
		if (single == null) {
			single = new DeptDao();
		}
		return single;
	}

	public boolean insert(DeptDto dto) {
		// data transfer object
		boolean isSucess = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");
			// 이런건 또 파일로 이동시켜서 io로 할 수 있음

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(?,?,?)");
			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, dto.getNo());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getLoc());

			pstmt.executeUpdate();
			isSucess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSucess;
	}

	public boolean update(DeptDto dto) {
		boolean isSucess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");
			// connection은...어쩔 수 없다,계속 매번 해야함.

			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dept ");
			sql.append("SET dname = ?, loc = ? ");
			sql.append("WHERE deptno = ?");
			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getLoc());
			pstmt.setInt(++index, dto.getNo());

			pstmt.executeUpdate();
			isSucess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSucess;
	}

	public boolean delete(int deptNo) {
		boolean isSucess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?autoReconnetion=true", "acorn12",
					"acorn12");

			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append(" FROM dept ");
			sql.append("WHERE deptno = ?");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setInt(1, deptNo);

			pstmt.executeUpdate();
			isSucess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isSucess;
	}

	public ArrayList<DeptDto> select() {
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn", "acorn12", "acorn12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno,dname,loc ");
			sql.append("FROM dept ");
			sql.append("order BY deptno");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int index = 0;
				int deptno = rs.getInt(++index);
				String dname = rs.getString(++index);
				String loc = rs.getString(++index);

				list.add(new DeptDto(deptno,dname,loc));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public DeptDto select(int deptNo) {
		DeptDto dto = null;
		//이걸로 리턴되면 결과값이 없는것이다.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn", "acorn12", "acorn12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno,dname,loc ");
			sql.append("FROM dept ");
			sql.append("where deptno= ?");

			pstmt = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstmt.setInt(++index, deptNo);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				index = 0;
				int deptno = rs.getInt(++index);
				String dname = rs.getString(++index);
				String loc = rs.getString(++index);

				dto = new DeptDto(deptno,dname,loc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
