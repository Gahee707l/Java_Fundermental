package java_20191204;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketScanDemo {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		for(int i =0;i<65536;i++){
			//나를 서버로 만든다는 것이며 포트를 열어달라는 의미.
			//누군가 사용중이면 당연히 못 쓴다.
			
			try {
				serverSocket = new ServerSocket(i);
				//이 서버의 port번호만 사용 사능하면 객체 생성.
				//그렇지 않으면 예외 발생 = 해당 port 사용중
				//System.out.println(i+"번호를 사용 할 수 있습니다.");
			} catch (IOException e) {
				System.err.println(i+"번호를 사용 할 수 없습니다.");
			}
		}

	}

}
