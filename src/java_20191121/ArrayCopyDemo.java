package java_20191121;

public class ArrayCopyDemo {

	public static void main(String[] args) {
		String[] fruits ={"apple","banana","watermelon","peach"};
		String[] temp = new String[6];
		
		System.arraycopy(fruits, 0, temp, 2, 4);
		//					시작 idx		복사할 배열의 시작위치/원본 배열의 원소 4개 복사(즉,length)
		temp[0]="blueberry";
		temp[1]="rasberry";
		
		for (String fruit : temp) {
			System.out.println(fruit);
		}
		
		String[] ref = fruits;
		ref[0] ="jobs";
		System.out.println(fruits[0]);
		System.out.println(ref[0]);
		
		int[] a = {1,2,3,4};
		int[] b = {1,2,3,4};
		int[] c = b;
		
		System.out.println(a==b);
		System.out.println(b==c);
		//equal과 ==의 차이 잘 기억해 두기.

	}

}
