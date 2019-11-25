package java_20191121;

public class LotteryDemo {
	public static void main(String[] args) {
		// 0<= Math.random() <1 ,double

		int[] lotteria = new int[6];
		for (int i = 0; i < lotteria.length; i++) {
			lotteria[i] = 0;
		}

		rand: for (int i = 0; i < lotteria.length;) {
			// i++;
			double random = Math.random();
			int t = (int) (random * 45) + 1;
			// boolean = isExisted = false;
			lotteria[i] = t;
			for (int j = 0; j < i; j++) {
				if (lotteria[i] == lotteria[j]) {
					// t ==
					/*
					 * isExisted = true; i--;
					 */
					// break; 는 for문을 빠져 나간다,잊지 말라.
					continue rand;
					// isExisted = false;

					// t = (int) (random * 45) + 1;
					// 지금은 체크하고 수를 추가하지 말라고 함.
					// i--로 하는걸 추천하신다고...
				}
				/*
				 * if(isExisted){ i--; }else{ lotteria[i] = t; //여기까지 와서야 넣음. }
				 */
			}
			i++;

		}

		// 일단 버블 소트
		// insertion 시도 인데 버블 됐네

		int a = 0;
		for (int i = 1; i < lotteria.length; i++) {
			// 첫 정렬을 넣기 위해서.
			a = lotteria[i];
			// for (int j = i - 1; j < lotteria.length; j++) {
			int j = i - 1;
			// 비교 대상(정렬된 수열의 바로 오른쪽)을 제외하고 나머지 정렬된 수 들과 비교해야 하기 때문.
			// 내부의 수들중 가장 큰 값부터 비교하고 있다.key가 더 크면 바로 넣으면 되고
			// key보다 작은 값이 나오면(key의 위치가 나오면) 오른쪽의 영역을 일일히 옆으로 밀고 넣어줘야 한다.

			while (j >= 0 && lotteria[j] > a) {
				// 사이에 비집고 들어가야 할떄,하나씩 옆으로 밀어주는 작업 중+첫 정렬에서는 일단 넣어놔야 함.
				// 미리 j값을 복사해 두었으니 추가 복사 x
				lotteria[j + 1] = lotteria[j];
				j--;
				// key가 들어갈 자리를 내는 중...점점 작은 자리로 가는 중
				// }
			}
			// 아직 j는 마지막 --때문에 -1이다.
			lotteria[j + 1] = a;
			// 삽입

			// 입출력 dir와 리포지터리 가 달라지니까 서로 주의할것 !1 reposit = 1 proj
			// 미완x 그냥 로터리수를 헷갈렸다.
		}

		for (int i : lotteria) {
			System.out.print(i + "\t");
		}

	}

}
