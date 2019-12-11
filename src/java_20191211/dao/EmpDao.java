package java_20191211.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java_20191211.dto.EmpDto;

public class EmpDao {
	private static String url;
	private static String user;
	private static String password;
	// 이것들은...멤버로 써야 하니까.
	public static EmpDao single;

	static {
		try {
			// 드라이브 커넥션을 설정파일에서 읽어오기

			FileInputStream fis = new FileInputStream("C:\\dev\\workspace\\Java_Fundermental\\src\\jbdc.properties");
			Properties prop = new Properties();
			prop.load(fis);
			// prop의 파일에 key=value로 한다.파일 내용의 내려쓰기를하려면 \로해야함.

			String driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			// 이건 한번만 쓰면 되니까 지역 변수로

			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private EmpDao() {
		// 생성을 막아둔다...50개의 엔트리에서 보통 막히니까.
	}

	public static EmpDao getInstance() {
		if (single == null) {
			single = new EmpDao();
		}
		return single;
	}

	public boolean insert(EmpDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) ");
			sql.append("VALUES(?,?,?,?,CURDATE(),?,?,?)");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;

			pstmt.setInt(++index, dto.getNo());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getJob());
			pstmt.setInt(++index, dto.getMgr());
			pstmt.setDouble(++index, dto.getSal());
			pstmt.setDouble(++index, dto.getComm());
			pstmt.setInt(++index, dto.getDeptno());

			pstmt.executeUpdate();

			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}

	public boolean update(EmpDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE emp ");
			sql.append("SET ename = ?,job = ?,mgr=?,sal =?,comm=?,deptno =? ");
			sql.append("WHERE empno = ?");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;

			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getJob());
			pstmt.setInt(++index, dto.getMgr());
			pstmt.setDouble(++index, dto.getSal());
			pstmt.setDouble(++index, dto.getComm());
			pstmt.setInt(++index, dto.getDeptno());
			pstmt.setInt(++index, dto.getNo());

			pstmt.executeUpdate();

			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}

	public boolean delete(int no) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE  ");
			sql.append("FROM emp  ");
			sql.append("WHERE empno = ?");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;

			pstmt.setInt(++index, no);

			pstmt.executeUpdate();

			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}

	public ArrayList<EmpDto> select(int start, int len) {
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			// prop을 바로 집어 넣을 수는...있다.

			StringBuffer sql = new StringBuffer();

			// sql.append("SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno
			// ");
			sql.append("SELECT empno,ename,job,mgr,date_format(hiredate,'%Y/%m/%d'),sal,comm,deptno ");
			// 자료형 : date
			sql.append("FROM emp ");
			sql.append("ORDER by hiredate DESC ");
			sql.append("LIMIT ?,?");

			int index = 0;
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(++index, start);
			pstmt.setInt(++index, len);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 0;
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String hiredate = rs.getString(++index);
				double sal = rs.getDouble(++index);
				double comm = rs.getDouble(++index);
				int deptno = rs.getInt(++index);

				list.add(new EmpDto(no, name, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public EmpDto select(int no) {
		EmpDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			// prop을 바로 집어 넣을 수는...있다.

			StringBuffer sql = new StringBuffer();

			// sql.append("SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno
			// ");
			sql.append("SELECT empno,ename,job,mgr,date_format(hiredate,'%Y/%m/%d'),sal,comm,deptno ");
			// 자료형 : date
			sql.append("FROM emp ");
			sql.append("WHERE empno = ?");

			int index = 0;
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(++index, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				index = 0;
				no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String hiredate = rs.getString(++index);
				double sal = rs.getDouble(++index);
				double comm = rs.getDouble(++index);
				int deptno = rs.getInt(++index);

				dto = new EmpDto(no, name, job, mgr, hiredate, sal, comm, deptno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if (rs != null)
			pstmt.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

}
