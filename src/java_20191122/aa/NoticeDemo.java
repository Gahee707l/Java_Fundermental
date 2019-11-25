package java_20191122.aa;

public class NoticeDemo {
	//패키지 끼리만의 상하 관계 와 상속 관계 없음,폴더가 갈리니 완전히 다른 패키지다.

	public static void main(String[] args) {
		Notice n = new Notice();
		
		n.number = 10;
		n.title = "Over the garden wall";
		n.hit =100;
		//private 이라 동일 패키지부터 직접 전근 불가능
		//n.regdate = "2019-11-22";

	}

}
