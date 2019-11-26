package java_20191126.step1;

public class FootStopWatch {
	// 1: 요구사항 : 밀리 sec 경과 시간(stopwatch)
	// 2: nano sec로...제발...
	// 우리는 대비용으로 늘 남겨둬야한다.
	long startTime;
	long endTime;

	public double getElasedMilliTime() {
		return (double) (endTime - startTime) / 1000;
	}

	public static void main(String[] args) {
		FootStopWatch f = new FootStopWatch();

		f.startTime = System.currentTimeMillis();
		for (long i = 0; i < 50000000000l; i++) {
			// 왜 바꿔도 인식이 안돼지...

		}

		f.endTime = System.currentTimeMillis();
		// 1970/1/1~지금까지의 시간
		System.out.printf("경과시간 : %.3f", f.getElasedMilliTime());

	}

}
