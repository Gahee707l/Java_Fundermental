package java_20191125;

public class OverloadingDemo {
	// 작성규칙
	// 1.동일 클래스 내
	// 2.동명
	// 3-1.매개변수 갯수가 동일하나 data type 다름
	// 3-2.매개변수 갯수 다름
	// 4. 반환형&접근 지정자는 같아도 되고 달라도 되고....

	public void print(String str) {
		System.out.println(str);
	}

	public void print(int i) {
		System.out.println(i);
	}

	public void print(double d) {
		System.out.println(d);
	}

	public void print(boolean b) {
		System.out.println(b);
	}

	public static void main(String[] args) {
		OverloadingDemo o = new OverloadingDemo();
		
		o.print(true);
		o.print("test");
		o.print(23+34);
		o.print(43.456);

	}
}
