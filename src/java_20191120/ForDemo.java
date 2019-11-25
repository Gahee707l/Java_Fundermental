package java_20191120;

public class ForDemo {

	public static void main(String[] args) {
		String str = "hello";

		int a1 = 10;
		int a2 = 20;
		double d1 = 12.4567;

		System.out.println(str + " , " + a1 + " " + a2 + " " + d1);
		System.out.printf("%10s , %d %d %.2f %n", str, a1, a2, d1);
		System.out.printf("ah \n");
		// System.out.printf("%10ah");

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				sum += i;
		}

		System.out.println(sum);
		// ctrl+shift+f >> 자동 정렬

		for (int i = 2; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d | ", i, j, i * j);
			}
			System.out.println("");
		}

		for (int i = 9; i > 7; i--) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d | ", i, j, i * j);
			}
			System.out.println("");
		}

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5-i; j++) {
				//		5		>i
				System.out.print("*");
			}

			/*
			 * for (int j = 0; j < i + 1; j++) { System.out.print("*"); }
			 */
			System.out.println("");
		}

	}
}
