package java_20191205.file.client;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {
	private String ip;
	private int port;

	public FileClient(String ip, int port) {
		// TODO Auto-generated constructor stub
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		try {
			Socket socket = new Socket(ip, port);
			//String fileName = "mariadb.pdf";
			String fileName = "jdk.exe";

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(fileName);
			bw.newLine();
			bw.flush();

			InputStream is = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream("C:\\dev\\io\\" + fileName);
			byte[] readBytes = new byte[1024 * 8];
			int readByteCount = 0;

			while ((readByteCount = is.read(readBytes)) != -1) {
				fos.write(readBytes,0,readByteCount);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}

	public static void main(String[] args) {
		new FileClient("192.168.0.203",3033).run();
	}

}
