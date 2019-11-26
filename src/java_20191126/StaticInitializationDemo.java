package java_20191126;
//보통 개발자둘은 개별 유틸 파일들이 있다...jar파일로. 

//알아두면 좋은 자주 볼 상식부문
//i18n=Internationalization
//국제화...한국어>영문
//l10n=Localization
//엘 텐엔,지역화


public class StaticInitializationDemo {
	int age;//instance var
	static String title;//static variable
	
	//생서앚의 접근한정자는 객체 생성과 관련 O
	private StaticInitializationDemo(int age){
		//만약 private이면.....타 클래스에서는 객체 생성이 막힘. new 생성자를 사용,객체 생성을 하지 말라는 의미.
		//1.모든 메소드가 static인 경우(객체 생성이 필요없음)ex)Math,생성자 private.(필요 없어서  안만듬)
		//2.singleton 객체로 만들때 : 객체를 딱 하나만 생성해서 쓸때 (제약 걸기)
		this.age = age;
		System.out.println("constructor");
	}
	
	//모든 객체 공용
	static{
		System.out.println("static block");
		//먼저 메모리에 올림
		title = "모기지론";
	}

	public static void main(String[] args) {
		//사실 객체만 만들 목적이라면 그냥 new 생성자만 치면 된다...보통 그 객체를 조작하려 하기 때문에 저장 객체가 필요한 것.
		new StaticInitializationDemo(10);
		new StaticInitializationDemo(20);
		new StaticInitializationDemo(30);
		
	}

}
