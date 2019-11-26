package java_20191126.step5;

public class StopWatchDemo {

	public static void execute(StopWatch s) {
		s.run();
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*
		 * StopNanoWatch s1 = new StopNanoWatch(); execute(s1);
		 * 
		 * StopMilliWatch s2 = new StopMilliWatch(); execute(s2);
		 * 
		 * StopMicroWatch s3 = new StopMicroWatch(); execute(s3);
		 */

		// String input = "java_20191126.step5.StopMilliWatch";
		String input = args[0];
		
		input = "java_20191126.step5." + input;
		
		StopWatch s1 =(StopWatch)Class.forName(input).newInstance();
		// config args로는 string이 들어온다,그걸로 각자 실행 시킬것임.
		//StopWatch s1 = new StopNanoWatch();
		execute(s1);

	}

}
