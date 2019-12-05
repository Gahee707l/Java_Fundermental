package java_20191205.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

//파일 명을 찾는 찾는 dir는 고정시켜줄것.
public class FileServerThread implements Runnable {
	

	private Socket socket;

	public FileServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String fileName = br.readLine();
			
			//이제 읽어올땐 포장 안해도...보내줄거니까
			FileInputStream fis = new FileInputStream("C:\\dev\\io\\2019\\12\\"+fileName);
			//													고정		지금 우리 끼린 window니까.
			
			byte[] readBytes = new byte[1024*8];
			//ex) readByte [0] =1;이라는 flag
			int readByteCount = 0;
			OutputStream out = socket.getOutputStream();
			
			while((readByteCount=fis.read(readBytes))!= -1){
				out.write(readBytes,0,readByteCount);
				//ex) 				,1,readBC -1
				//아웃풋 스트림에...파일 인풋 스트림을 넣어준다.
;			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
