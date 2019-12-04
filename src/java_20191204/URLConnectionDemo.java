package java_20191204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {

	public static void main(String[] args) throws IOException {
		// 추상 클래스인 connection이 아니어도 url도 결과페이지는 가져올수 있다.
		//대신 이건 서버 헤더 정보는 얻어 올 수 있음.(scheme 같은...)
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=421&aid=0004340528");
		URLConnection urlcon = url.openConnection();
		
		String cacheControl = urlcon.getHeaderField("cache-control");
		String contentType = urlcon.getHeaderField("content-type");
		String date = urlcon.getHeaderField("date");
		System.out.printf("cc : %s%n",cacheControl);
		System.out.printf("ct : %s%n",contentType);
		System.out.printf("d : %s%n",date);
		//분석할만한 일은 별로...
		
		//http 소스 가져오기도 가능은 함.
		InputStream in = urlcon.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		String readLine = null;
		while((readLine=br.readLine())!= null){
			System.out.println(readLine);
		}
	}

}
