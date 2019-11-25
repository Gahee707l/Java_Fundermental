package java_20191122;

public class CustomerDemo {

	public static void main(String[] args) {
		Customer.interestRate = 4.5;
		
		Customer c1 = new Customer();
		// in M:stack area
		c1.name = "허미미";
		c1.email = "blac@blahl.com";
		System.out.println(c1.name + " , " + c1.email);
		// in M:heap area

		Customer c2 = new Customer();
		c2.name = "고캬악";
		c2.email = "meow@cats.com";
		System.out.println(c2.name + " , " + c2.email);

		Customer c3 = new Customer();
		c3.name = "Bwaaa";
		c3.email = "nununu@mail.com";
		System.out.println(c3.name + " , " + c3.email);
		// alt+arrow = 줄단위로 이동시키기

		Customer c4 = c3;
		c4.name = "잡스";
		System.out.println(c4.name + " , " + c4.email);
		System.out.println(c3.name + " , " + c3.email);
		
		Customer c5 = new Customer();
		c2.name = "고캬악";
		c2.email = "meow@cats.com";
		System.out.println(c2==c5);
		System.out.println(c3==c4);

		// c1.interestRate = 10.2;
		// 보통 static은 클래스 이름으로 접근.reference variable을통 해서도 접근이 가능은 하지만 왠만하면.
		Customer.interestRate = 10.2;
		System.out.println(Customer.interestRate);
		// Customer.BANKNAME = "허버"; final이라 수정 안됌,선언문 가서 바꿀 것
		
		
		/*method : static이 들어가면 default 인스턴스와 달리 각 개체별이 아닌 클래스 공유
		final : 오버 라이딩 금지,더이상 재정의 불가
		abstract : no body,기능이 없다.할수없기에 자식 메소드에서 해서 쓰라고.
		synchronized: thread 에서 나옴
		*/

	}

}
