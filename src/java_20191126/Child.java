package java_20191126;

public class Child extends Parent {
	double height = 170.23;

	// overriding:부모 메소드 재정의
	// 1.메소드 이름,매개변수,반환형 일치,내부 내용만 다름?
	// 2.접근 한정자는 부모보다 자식이 상위거나 같으면 된다
	public void work() {
		//super.work();//완전한 재정의,부모의 것을 완전히 쓰지 않기에.
		System.out.println("Child work()");
	}
	/*
	@Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
	}*/

	public void playGame() {
		System.out.println("Child playGame()");
	}

}
