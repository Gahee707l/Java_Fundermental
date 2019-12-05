package java_20191205.multicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
//브로드 캐스트는...다중을 어레이에 넣어두고 하나씩 꺼내며 전부 줘야함.
public class MulticastServer {
	//쓰레드 필요

	//unicast : Thread를 이용해 지속적 연결
	// 하지만 각 연결과 내용은 서로만 본다,브로드캐스트와 다름.서버가 부담이 크다.]
	private int port;
	private ArrayList<MulticastServerThread> list;
	
	public MulticastServer(int port){
		this.port = port;
		list = new ArrayList<MulticastServerThread>();
	}
	
	public void run(){
		ServerSocket serverSocket = null;
		MulticastServerThread ust = null;
		
		try {
			serverSocket=new ServerSocket(port);
			
			while(true){
			System.out.println("WAITING FOR APPROACH...");
			Socket socket = serverSocket.accept();
			System.out.println("Client IP : "+socket.getInetAddress().getHostAddress());
			
			ust = new MulticastServerThread(socket,list);
			list.add(ust);
			//서버에서 관리해줘야한다.나가면 rm해야함
			System.out.println("클라이언트 접속 수  : "+list.size());
			
			
			//			이 객체자체를 thread 상속으로 만들면 바로 ust.start 가능함.
			Thread t = new Thread(ust);
			//			implements Runable해야함...runnable 객체만 받아서 생성해줌
			//		생성 방법은 알아둘것... api에도 나와있음.
			t.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new MulticastServer(3000).run();
	}

}
