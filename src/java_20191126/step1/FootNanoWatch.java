package java_20191126.step1;

//1: 요구사항 : 밀리 sec 경과 시간(stopwatch)
//2: nano sec로...제발...
//우리는 대비용으로 늘 남겨둬야한다.

public class FootNanoWatch {
	long startTime;
	long endTime;

	long startNanoTime;
	long endNanoTime;

	public double getElasedMilliTime() {
		return (double) (endTime - startTime) / 1000;
	}

	public double getElasedNanoTime() {
		return (double) (endNanoTime - startNanoTime) / (double)1000000000;
	}

	public static void main(String[] args) {
		FootNanoWatch f = new FootNanoWatch();

		// f.startTime = System.currentTimeMillis();
		f.startNanoTime = System.nanoTime();
		for (long i = 0; i < 50000000000l; i++) {
			// 왜 바꿔도 인식이 안돼지...

		}

		// f.endTime = System.currentTimeMillis();
		f.endNanoTime = System.nanoTime();

		// 1970/1/1~지금까지의 시간
		System.out.printf("경과시간 : %.9f", f.getElasedNanoTime());
		//1.4nnn으로 떠야 하는게 안뜨고 있음.
	}

}
