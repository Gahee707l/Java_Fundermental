package java_20191126;

public class CallByRefDemo {
	public static void change(int i, int[] j) {
		i = 20;
		j[3] = 400;
	}

	public static void main(String[] args) {
		int a = 10;
		int b[] = { 1, 2, 3, 4 };

		System.out.println(a);
		System.out.println(b[3]);

		change(a, b);// 같은 클래스 내이기 때문에,클래스 이름 생략
		// 정석 : CallByRefDemo.change(a,b);
		// a = call by value | b = call by reference

		System.out.println(a);// 호출 후 변화 없음
		System.out.println(b[3]);// 호출 후 변화 있음

		// 둘이 좀 다르다
		int[] c;
		// 이 라인은,아직 메모리 할당이 안됌 c가 메모리에 안 잡힘.
		// System.out.println(c);
		// 그래서 오류가 뜬다,아직 안잡혔는데 출력 시도한것

		c = new int[4];
		// 이때 한번에 메모리에 올라간다

		int[] d = null;
		// 이 라인은,d는 메모리에 할당이 됨.
		System.out.println(c);
		// null이 나온다.
		d = new int[4];
		// 그리고 나중에 배열을 할당시켜 연결해준다

		int age;//변수의 유효범위 확인할것.이러한 지역 변수는 접근 한정자를 붙일 수 없다.
		//아직 할당이 안됀거니, = 0을 추가하면 그때 메모리에 재적 되면서 이후의 과정이 가능해진다.
		//int t=age+20;
		//System.out.println(age);
		
		//이곳의 기본값은 다 0,이건 멤버변수일때.쓰레기값이 아니라 0이다.로컬변수는 자동 초기화가 안됀다.
		//boolean은 false,char는 \n0000(비어있음)
		//refernce들은 기본적으로 null이 들어가있다
		age = 10;
		
		//web언어 : php(클래식,한국은 별로.대부분 jsp/django,rail>>요둘이빠름),go... ruby(채-고)

	}

}
