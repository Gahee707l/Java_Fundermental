package java_20191126.step2;

public class StopWatchDemo {

	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		s.start();
		
		for (long i = 0; i < 50000000000l; i++) {

		}
		s.stop();
		double elasedTime = s.getElasedNanoTime();
		System.out.printf("경과시간 : %.9f", elasedTime);

	}

}
