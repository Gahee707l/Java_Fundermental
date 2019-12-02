package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	//바이너리 이동상으론 필요함.
	// 모니터랑 연결 | 파일이랑 연결 | ...
	// sysout(요out도 이거stream랑 연결) | printstream:잘 안쓰지만 auto flush있음.오류는...bis아니고
	// fis여도 안나는데...그렇게는...
	// stream chaining : FI/O | BI/O 무얼로 하느냐에따라 시간 차이 남
	// 잘 안쓰지만 교육 차원상....

	public static void main(String[] args) {
		PrintStream ps1 = System.out;//Dest = monitor출력장치 (와 연결) |new ~ : 파일에 출렷
		ps1.println("Hello World");
		//이 일들을 sysout println으로 한것임
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {fis = new FileInputStream("C:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\pdf_copy.zip");
			bos = new BufferedOutputStream(fos);
			
			ps1 = new PrintStream(bos,true);//dest = file

			int readBtCount = 0;
			
			while((readBtCount = bis.read()) != -1){
			ps1.write(readBtCount);
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 에러가 나건 안나건 수행
			try {
				if(ps1 != null){
					//먼저 닫지 않으면 오류남.
					ps1.close();
				}
				//닫는...순서도 있음...연 순서 반대대로.파일은 버퍼 내 에있으니까. 먼저 닫아도 가능은 하지만.
				if (fis != null)
					//null인데 close하면 오류남...아예 열리지 않았을때 전부 null이라 객체가 없으니까.
					fis.close();
				if (bis != null)
					bis.close();
				if (fos != null)
					fos.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
