package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class naverScanningDemo {

	public static void main(String[] args) throws IOException {
		// malformed도 io에 포함되어서 다 보냄
		URL url = new URL("https://www.naver.com/");
		InputStream in = url.openStream();
		// Inputstream으로 반환,1byte를 1byte로...url 의 html 소스(자원)주욱 당겨오는게 openstream
		
		//1.InputStream > InputStreamReader로 스트링 체이닝
		//2.InputStreamReader >BufferedReader로 스트링 체이닝
		//3.BufferedReader로 읽은걸(html) C:\dev\io\2019\12\naver.html 파일로 저장
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		isr = new InputStreamReader(in);
		br = new BufferedReader(isr);
		//br에 isr이 연결된 상황
		fw = new FileWriter("C:\\dev\\io\\2019\\12\\naver.html");
		bw = new BufferedWriter(fw);
		//printReader비사용이라 개행,자동 플러시 없음
		//추가시 : pw = new PrintWriter(bw,true);
		
		String readLine = null;
		
		while((readLine = br.readLine())!=null){
			//추가시 : pw.println(readLine);
			bw.write(readLine);
			bw.newLine();
		}
		bw.flush();
		
		
		if (in != null)
			in.close();
		if (br != null)
			br.close();
		if (bw != null)
			bw.close();
		if (fw != null)
			fw.close();

	}

}
