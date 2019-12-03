package java_20191203;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingThread extends Thread {
	private String fileName;

	public CrawlingThread(String filenName) {
		this.fileName = filenName;
	}

	@Override
	public void run() {
		int count =0;
		while (true) {
			// 크롤링 코드...실행(호출)은 데모가 해줌 이대로면...123 이런식으로 붙어남.
			count ++;
			String name = fileName.substring(0,fileName.lastIndexOf("."));
			String extension = fileName.substring(fileName.lastIndexOf("."));
			//								우리는...이름만 바꾸는 거니까 . 포함이 더 편해서 +1 안함.
			String fileName2 = name+count+extension;
			
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String endDate =sdf.format(c.getTime());
			
			String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20171101&end="+endDate;

			FileWriter fw = null;
			BufferedWriter bw = null;
			PrintWriter pw = null;

			Document doc = null;

			try {
				doc = Jsoup.connect(url).get();
				Elements elements = doc.select(".cmc-table__table-wrapper-outer table tbody tr");
				fw = new FileWriter("C:\\dev\\io\\2019\\12\\"+fileName2);
				//아마도...수정?
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
					String format = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%n", date, open, high, low, close,
							volume, cap);
					pw.print(format);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (pw != null)
					pw.close();
			}
			//메일보내는 문....
			try {
				Thread.sleep(1000*10);
				//Thread.sleep(1000*60*60*24);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//이러면 하루...대신 이름이 매번 겹치니까...
			
		}//end while
		
	}
}
