package java_20191126;

public class Sub extends Super {
	//클래스 정의 창에서 추가 가능
	public Sub(){
		//super늘 숨겨져있다.부모 클래스의 디폴트 생성자 호출
		//super(0);
		super();
	}
	String chicken;
	public void gotoSchool() {
		System.out.println("sub gotoSchool()");
	}

}
