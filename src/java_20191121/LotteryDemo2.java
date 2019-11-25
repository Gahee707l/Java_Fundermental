package java_20191121;

public class LotteryDemo2 {
	public static void main(String[] args) {
		// 0<= Math.random() <1 ,double

		int[] lotteria = new int[6];
		for (int i = 0; i < lotteria.length; i++) {
			lotteria[i] = 0;
		}

		for (int i = 0; i < lotteria.length; i++) {
			// i++;
			double random = Math.random();
			int t = (int) (random * 45) + 1;
			lotteria[i] = t;
			//위랑 병합 가능

			for (int j = 0; j < i; j++) {
				if (lotteria[i] == lotteria[j]) {
					i--;
					break;

				}
			}

		}

		for (int i : lotteria) {
			System.out.print(i + "\t");
		}

	}

}
