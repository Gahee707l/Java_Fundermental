package java_20191122.aa;

public class Notice {
	// 컴파일시 src말고도 bin에도 그렇게 들어가있다

	public int number;
	protected String title;
	int hit;
	private String regdate;
	// 멤버변수의 유효 범위는 순차적 실행에 관계가 없다.

	public static void main(String[] args) {
		Notice n = new Notice();
		// 한 클래스 내부에서는 OK

		n.number = 10;
		n.title = "Over the garden wall";
		n.hit = 100;
		n.regdate = "2019-11-22";
		// 멤버변수의 접근 권한 확인

		// 여기까지 1차 쪽지시험

		/*
		 * 과제1
		 * 
		 * 문자 reverse
		 * 
		 * String i1 = "abcd"; String i1 = "abcde"; char[] ch =
		 * i1.toCharArray();
		 * 
		 * swap을 쓸것이다...짝수면 제일끝과 시작,하나씩 안으로... i1은 for문 2번만 돌면 됨. 홀수는 중간거 고정이니까
		 * 여전히 2번임. => lenth/2로 쓸것
		 * 
		 * 과제2
		 * 
		 * 1:100 소수 구하시오 => 출력해라
		 * 
		 * for(i=2;i<=100;i++){
		 * 
		 * 
		 * for(j=i;j>=2;j--){ if(&&())//남은 나머지가 하나라도 있으면??아무튼 나눠지는애가 하나라도 있으면
		 * 나와라 //일단 짝수 거르기...?
		 * 
		 * if((!(i==2)) && i%j==0) break;
		 * 
		 * }
		 * 
		 * (2까지 다 걸러졌는데 남은거면 자기 자신 만이 나눠지는 것이기 때문에....아직 for 내부라는걸 잊지 말것 !)
		 * if(i=j) println; }
		 * 
		 */
	}

}
