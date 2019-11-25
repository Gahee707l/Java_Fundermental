package java_20191125;

public class MemberDemo {

	public static void main(String[] args) {
		Member m = new Member();
		//ctrl + 클릭 = 해당 클래스 파일 오픈
		//m.name = "mwa";
		m.setName("문재인");
		m.setZipcode("12390");
		m.setAddress1("서울");
		m.setAddress2("청와대");
		m.setEmail("president@bluehouse.go.kr");
		m.setSsn("123123-1231231");
		m.setAge(60);
		m.setPassword("123");
		m.setHeight(176.2);
		
		System.out.println(m.getName());
		System.out.println(m.getZipcode());
		System.out.println(m.getAddress1());
		System.out.println(m.getAddress2());
		System.out.println(m.getEmail());
		System.out.println(m.getSsn());
		System.out.println(m.getAge());
		System.out.println(m.getHeight());

	}

}
