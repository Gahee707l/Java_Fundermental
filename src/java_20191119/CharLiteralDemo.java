package java_20191119;

public class CharLiteralDemo {
	public static void main(String[] args){
		// main ctrl+space+enter
		
		// unicode format '\u0000'
		char c1 = '\uC774';
		char c2 = '\uAC00';
		char c3 = '\uD76C';
		
		System.out.println(c1+""+c2+""+c3);
				//ctrl c... enter??
		
		//ascii : 48~57 = 0~9
		//65~90 : A~ ,97~122 = a~
		
		char c4 = 97;
		System.out.println(c4);
		//문자표현
		System.out.println('a'+""+'성'+"\t"+'\\');
		//escape char
		System.out.println("C:\\dev\\\"eclipse\"");
		
	}

}
