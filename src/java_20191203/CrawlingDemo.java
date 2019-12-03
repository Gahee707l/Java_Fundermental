package java_20191203;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {

	public static void main(String[] args) {
		/*
		 * //String url = "http://www.imbc.com/";
		 * 
		 * Document doc = null; //다움 받은 jsoup의 것 //html 문서 전체를 관리하기 위한 객체
		 * 
		 * try { doc = Jsoup.connect(url).get(); //크롤링을 자주하면 큰 사이트에서 보통 ip
		 * 차단함... //문서에 연결 System.out.println("성공"); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * Elements elements = doc.select(".con-wrap.notice-wrap"); // css 표기법
		 * .은 클래스 Elements titleElements = elements.select("h3"); // 뽑는 기준
		 * String noticeTitle = titleElements.text(); //단계씩 내려옴
		 * System.out.println(noticeTitle);
		 * 
		 * Elements liElements =elements.select(".notice-list ul li"); // 클래스
		 * notice-list 밑의 ul 밑의 li(얘네는 태그),한번에 여러개가 들어갔으니 for로 꺼내야함
		 * 
		 * for(int i =0;i<liElements.size();i++){ Element liElement =
		 * liElements.get(i); String text = liElement.text(); //따로 더 찾지 말고 그냥
		 * 가져오면 된다. System.out.println(text); }
		 */
		/*
		 String url = "https://sports.news.naver.com/index.nhn"; Document doc
		= null; try { doc = Jsoup.connect(url).get();
		 System.out.println("성공");
		 
		 } catch (IOException e) { e.printStackTrace(); } //Elements elements
		 // = doc.select("#news_category_contents_2_0"); //여기선 id 로 따올것.. id는 #
		 Elements elements = doc.select(".main_article_box.division");
		 Elements titleElements = elements.select("ul li");
		 for(int i =0;i<titleElements.size();i++)
		 { Element titleElement =titleElements.get(i);
		 String text = titleElement.text();
		  System.out.println(text); }
		 
		//하이퍼링크와 내용까지...//이건 걍 나중에 보고 참조할것
		Element liElement = liElements.get(i);
		String href = liElement.select("a").attr("abs:href");
		//abs = absolute,앞에 주소까지 전부 더하기
			doc2 = Jsoup.connect(href).get();
			//try catch...
		Element list 
		*/
/*
		String url = "https://m.sports.naver.com/";
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			System.out.println("성공");

		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = doc.select(".newslst_grid_bx");
		Elements tweetElements = elements.select(".txt_area title");
		//비동기로..ajax...라서...안가져와지는 거임...로딩이 끝나고 가져오는거라서
		for (int i = 0; i < tweetElements.size(); i++) {
			Element tweetElement = tweetElements.get(i);
			String text = tweetElement.text();
			System.out.println(text);
		}*/
		
		/*
		String url = "https://twitter.com/wonsoonpark";
		
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			System.out.println("성공");

		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = doc.select(".stream ol li");
		Elements tweetElements = elements.select(".js-tweet-text-container");
		for (int i = 0; i < tweetElements.size(); i++) {
			Element tweetElement = tweetElements.get(i);
			String text = tweetElement.text();
			System.out.println(text);
		}*/
	}

}
