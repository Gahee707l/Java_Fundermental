package java_20191129;

public class TryCatchDemo {

	public static double getAvg(int k, int e) {
		int sum = k+e;
		double avg = (double)sum/(double)2;
		return avg;
	}

	public static void main(String[] args) {
		try{
		int k = Integer.parseInt(args[0]);
		int e = Integer.parseInt(args[1]);
		double average = getAvg(k, e);
		//따로 try에 int선언들만 넣으면 인지 못함

		System.out.printf("평균 : %.2f", average);
		}catch(NumberFormatException e){
			//e.printStackTrace();
			//개발 초기엔 이걸로
			//System.out.println(e.getMessage());
			//trace뒤에 같이 붙어있음
			System.err.println("Error : 숫자를 입력하시오");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error : 국어와 영어 점수를 입력하시오");
		}
		
		//throws는 자신을 호출한 쪽에서 해결하게 한다.계속 던져서 최종적으로 호출한 main으로 오면 프로그램이 종료된다.
		//보통은...그냥 던짐.
		//기본적으로 가장 처음 호출한(보통 메인)쪽에서만할것.찾아보기가 어렵다. 
		
	}

}
