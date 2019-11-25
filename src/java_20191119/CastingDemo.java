package java_20191119;

public class CastingDemo {
	public static void main(String[] args){
		//overflow 예시
		//byte b1 = 250;
		
		byte b1 = (byte) 129;	//circuit 발생
		System.out.println(b1);
		
		int i1 = (int) 125.35;// cut
		System.out.println(i1);
		
		double d1 = 124.5f; //auto casting
		
		byte b2 = 10;
		byte b3 = 20;
		//산술연산자는 반환이 int이기 때문에 전체를 바이트로 캐스팅 필요.
		byte b4 = (byte) (b2+b3);
		System.out.println(b4);
		
		//이제 이 언더 스코어가 됌.
		System.out.println(10_000_000);
		//refactoring = 선언 이름 가공
		
		//&& / ||은 short circuit (앞만 보고 뒤의 파라그래프 안봄/뒤만 보고 앞은 안봐도 됨,이렇게 전부 순환할 필요 없이 금방 끝날때),앞에가 true일 때만 보면 되니까.
	}

}
