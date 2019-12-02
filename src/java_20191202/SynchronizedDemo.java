package java_20191202;

public class SynchronizedDemo implements Runnable {

	int x, y;

	@Override
	public void run() {
		// synchronized 메소드 전체
		// synchronized추가, '같은 객체일 경우'한번 제어권을 가지면 넘기지 않음. = 임계영역
		
			//이 블록만 synchronized하는 방법
		for (int i = 0; i < 1000; i++) {
			synchronized (SynchronizedDemo.class) {
				x++;
				// 하나의 객체 공유시,이런곳에서 주도권 뺏길수있다.
				// 인스턴스 변수인 탓도 있다.
				y++;
				String threadName = Thread.currentThread().getName();
				System.out.printf("x : %d , y : %d - %s%n", x, y, threadName);
			}
		}

	}

	public static void main(String[] args) {
		SynchronizedDemo s1 = new SynchronizedDemo();
		SynchronizedDemo s2 = new SynchronizedDemo();

		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		// 2쓰레드지만 객체는 하나로 공유 실험
		// 같은 객체 : 둘이 같은 델레멘트 공유해서. xy=2000 | 다름객체 : 각각 xy=1000

		t1.start();
		t2.start();
		
		//while(true)
		try {
			Thread.sleep(1000);
			//반드시 예외처리 필요
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(s1).start();
		// > 이런 식으로 주기적으로.
	}

}
