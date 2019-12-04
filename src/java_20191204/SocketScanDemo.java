package java_20191204;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketScanDemo {

	public static void main(String[] args) {
		//new socket이 성공했다는 것은,port가 열려있다는 뜻이다...소통 가능.
		//오류가 나면 닫혀있단 것이니 당황은 하지 말것.
		//참고 : 느...림....

		Socket socket = null;
		for(int i =49441;i<=51000;i++){
			//소켓 객체 생성 성공 = 헤당 호스트(server),port로 총신 가능
			//즉,이미 해당 포트를 사용하고 있다는 뜻이다.
			//22,80,443(https protocol)은 보통 열려있음
			
			//법적 금지 사항이니,지정 사이트 외에는 시도하지 말것.
			try {
				//socket = new Socket("13.209.180.253",i);
				socket = new Socket("192.168.0.233",i);
				//해당 컴,로컬은 serverport로 하면 빠름
				System.out.println(i+"번호 사용중");
			} catch (UnknownHostException e) {
				System.err.println("호스트 비존 재");
				//우리 프로그램들은 종료되면 안됀다,계속 스캔해야 하니까.
			} catch (IOException e) {
				System.err.println(i+"번호 비사용,방화벽 설치됨");
			}
			
		}
	}

}
