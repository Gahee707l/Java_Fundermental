package java_20191125;

public class StaticDemo {
	static String name;
	int age;
	
	public void m1(){
		// ...이걸 부르는 시점에서는 이미 new로 누군가가 만들어서 메모리에 m1이 적재되었고 호출 객체가 생성 되어있음이 상기되어있기 때문이다.
		//나중을 확실하게 가정되어있단 말.시점 문제 !
		name = "sung"; //inst m 에서 static vari 사용 가능
		age = 10;//inst m 에서 inst vari 사용 가능
		m2();//inst m 에서 inst m 사용 가능
		m4();//inst m 에서 static m 사용 가능
	}
	public void m2(){
		System.out.println("instance method m2()");
	}
	public static void m3(){
		name = "sam";//static m 에서 static vari 사용 가능
		//age = 10;	static m 에서 inst vari 사용 불가
		
		//m2();	static m 에서 inst m 사용 불가
		//inst 쓰고 싶다면....
		StaticDemo st = new StaticDemo();
		st.age = 20;
		st.m2();
		//이렇게...inst 는 기본적으ㅡ로 객체를 new로 새로 생성하지 않는다면 쓸 수 없다.기본전제 이기때문에...
		
		m4();//static m 에서 static m 사용 가능
	}
	public static void m4(){
		System.out.println("instance method m4()");
	}
/*
	public static void main(String[] args) {
		

	}
*/
}
