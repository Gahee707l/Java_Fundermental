package java_20191204.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private int port;

	public EchoServer(int port) {
		this.port = port;
	}
	
	//CSprogramming의 흐름은 외워둘것.

	public void run() {
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			// 1.서버소켓 객체 생성
			while (true) {
				System.out.println("클라이언트의 접속을 기다리고 있습니다.");
				//2.서버소켓으로 클라이언트 접속 대기
				Socket socket = serverSocket.accept();
				//inetadress로 호스트 어드레스 알아낼 수 있음.
				System.out.println("클라이언트가 접속했습니다. ip"+socket.getInetAddress().getHostAddress());
				
				//5.클라이언트와 통신할 수 있는 소켓 객체 반환 >> 5.
				
				//소켓통신의 문제점
				//여기서부터 사실상 io.하지만 반복문을 쓰면 다른 클라이언트의 접속을 기다릴 수 없다...Thread생성해서 거기서 while 돌리는게 필요.
				
				//7.소켓으로 입력스트림 생성
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				br = new BufferedReader(isr);
				String readLine = br.readLine();
				
				System.out.println(readLine);
				
				//8.소켓으로 출력 스트림 생성
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out);
				bw = new BufferedWriter(osw);
				bw.write(readLine);
				bw.newLine();
				bw.flush();
				//한바퀴 돌고,받은거 되돌려주고(echo) 다른 클라이언트 기다리기...

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		//이...finally분은 그냥 하지 말구...catch내부니까 ....server가 끝나면 어차피 끝나서 io에러가 안남.
			//다시 키는거아니면 뭐....
			try {
				if (bw != null)bw.close();
				if (br != null)br.close();
				//if (serverSocket != null)serverSocket.close();
				//
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	public static void main(String[] args) {
		new EchoServer(3000).run();
		//이렇게 실행해서 띄워놔야 함...스레드부터 만들어야지........
	}
}
