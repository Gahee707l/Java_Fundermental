package java_20191202;

public class RunnerbleDemo implements Runnable {

	public void run() {
		// 추상 메소드,runnable 에서 반드시 오버 라이딩 필요
		for (int i = 0; i < 1000; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d\n", threadName, i);
		}
	}

	public static void main(String[] args) {
		System.out.println("**********start**********");
		RunnerbleDemo r1 = new RunnerbleDemo();
		Thread t1 = new Thread(r1,"first thread");
		//어쩄거나 쓰레드 객체가 스타트 해줘야...		러너블객체(쓰레드가 될 객체),쓰레드 이름
		//1) 쓰레드 자신이 시작 |2)쓰레드가 될 객체가 시작...??
		t1.start();

		RunnerbleDemo r2 = new RunnerbleDemo();
		Thread t2 = new Thread(r2,"second thread");
		t2.start();
		System.out.println("**********END**********");
	}

}
