package java_20191205.multicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServerThread implements Runnable {
	// interface
	private Socket socket;
	private ArrayList<MulticastServerThread> list;
	private BufferedWriter bw;

	public MulticastServerThread(Socket socket,ArrayList<MulticastServerThread> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {

		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			boolean isStop=false;
			while (!isStop) {
			
				String readLine = br.readLine();
				System.out.println(readLine);
				if(readLine.equals("exit")){
					//shotdown : ~님이 나갔습니다.전송 안하고 자기 자신에게만 보내는 걸로.
					isStop = true;
					sendMessage(readLine);
				}else {
					//브로드 캐스트
					broadCast(readLine);
				}

			}
			list.remove(this);
			System.out.println("클라이언트 정상 종료");
			
		} catch (IOException e) {
			// 정상 종료는 오류없이 보내자.
			System.err.println("클라이언트 비정상 종료");
			//e.printStackTrace();
		}

	}

	private void broadCast(String message) throws IOException{
		//호출한 곳에서 잡고 있으니 일일히 try chatch 필요 x
		for( MulticastServerThread mst : list){
			//이 리스트엔 자기 자신이 포함되어있다.
			mst.sendMessage(message);
		}
	}
	
	public void sendMessage(String message) throws IOException{
		//호출한 곳에서 잡고 있으니 일일히 try chatch 필요 x
		bw.write(message);
		bw.newLine();
		bw.flush();
		
	}
}
