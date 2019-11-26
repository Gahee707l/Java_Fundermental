package java_20191126.step5;

public class StopNanoWatch extends StopWatch {

	private void start() {
		startTime = System.nanoTime();
	}

	private void stop() {
		endTime = System.nanoTime();
	}

	private double getElasedTime() {
		return (double) (endTime - startTime) / (double)1000000000;
	}
	
	public void run(){
		start();

		for (long i = 0; i < 5000000000l; i++) {
			//이 0 갯수가...틀렸었음...

		}
		
		stop();
		double elasedTime = getElasedTime();
		System.out.printf("경과시간 : %.9f", elasedTime);
	}

}
