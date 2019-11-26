package java_20191126.step4;

public class StopWatchDemo {
	
	public static void execute(StopNanoWatch s){
		
		s.start();

		for (long i = 0; i < 50000000000l; i++) {

		}
		s.stop();
		double elasedTime = s.getElasedTime();
		System.out.printf("경과시간 : %.9f", elasedTime);
	}
public static void execute(StopMilliWatch s){
		
		s.start();

		for (long i = 0; i < 50000000000l; i++) {

		}
		s.stop();
		double elasedTime = s.getElasedTime();
		System.out.printf("경과시간 : %.3f", elasedTime);
	}

	public static void main(String[] args) {
		StopNanoWatch s1 = new StopNanoWatch();
		execute(s1);
		
		StopMilliWatch s2 = new StopMilliWatch();
		execute(s2);
		

	}

}
