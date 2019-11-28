package java_20191128;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		// 거의없기는 하지만,맵은 전부 출력하기가 어려움
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//ex)귓속말 기능
		// key값은 반드시 유일해야 하며,value에 데이터(객체) 중복 저장 허용.key중복시 덮어쓴다.

		map.put("1", 11111);
		map.put("2", 22222);
		map.put("3", 33333);
		map.put("4", 44444);
		map.put("5", 55555);
		map.put("1", 66666);

		Integer value = map.get("1");
		System.out.println(value);
		
		Set<String> set = map.keySet();
		//뒤죽박죽 들어가있는 키들,그러나 이 키들은 중복 비허용,반환값이 set
		//역시 이터레이터로 뽑아야 한다.
		
		Iterator<String> i =set.iterator();
		//		여기서 스트링으로 지정했으니
		while(i.hasNext()){
			String k=i.next();
			Integer v = map.get(k);
			//casting필요 없다
			System.out.format("key : %s, value : %d%n",k,v);
		}
		//회원관리 만들기...
		//전부 콘솔에서 입력!
		//입력(추가)업데이트삭제???

	}

}
