package java_20191128;

import java.util.*;

public class SetDemo {
	public static void main(String[] args) {
		// 중복 비허용,no 순서
		// HashSet set = new HashSet();
		// ctrl+shift+o 자동 임포트

		// TreeSet은 데이터(객체)의 중복 비허용,출력시 오름차 순 정렬
		TreeSet<Integer> set = new TreeSet<Integer>();
		// String
		while (true) {
			int rand = (int) (Math.random() * 45) + 1;
			// 데이터의 안정성 미 보장,안에 무엇이든 들어가니까 꺼낼때 문제 발생.
			// 그래서 단일 타입만 들어가도록 만들어 주기위한 것이 제네릭.ex) <String>덧붙이면 스트링만 들어간다.
			set.add(rand);
			// 앞에 Integer로 넣으면 +""을 못함
			// String이면 rand만으론 안들어간다.
			if (set.size() == 6)
				break;
		}

		Iterator<Integer> i = set.iterator();
		// 이터레이터가 대략 정리 해줌(여전히 순서 랜덤)내부의 cursor에게 질의로 가져옴,next하면 cursor는 지나감(추측)
		while (i.hasNext()) {// hashset에 출력될 수 있는 객체가 존재 하는지 판단
			int temp = (Integer) i.next();// next의 해당 객체를 가져온다
			// 앞에서 integer라고 했으니 캐스팅 불필요
			System.out.print(temp + "\t");
		}
		
		HashSet<Test> s = new HashSet();
		s.add(new Test(10));
		s.add(new Test(20));
		s.add(new Test(10));
		//custom class로 equals와 hashcode가 overiding안돼으니,둘은 다른 객체이기에 중복
		//하고나면 이제 사이즈 3개아니고 2개됨
		System.out.println();
		System.out.println(s.size());
		
	}

}

class Test {
	int a;

	Test(int a) {
		this.a = a;
	}

	//alt+shift+s+r
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (a != other.a)
			return false;
		return true;
	}

}
