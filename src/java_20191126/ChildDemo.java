package java_20191126;

public class ChildDemo {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.age = 55;
		p1.work();
		p1.playBadook();

		Child c1 = new Child();
		c1.age = 25;
		c1.height = 155.24;
		c1.playBadook();
		c1.playGame();
		c1.work();
		
		Parent p2 = new Child();
		//레퍼런스 타입 = 생성 객체
		//형변환이라고 한다,오토 캐스팅
		//보통 부모가 클래스가 아닌 추상 클래스/인터페이스일 경우 객체를 생성할 수 없기 때문에 자식 객체를 통해 만든다.
		
		p2.age = 25;
		//p2.height = 155.24;
		p2.playBadook();
		//p2.playGame();
		p2.work();
		//!이건 부모의 work가 아닌,오버 라이딩된 자식의 work가 호출된다.
		
		//Child c2 = (Child)new Parent();
		//문법적으로는 문제 없어보이지만...강제 캐스팅 시키면 오류는 안뜨지만,오류가 어쨌거나 난다.
		//레퍼런스가 child를 가리켜야 하기 때문.
	}

}
