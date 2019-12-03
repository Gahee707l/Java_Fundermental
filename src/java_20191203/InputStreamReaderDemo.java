package java_20191203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) {
		System.out.print("입력하세요>");

		InputStream in = System.in;// 소스= 키보드
		InputStreamReader isr = null;
		BufferedReader br = null;

		isr = new InputStreamReader(in);
		br = new BufferedReader(isr);

		try {
			String readLine = null;
			while((readLine = br.readLine())!= null){
				//키보드는 대기 ,파일이면 계속 읽기.
				if(readLine.equals("exit"))	break;
				System.out.println(readLine);
				System.out.print("입력하세요>");
			}
			//String readLine = br.readLine();
			// 한번만 할 경우.키보드 입력을 기다리다 엔터 치면 읽음
			//여기에 와서야 입력 기다리고 있다.
			//System.out.println(readLine);
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (in != null)
					in.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
