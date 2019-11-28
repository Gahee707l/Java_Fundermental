package java_20191128;

public class StringDemo {

	public static void main(String[] args) {
		// String str = "abcdefg";
		String str = "111111-1111118";

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		str = str.concat("abcf");// = str+="abcf";
		// +와 똑같다.
		System.out.println(str);

		String fileName = "abc.zip";
		if (fileName.endsWith("zip")) {
			// 파일 확장자로 구분할때 유용
			System.out.println("zip file");
		} else if (fileName.endsWith("ppt")) {
			System.out.println("ppt file");
		}

		String url = "artists/index.jsp";
		if (url.startsWith("artist")) {
			System.out.println("artist page");
		} else if (url.startsWith("exhibition")) {
			System.out.println("exhibition page");
		}

		// equalsignorecase = 대소문자구분 무시 비쇼
		System.out.println("abc".equalsIgnoreCase("aBC"));

		String s1 = "a";
		String s2 = "성";
		System.out.println(s1.getBytes().length + " " + s2.getBytes().length);
		// byte별로 구하기(바이트 크기)

		System.out.println(str.indexOf("-"));
		// 확정자 찾기
		fileName = "abc.bde.fafb.asdf.ppt";
		System.out.println(fileName.lastIndexOf("."));
		// 뽑아내기,인자 1: 인자부터 끝까지|인자2 : 인자부터 인자까지
		String first = str.substring(0, str.indexOf("-"));
		// String first =str.substring(0, 6);
		// 첫 인자는 포함,두번쨰 인자는 포함하지 않는다.
		String second = str.substring(str.indexOf("-") + 1);
		System.out.println(first + " " + second);

		// regex=regular expression(정규표현식...일종의 공식이나 패턴/표현식 정의 ex)\d = 숫자)
		String content = "abc\nabc\nabc\nabc\nabc";
		content = content.replaceAll("\n", "<br>");
		//						바꾸고싶은 문구,바뀔 문구
		System.out.println(content);
		//					java.lang.String@hashcode
		//						오버라이딩
		//						.toString()이 생략됨
		
		s1="abc";
		s2="abc ";
		//length로는 잡아볼 수 있다...실수 종종 있음
		System.out.println(s1.trim().equals(s2.trim()));
		//앞뒤 공백 지우기 trim | 중간 공백은 아니고 공백만 지움
		
		s1 = String.valueOf(100);// = 100+""
		//value of = 프리미티브 타입을 문자열로 전환 = 1+"";(대부분이 이렇게함)
		System.out.println(s1);
		
		String phone = "010-3024-1703";
		//-(구분자)를 기준으로 문자열 쪼개기(토큰으로),문자열배열로 리턴
		//delimiter로 token을 만든다
		String[] temp = phone.split("-");
		for (String string : temp) {
			System.out.println(string);
		}
		//format과 printf 비슷
		str = String.format("%3$,10d %2$,10.2f %1$,10f",
				10000.234,20000.123,300000);
		//					3$=인덱스,3번쨰것이 번저 들어옴,결과는 String으로 나옴
		//			flag > 인덱스 다음,숫자 형식 지정
		//				width : 플래그 다음,빈공간...형식 맞추기
		System.out.println(str);
					//		%conversion
		
		System.out.printf("%d%n",100);
		System.out.format("%d%n",100);
	}
	

}
