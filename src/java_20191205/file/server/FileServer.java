package java_20191205.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private int port;

	public FileServer(int port) {
		this.port = port;
	}

	public void run() {
		ServerSocket serverSocket = null;
		FileServerThread fst = null;

		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				System.out.println("클라이언트 접속 대기중 ...");
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트 접속");

				fst = new FileServerThread(socket);
				Thread t = new Thread(fst);
				t.start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// unicast,파일이 다른 클라이언트들에게 가면 안돼니까.
	public static void main(String[] args) {
		new FileServer(3033).run();
		//			port

	}

}
