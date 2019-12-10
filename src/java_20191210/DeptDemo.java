package java_20191210;

import java.util.ArrayList;

import java_20191210.dao.DeptDao;
import java_20191210.dto.DeptDto;

public class DeptDemo {

	public static void main(String[] args) {
		DeptDao d = DeptDao.getInstance();
		//boolean isSuccess = d.insert(new DeptDto(50,"DEVELOPERS","TEXAS"));
		//boolean isSuccess = d.update(new DeptDto(50,"DEVELOPERS","LA"));
		//boolean isSuccess = d.delete(50);
		//System.out.println(isSuccess);
		
		/*ArrayList<DeptDto> list = d.select();
		for (DeptDto dto : list) {
			System.out.printf("%d, %s, %s %n",dto.getNo(),dto.getName(),dto.getLoc());
		}*/
		DeptDto dto=d.select(10);
		if(dto == null){
			System.out.println("no data");
		}else{
			System.out.printf("%d, %s, %s %n",dto.getNo(),dto.getName(),dto.getLoc());
		}
		
	}

}
