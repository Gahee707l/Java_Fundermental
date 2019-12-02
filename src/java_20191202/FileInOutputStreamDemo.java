package java_20191202;
//read() = 읽은 값 하나씩 전달받음(return)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//output = 받은 1개씩 받아옴
//read(byte b[]) =읽은 값은 b[]로,리턴은 어레이 길이(ex:100)

public class FileInOutputStreamDemo {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 여기서 부터
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\jdk.exe");
			// 소스
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\jdk-2.exe");
			// 데스티네이션
			int readByte = 0;

			/*
			 * byte[] readBytes = new byte[단위]; //읽어서 저장할 공간 int
			 * readByteCount=0; //현재 읽어온 양 (!) read(readBytes)는 읽은 바이트 수를 반환하기
			 * 때문. 배열
			 * 
			 * while((readByteCount=fis.read(readBytes)) != -1){ // 꺼내온 갯수가 -1이지
			 * 않은 이상,즉 fis가 복사해 온게 있는 이상... // 집어넣을,꺼내왔다는 갯수 = 실제 꺼내온 갯수 (가 있기는
			 * 하냐 묻는 구문. // 끝이면 read(바이트수)가 -1을 리턴한다.즉 != false)
			 * 
			 * fos.write(readBytes,0,readByteCount) // fos에 fis가 가져다 놓은
			 * readBytes에서 0부터 가져온 만큼 가져온다.
			 * 
			 * }
			 */

			// while ((readByte = fis.read()) != -1) {
			//// fos.write(); 한 바이트 쓰기
			// fos.write(readByte);
			// }
			// 여기까지가 사실상 핵심

			byte[] readBytes = new byte[1024 * 2];
			int readByteCount = 0;
			// fis.read(readBytes) : 1024바이트씩 읽어 read byte에 저장,읽은 바이트 수 반환
			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
				// readBytes 바이트 배열에 있는 데이터를 출력하되,처음(0)부터 ,readByteCount 만큼 출력
			}

			long end = System.currentTimeMillis();
			System.out.printf("경과시간 %d ", end - start);

			/*
			 * while(( readByteCount=fis.read(readBytes)) != -1){
			 * fos.write(readBytes,0,readByteCount);
			 * while((readByte=fis.read())!= -1) //이건 개별 검사,이번에 끄집어 온게 -1(종료)값이
			 * 아닌동안 { fos.write(readByte);//읽어온거 넣기. } }
			 */

		} /*
			 * catch (FileNotFoundException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */ catch (IOException e) {
			// 대신 이렇게 하면 정확한 메세지 잡기 어려움
			e.printStackTrace();
		} finally {
			// 에러가 나건 안나건 수행
			//
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
