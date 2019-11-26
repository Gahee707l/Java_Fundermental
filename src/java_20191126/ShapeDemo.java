package java_20191126;

public class ShapeDemo {
	public static void run(Shape s){
		//				매개변수,그러니까 Shape s = new Rect과 같은 셈이다.
		s.draw();
		//추상 클래스의 추상 메소드지만 꺼내오기 가능,넘길때 실 자식 개체를 넘겨주기 때문.
	}

	public static void main(String[] args) {
		// 추상클래스 : 객체 생성 불가능
		// Shape s = new Shape();
		Shape s = new Rectangle();
		s.draw();
		Shape s2 = new Triangle();
		s2.draw();
		
		run(new Rectangle());
		//이런 식으로.파라미터:
		run(new Triangle());
	}

}
