package java_20191129;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThrowsDemo {
	public static double getAvg(int[] temp) throws ArrayIndexOutOfBoundsException {
		int sum = 0;
		int k = temp[0];
		int m = temp[1];
		int e = temp[2];
		int h = temp[3];
		sum = k + m + e + h;
		return (double) sum / 4.0;
	}

	public static void main(String[] args) {
		int[] exam = { 10, 20, 30 };
		try {
			double average = getAvg(exam);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("국어 수학 영어 국사,4과목의 점수를 입력하시오.");
		}
		//파일아웃풋 스트림같은 경우 아예 런타임 익셉션이 아니기에 먼저 예외처리 해야함
		
		try {
			//아니면 던지기...파일은 없으면 아예 실행 못하니까.
			FileOutputStream f = new FileOutputStream("C:/dev/");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
