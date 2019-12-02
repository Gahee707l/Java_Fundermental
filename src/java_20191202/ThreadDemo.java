package java_20191202;
//웹에선 필요없지만 개념 배우기용 : 라이프 사이클과 스타트 방법은 알아야함
// 주로 게임(유닛)에서만 쓰인다...

// 1)extends thread,Thread에서 *원하는 내용으로 오버라이딩한*run()호출
//그 이후 해당 객체(&) 생성,start 로 메서드 호출
// 2)impleents runnerble,thread 생성>..
// 결국은 thread(예측불가여서 어려움) 호출
// new 하고 start하면 하나 뺴고 전부 대기(runnable),하나씩만 running된다.
public class ThreadDemo extends Thread {

	public ThreadDemo(String threadName) {
		//&
		super(threadName);
	}

	public void run() {
		//끝나야 thread가 죽음
		for(int i=0;i<1000;i++){
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d\n",threadName,i);
		}

	}

	public static void main(String[] args) {
		System.out.println("**********start**********");
		ThreadDemo t1 = new ThreadDemo("fir");
		t1.start();
		//여기서 바로 run()호출시 일반 메소드처럼 취급되어 main thread에서 호출된다

		ThreadDemo t2 = new ThreadDemo("sec");
		t2.start();
		//둘이 제어권을 번갈아 가면서 넘겨 실행되지만 쓰레드 스케쥴러의 그 기준등이 예측불가 : 서로 어디까지 하고 토스하는지 알 수 없음
		System.out.println("**********END**********");
		//new ThreadDemo("thr").run();

	}

}
