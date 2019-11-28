package java_20191128;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		// 가변이기에,cbr(콜바이레퍼런스)가 먹힌다.
		// 처음엔 16공간,부족해지면 2배씩 증가.
		StringBuffer s2 = new StringBuffer("test");
		// equals 오버라이딩을 안했기 때문에,object의 equals를 사용하기에 비교 불가.문자열 추가가 목적.
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		// to String은 오버라이딩이 되어있다.
		System.out.println(s1);

		String s3 = s1.toString();
		String s4 = s2.toString();
		// 그래서 스트링으로 전환 필요
		System.out.println(s3.equals(s4));

		StringBuffer sql = new StringBuffer();
		sql.append("select name, age ");
		sql.append("from member ");
		sql.append("where name = '성영한' ");
		sql.append("odere be name desc ");
		// 객체가 하나만 만들어져 있다.

		System.out.println(sql);

		// buffer의 set length(0);로 싹 지우고 append하는 일이 더 많다.
		sql.setLength(0);

		sql.append("select writer, no ");
		sql.append("from board ");
		System.out.println(sql);
		
		//***collection***=sql의 결과값 저장
		//프리미티브는 바로 못합,래퍼 클래스로 저장
		//(thread)/io/network(중요는 안데 웹프에선...io+jdbc)/jdbc를 위해 배워왔다...
		//set = equals 오버라이딩된것들만 넣어주며 비교시 같다라는 것은 더 넣지 않는다.그리고 소형임
		//이터레이터(나 이뉴머레이션)으로 뽑아오기 가능
		//ex) 구름주머니
		//map = key와 value,add가 아닌 put(key,value)로 넣는다.key값만 있으면 다 꺼내오지만,유일한 값이어야 한다.
		//중복가능,대량의 데이터에 좋지만 "unique"key값이 필요.중복 key는 덮어씌워진다.
		//List,set : interface.실구현은 ppt7참고.vector...
	}

}
