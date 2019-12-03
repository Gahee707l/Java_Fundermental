package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
	public static void main(String[] args) {
		// 문자 읽고 쓸떄 주로 쓰는 코드
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader("C:\\dev\\io\\2019\\12\\test.txt");
			br = new BufferedReader(fr);// stream chainning
			// 여기에 한줄읽기가 있음

			fw = new FileWriter("C:\\dev\\io\\2019\\12\\test_copy2.txt");
			bw = new BufferedWriter(fw);

			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				// 더이상 읽을게 없다면 null 리턴
				bw.write(readLine);
				//개행이 안됌,'개행 표시' 앞까지를 읽어준다.
				bw.newLine();
				//window = \n |  Linux = \r 로 알아서 넣어줌
				//pw로 한번 더 스트림 체이닝시,println이 있으니까 추가 개행 필요 없음.
			}
			bw.flush();
			//넣어줘야 안전...
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
