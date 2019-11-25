package java_20191119;
//클래스명과 같은 아이덴티파이어 규칙과 주석 성명
public class IdentifierDemo {
	
	public static void main(String[] args){
	int age=10;
	String name = "hello";
	/*	불가능한 예시들
	-숫자
	 String 1fater = "John";
	 -공백(아이덴티파이어 명에서)
	 String mother Name = ",Michell";\
	 - 예약어
	 String void = "empty";
	 
	 일단은 가능
	 -unicode
	 String 이름 = "뫄뫄";
	 */
	
	System.out.println(name);
	//alt+방향키 > 현재 문장 옮기기
	System.out.println(age);
	// run = ctrl + F11
	//단축 키 설정 : CTRL + SHIFT +L
	// byte 와   short은 연산시 int로 자동 전환...후가공 필요 하지만 메모리 절약 은 가능...근데 필요 없음.
	// 수 뒤에 l 추가 = long/f 추가 = float/double의 변환 형인 .0은 더 작은 float에 안들어가니 주의해 변환
	
	}

}
