package java_20191120;

public class ContinueDemo {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 6)
				continue;
			// continue > 이 아래 부터는 무시하고  돌아가 진행해라.
			sum += i;
		}
		System.out.println(sum);
		//if(ture)	return ;
		//	여기서 종료.

		outter: for (int i = 2; i < 9; i++) {
			// 이름이 지정된 for 문 : break label
			for (int j = 1; j <= 9; j++) {
				if (i == 5)
					continue outter;
				// 많은 일은 아니지만.
				System.out.printf("%d*%d = %d|", i, j, i * j);
			}
			System.out.println("");
		}
	}

}
