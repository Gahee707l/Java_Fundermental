package java_20191119;

public class LiteralDemo {
	public static void main(String[] args){
		/*overflow 발생 예시
		byte b1 = 128;
	*/
		int a1 = 128;
		int a2 = 076;
		int a3 = 0x123;
		int a4 = 0b10101;
		
		System.out.println(a1+"\n"+a2+"\n"+a3+"\n"+a4);
		
		long l1 = 2200000l;
		float f1 = 123.43f;
		double d1 = 1234.56;
		boolean isExisted = false;
		
		a1 = 10;
		d1=10.0;
		System.out.println(a1==d1);
		//값만 비교 하고,타입을 묻는게 아님.그냥 비교해도 된다.
		
		int first = 10;
		int second = first;
		first = 20;
		//참조형이 아닌걸 보여줌.
		System.out.println(first+" "+second);
		
	}
}
