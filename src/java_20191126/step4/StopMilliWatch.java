package java_20191126.step4;

public class StopMilliWatch {
	private long startTime;
	private long endTime;

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}

	public double getElasedTime() {
		return (double) (endTime - startTime) / (double)1000;
	}

}
