package java_20191121;

public class ArrayDemo {

	public static void main(String[] args) {

		int[] a = new int[4];
		a[0] = 1;
		for (int i = 0; i <= a.length - 1; i++) {
			// length : 배열의 길이 / length() : 문자열의 길이
			a[i] = i + 1;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		int[] b = { 1, 2, 3, 4 };

		for (int i = 0; i < a.length; i++) {
			b[i] = i + 5;
		}
		for (int temp : b) {
			System.out.print(temp);
		}

		// int[] c = new int[]{ 0, 0 }; 많이는 안쓴데 근데....
		// int c[] = {1,2,3,4};

	}

}
