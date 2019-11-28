package java_20191128;

public class MathDemo {

	public static void main(String[] args) {
		double d1 = Math.ceil(4.1);
		System.out.println(d1);
		// d1보다 크거나 같은 수중 가장 작은 수,말 그대로 천장과 바닥
		d1 = Math.floor(4.9);
		System.out.println(d1);
		// math클래스의 round = 반올림
		/*
		 * long l1 = Math.round(42.789); System.out.println(l1);
		 */

		// 더블이면 롱 반환....하지만 소숫점 아래를 올리고 싶다면? = 42.79
		d1 = Math.round(42.789 * 100);
		// whoa...............
		System.out.println(d1 / 100);

		d1 = Math.abs(-4.3);
		System.out.println(d1);

		d1 = Math.sqrt(4);
		System.out.println(d1);

		d1 = Math.pow(2, 3);
		System.out.println(d1);

		d1 = Math.random();
		System.out.println(d1);
		// 스트링객체 : 이뮤터블,불변객체.안바뀐다.
		// new와 ""로 생성 방법 각각 다름
		//new : 무조건 새 객체 생성,hashcode와 equals를 오버라이딩 해놔서 이렇게 만들어도 똑같다.
		//==은 무조건 같은 객체를 참고하는 지만 확인
		//equals는 오버라이딩 안해놨으면 Oject클래스의 것이라 ==과 똑같다.
		
		//"" :처음만 String object생성,두번째부터는 같은 객체가 있는지 serch해서 같으면 안만들고 그쪽을 가리킴
		//불변객체 = 바뀌지 않기 때문에 새로 만들고 가리키는 옮겨가는 방식이다.콜바이 레퍼런스로 갔다와도 바뀌지 않는다.수정이 불가능하니까...
		//호출과 전달까지는 되는데....가변 처리 되는 순간,새 객체를 만들어 그 객체를 가리킨다.
		//s2가 바뀌거나 둘다 참조하지 않아도 constant pool 로 감.그러니 다직은 new로 쓸것.gc가 알아서 지워줌...string buffer쓰자.
		//문자 연결은 나중에 나오는 스트링 버퍼쓸것
		//계속 재사용..new에선 사라지는데 ""는안사라짐.
	}

}
