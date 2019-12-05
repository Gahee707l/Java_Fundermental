package java_20191205.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	// interface
	private Socket socket;

	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 준비단계
			boolean isStop=false;
			while (!isStop) {
				// 지속적 통신
					
				String readLine = br.readLine();
				System.out.println(readLine);
				if(readLine.equals("exit")){
					isStop = true;
				}

				bw.write(readLine);
				bw.newLine();
				bw.flush();
				//늘 동일함...이쪽도 끄기전에 메시지.

			}
			System.out.println("클라이언트 정상 종료");
			
		} catch (IOException e) {
			// 정상 종료는 오류없이 보내자.
			System.err.println("클라이언트 비정상 종료");
			//e.printStackTrace();
		}

	}
}
