package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedUnOuntstreamDemo {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\pdf_copy.zip");
			bos = new BufferedOutputStream(fos);
			// String chaining
			/*
			 * int readByte = 0; long start = System.currentTimeMillis();
			 * 
			 * while ((readByte = bis.read()) != -1) { // fis.read()
			 * bos.write(readByte); //안채우면 안보내주니까...소실 데이터있을 수 있음. //그래서
			 * flush필요.
			 * 
			 * //fos.write(readByte); // 1바이트씩. }
			 * 
			 * bos.flush();
			 */

			int readBtCount = 0;
			byte[] readBytes = new byte[1024 * 8];
			// 선언하고 bis/bos 쓰지 말것,둘이 같은 것이다...*8하면 buffer와 같은 사이즈니까.

			long start = System.currentTimeMillis();

			while ((readBtCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readBtCount);
			}

			// 57초쯤

			long end = System.currentTimeMillis();
			System.out.println(end - start);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 에러가 나건 안나건 수행
			try {
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
