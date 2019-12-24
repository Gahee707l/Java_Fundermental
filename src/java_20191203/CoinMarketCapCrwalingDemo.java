package java_20191203;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoinMarketCapCrwalingDemo {
	//1시간에 한번씩 하려면....쓰레드....

	public static void main(String[] args) {
		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20171101&end=20191203";
		//너무 많으면 트래픽이 늘어나니까 ip 막음

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		Document doc = null;
		
		System.out.println("Date\tOpen\tHigh\tLow\tClose\tVolume\tCap");

		try {
			doc = Jsoup.connect(url).get();
			Elements elements = doc.select(".cmc-table__table-wrapper-outer table tbody tr");
			fw = new FileWriter("C:\\dev\\io\\2019\\12\\crawling.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			pw.println("Date\t\tOpen\t\tHigh\t\tLow\t\tClose\t\tVolume\t\tCap");

			for (int i = 0; i < elements.size(); i++) {
				Element trElement = elements.get(i);
				
				String date = trElement.child(0).text(); // text() //child
				// 0번째 1,2,3...으로 가져올 수 있음.
				String open = trElement.child(1).text();
				String high = trElement.child(2).text();
				String low = trElement.child(3).text();
				String close = trElement.child(4).text();
				String volume = trElement.child(5).text();
				String cap = trElement.child(6).text();

				//System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%n", date, open, high, low, close, volume, cap);

				
				// 나중에 엑셀에 붙일때 개별로 안들어감.
				// 이거 말고 형식에 맞춰서...\t 넣어가며 하기.
				String format =String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%n",date,open,high,low,close,volume,cap);
				//pw.println(trElement.text());
				pw.print(format);
				//이미 완성된 string 가져오기
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
		}
		//net 통신은 이제 안하고 web만 하긴 하지만...
		//java가 tcp/ip용으로 사실 나온거라고....
	}
	/*
	switch (month) {
	case "Dec":
		month = "12";
		break;
	case "Nov":
		month = "11";
		break;
	case "Oct":
		month = "10";
		break;
	case "Sep":
		month = "09";
		break;
	case "Aug":
		month = "08";
		break;
	case "Jul":
		month = "07";
		break;
	case "Jun":
		month = "06";
		break;
	case "May":
		month = "05";
		break;
	case "Apr":
		month = "04";
		break;
	case "Mar":
		month = "03";
		break;
	case "Feb":
		month = "02";
		break;
	case "Jan":
		month = "01";
		break;
	}*/

}
