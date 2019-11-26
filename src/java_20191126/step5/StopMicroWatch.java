package java_20191126.step5;

public class StopMicroWatch extends StopWatch {

	private void start() {
		startTime = System.currentTimeMillis();
	}

	private void stop() {
		endTime = System.currentTimeMillis();
	}

	private double getElasedTime() {
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void run() {
		start();

		for (long i = 0; i < 50000000000l; i++) {

		}
		stop();
		double elasedTime = getElasedTime();
		System.out.printf("경과시간 : %.6f", elasedTime);
	}

}
