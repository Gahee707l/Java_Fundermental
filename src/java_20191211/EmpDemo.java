package java_20191211;

import java.util.ArrayList;

import java_20191211.dao.EmpDao;
import java_20191211.dto.EmpDto;

public class EmpDemo {

	public static void main(String[] args) {

		EmpDao dao = EmpDao.getInstance();
		/*
		 * try { Class.forName("java_20191211.dao.EmpDao").newInstance();
		 * //메모리에만 올리는 행동 //new instance는 안됌.생성자가 private이라. //똑같은 코드 : EmpDao
		 * dao = new EmpDao(); //똑같은 코드 : EmpDao dao =
		 * (EmpDao)Class.forName("java_20191211.dao.EmpDao").newInstance(); //
		 * properties나 xml파일에 있는 문자열... } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); } catch (InstantiationException e) {
		 * e.printStackTrace(); } catch (IllegalAccessException e) {
		 * e.printStackTrace(); }
		 */

		// dao.insert(new EmpDto(9002,"SUNG","SALES",7839,null,4999,0,20));
		// dao.update(new EmpDto(9002,"SUNG4","SALESMAN",7839,null,5001,20,20));
		// curdate는 내부에 있고 문자열이니 null로

		/*
		 * ArrayList<EmpDto> list = dao.select(1, 5); for (EmpDto empDto : list)
		 * { int no = empDto.getNo(); String name = empDto.getName(); String job
		 * = empDto.getJob(); int mgr = empDto.getMgr(); String hiredate =
		 * empDto.getHiredate(); //대시로 가져와짐 슬래시로 쓰려면...? double sal =
		 * empDto.getSal(); double comm = empDto.getComm(); int deptNo =
		 * empDto.getDeptno();
		 * 
		 * System.out.printf("%d, %s, %s, %d, %s, %.2f, %.2f, %d %n",
		 * no,name,job,mgr, hiredate,sal,comm,deptNo); }
		 */

		EmpDto dto = dao.select(9000);

		if (dto != null) {
			int no = dto.getNo();
			String name = dto.getName();
			String job = dto.getJob();
			int mgr = dto.getMgr();
			String hiredate = dto.getHiredate(); // 대시로 가져와짐 슬래시로 쓰려면...?
			double sal = dto.getSal();
			double comm = dto.getComm();
			int deptNo = dto.getDeptno();
			System.out.printf("%d, %s, %s, %d, %s, %.2f, %.2f, %d %n", no, name, job, mgr, hiredate, sal, comm, deptNo);
		} else {
			System.out.println("no serch result");
		}

		// nullpoint exception
		/*
		 * EmpDto dto = dao.select(9005);
		 * 
		 * int no = dto.getNo(); String name = dto.getName(); String job =
		 * dto.getJob(); int mgr = dto.getMgr(); String hiredate =
		 * dto.getHiredate(); // 대시로 가져와짐 슬래시로 쓰려면...? double sal =
		 * dto.getSal(); double comm = dto.getComm(); int deptNo =
		 * dto.getDeptno(); System.out.printf(
		 * "%d, %s, %s, %d, %s, %.2f, %.2f, %d %n", no, name, job, mgr,
		 * hiredate, sal, comm, deptNo);
		 * 
		 * }
		 */
		// dao.delete(9001);
		// dao.select(9001);
	}
}
