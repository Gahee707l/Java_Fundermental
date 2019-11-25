package java_20191122;

public class ClassDemo {

	public static void main(String[] args) {
		//instance variable = 매 생성 객체마다 생기는 변수 = 멤버 변수
		//static = 공유 변수(이자 멤버 변수)
		
		//final = 상수,변경 안됌.static과 같이 자주 쓰이고 바꿀 수 없고 사실 상 인스턴스냐 스태틱에 가느냐인데 보통은 스태틱
		System.out.println("ClassDemo");
	}

}

// public
class Test {
	// 작성은 하나지만 dir 확인시 compile후 class 2개 생성 확인
	// outline 에서도....
	
	/*
	public static void main(String[] args) {
		System.out.println("Test");
	}
	*/
	
	//입력은 되지만 ...실행은 안됌 그리고 다인 개발시/공개용 목적임에도 한 파일에 여럿 넣으면 이해도가 떨어짐
	
}