package java_20191126;

import java.lang.*;

public class SubDemo extends Object {

	public SubDemo() {
		//alt+shift+s+c
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//abstract/Interface의 경우 new로 객체생성이 안돼니,
		//Inter(super) name = new sub:일반 클래스로 한다.
		
		//ppt4잘볼것,data type의 오버라이딩이 우선 호출된다. 
		Sub s1 = new Sub();
		s1.makeMoney();
		s1.gotoSchool();
		s1.play("omok");

		s1.money = 10000;
		s1.chicken = "교촌치킨 2마리";

	}
}
