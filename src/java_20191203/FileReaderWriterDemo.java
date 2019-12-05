package java_20191203;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
	// 이제부터 2바이트... = 한 문자,한글 안깨짐
	// read는 stream 과 비슷
	// BufferedReader : 스트링 체이닝,한줄 읽기 가능
	// buffered/output(File)/print writer
	// 얘는 1,2바이트 전부 쓸 수 있음.
	//1바이트에도 문자는 있는데...괜히 힘든것이니 2바이트로 한번에 하는게 나음.
	public static void main(String[] args) {
		FileReader fr = null;
		
		FileWriter fw = null;

		try {
			fr = new FileReader("C:\\dev\\io\\2019\\12\\test.txt");
			fw = new FileWriter("C:\\dev\\io\\2019\\12\\test_copy.txt");
			//나중에...					,csn에 UTF-8 추가하면 한글 안꺠짐

			/*
			 /** :이건 자바 다큐먼테이션 주석
			int readChar = 0;
			//캐릭터 하나하나 옮기는 방식
			while ((readChar = fr.read()) != -1) {
				
				System.out.print((char) readChar);
				fw.write(readChar);
				// 하나를 두곳에 출력
			}*/
			//ctrl shift + / | ctrl shift + |
			
			char[] readChars = new char[100];
			//							1024*n
			int readCharCount = 0;
			while((readCharCount = fr.read(readChars)) != -1){
				//System.out.print(new String(readChars,0,readCharCount));
				
				//char배열을 string으로 생성시켜줌...그리고 그냥 readChars만 하면 문제 생김...
				//지난줄까지 가져왔던 이미 채워졌던 곳이 똑같이 참조되기 때문.8칸인데 마지막줄에 2개만 써있었을 경우 같은.
				//너무 넘치면 남은 만큼 공백 붙음.
				
				fw.write(readChars,0,readCharCount);
//				fw.write(new String(readChars,0,readCharCount));
				
				//문자열 넣기 가능,잘 쓰지는 않음....
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
