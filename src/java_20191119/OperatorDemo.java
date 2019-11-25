package java_20191119;

public class OperatorDemo {
	public static void main(String[] args){
		int a = 7, b = 20;
		int c = 0;
		
		double d = 0;
		
		c= a+b;
		System.out.println(c);
		c= a-b;
		System.out.println(c);
		c= a*b;
		System.out.println(c);
		d= (double)b/a;
		// 사칙연산은 둘중 하나만 해도 자동으로 캐스팅 해줌
		System.out.println(d);
		c= b%a;
		System.out.println(c);
		
		a+=b;
		System.out.println(a);
		
		System.out.println(a);
		System.out.println(a++);
		//주의 : 부정/증감은 나누기 곱보다도 먼저 한다.
		System.out.println(a);
		System.out.println(++a);
		
		boolean isSuccess = false;
		
		isSuccess = a<b;
		System.out.println(isSuccess);
		isSuccess = a<=b;
		System.out.println(isSuccess);
		isSuccess = a>=b;
		System.out.println(isSuccess);
		isSuccess = a==b;
		System.out.println(isSuccess);
		isSuccess = a!=b;
		// 부정 연산이 우선 순위가 높다,논리곱/합도 우선순위는 곱이 먼저.
		System.out.println(isSuccess);
		
		System.out.println(a);
		System.out.println(b);
		isSuccess = (a==b)&&(++a == ++b);
		// !!short circuit이 발생해 증가 안돼어있다.!!
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a);
		System.out.println(b);
		isSuccess = (a>b)||(++a == ++b);
		// !!마찬가지로,앞이 true이기에 short circuit이 발생해 증가 안돼어있다.!!
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("1"+2+3+4+5);
		// 짱 신기....왜냐면 문자열에 +로 잇는 연산자 이기 때문.
		System.out.println("1"+(2+3+4+5));
		System.out.println(1+2+3+4+"5");
		
		//switch 는 reference 비교는 할 수 없다.
	}

}
