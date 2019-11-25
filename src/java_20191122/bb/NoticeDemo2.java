package java_20191122.bb;
import java_20191122.aa.Notice;
//타 패키지에서 import 하려면 public class여야 한다.


public class NoticeDemo2 extends Notice{
	//잊지 말자,public은 한 파일에 한 클래스만 가능하다.

	public static void main(String[] args) {
		Notice n = new Notice();

		n.number = 10;
		//n.title = "Over the garden wall";
		//protected
		//n.hit = 100;
		//default , 같은 패키지 에서만.
		// private 이라 동일 패키지부터 직접 전근 불가능
		// n.regdate = "2019-11-22";
		
		NoticeDemo2 nc2 = new NoticeDemo2();
		//notice class 상속받은 nc2클래스로 생성한 객체이니 protected 접속 가능
		nc2.number = 10;
		nc2.title = "Over the garden wall";

	}

}
