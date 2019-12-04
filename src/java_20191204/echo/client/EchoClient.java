package java_20191204.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private String ip;
	private int port;

	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			socket = new Socket(ip, port);
			// 3.소켓 객체 생성 4.서버와 연결
			// 6.소켓으로 출력 스트림 생성

			out = socket.getOutputStream();
			// 1byte로 한글 안녕하세요가 힘드니...outputstreamWriter로해야함.
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			bw.write("안녕하세요-223");
			// 개행 없으면 인식 못함...flush도 잊지 말것.
			bw.newLine();
			bw.flush();

			// 9. 소켓으로 입력 스트림 생성
			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (out != null)out.close();
					if (osw != null)osw.close();
					if (bw != null)bw.close();
					if (in != null)in.close();
					if (isr != null)isr.close();
					if (br != null)br.close();
					if (socket != null)socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}

		// 연결 소겟의 끝....
	}

	public static void main(String[] args) {
		new EchoClient("192.168.0.223", 3000).run();
		// 223이다,잘못봤었음...
		// .203
	}

}
