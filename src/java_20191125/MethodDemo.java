package java_20191125;

public class MethodDemo {
	
	//instance method : static m,static var 다 호출 가능 = 나중에 생성(메모리 재적)되어 전부 보기 가능
	//static metho d: instance 계열은 전부 호출을 못해온다 = 객체 생성 전에 먼저 생김...그래서 나중에 생기는 inst인지 불가능
	//static 내부에서 inst 선언시 가능...쓰기 위해서는 전부 new 객체 필요+main에서도 그렇듯.

	public int plus(int fir, int sec) {
		return fir + sec;
	}

	public double divide(int fir, int sec) {
		return (double) fir / (double) sec;
	}

	public int[] acs(int[] a) {
		// acsending ,오름차순 정렬
		// int[] r = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - (i + 1); j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
				}
			}
		}
		return a;
	}

	public void print(String str) {
		System.out.print(str);
	}

	public boolean isLeafYear(int year) {
		// 매개변수 = parameter
		if (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MethodDemo md = new MethodDemo();
		int t1 = md.plus(10, 20);
		double t2 = md.divide(22, 5);
		int[] t4 = { 1, 42, 45, 3, 10, 9, 80, 34 };
		// 전달인자 = arguments
		int[] t5 = md.acs(t4);

		boolean t6 = md.isLeafYear(2019);

		System.out.println(t1);
		System.out.println(t2);
		for (int value : t5) {
			System.out.print(value + " ");
			//				잊지말자...자동기능

		}
		System.out.println();
		if (t6) {
			System.out.println("윤년");
		} else {
			System.out.println("평년");
		}
		md.print("월요일 입니다.");

	}

}
