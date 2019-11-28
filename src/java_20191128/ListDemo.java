package java_20191128;

import java.util.*;

public class ListDemo {
	// 이름 바꾸기 : 커서 가져가기 +f2
	public static void main(String[] args) {

		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "terra", 2500));
		list.add(new Product(2, "신라면", 1000));
		list.add(new Product(3, "서울우유", 3000));

		for (int i = 0; i < list.size(); i++) {
			Product temp = list.get(i);
			System.out.println(temp);
		}

		// 모두...삭...제...
		for (int i = 0; i < list.size(); i++) {
			// 맞다 사이즈가 매번 바뀌는거...그래서 0으로는 고정하면 마지막이 하나 남음
			// idx이 자동으로 수정되는것을 잊지 말것.
			list.remove(i--);
			// list.remove(0);
		}

		// enhanced for는 Iterator로 제너릭 선언 한 경우만 가능

		for (Product temp : list) {
			System.out.println(temp);
		}
	}

}

class Product {
	int no;
	String name;
	double price;

	Product(int no, String name, double price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + "]";
		// , toString()=" + "+ super.toString()
	}
}
