package java_20191126.step2;

public class StopWatch {
	long startTime;
	long endTime;

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}

	public double getElasedMilliTime() {
		return (double) (endTime - startTime) / 1000;
	}

	long startNanoTime;
	long endNanoTime;

	public void startNano() {
		startNanoTime = System.nanoTime();
	}

	public void stopNano() {
		endNanoTime = System.nanoTime();
	}

	public double getElasedNanoTime() {
		return (double) (endNanoTime - startNanoTime) / (double)1000000000;
	}

}
