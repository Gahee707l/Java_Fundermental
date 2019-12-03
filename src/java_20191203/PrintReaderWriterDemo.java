package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintReaderWriterDemo {
	public static void main(String[] args) {
		//InputStreamReader : 들어오는 1byte를 2byte(문자)로 변환. 대표적 1byte = 키보드
		//비영어권...이니까...api도 좀 다름.
		//system.in 반환값 -> inputstream print에서 변환해서 reader가 다시 조정해줌 
		//...inputstream이 text가 내부에 있다.1byte에서 그냥 다 2byte짜리 inputstreamReader로 변환시켜서 받음.암튼 그렇다함...
		//system.out 반환값 -> printstream
		//network 끼리 주고받는건 io에선 무리,가져는 올 수 있다. 
		
		//파일 쓰는 정도...
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter pw = null;

		try {
			fr = new FileReader("C:\\dev\\io\\2019\\12\\test.txt");
			br = new BufferedReader(fr);// stream chainning
			// 여기에 한줄읽기가 있음

			fw = new FileWriter("C:\\dev\\io\\2019\\12\\test_copy2.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);

			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				
				pw.println(readLine);
			}
			
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
