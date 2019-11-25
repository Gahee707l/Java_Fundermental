package java_20191122;

public class Customer {
	// 은행 고객
	public String name;
	public String email;
	public String phone;
	public int age;
	// instance + final : final은 초기화값이 필요,처음 값 대로.변경 불가
	public double balance;
	public boolean isReleased;
	// 탈퇴 여부
	public static double interestRate;
//	in M:static area
	// 동일상품 이자율
	public static final String BANKNAME = "신한은행";
	// final : 관례상 대문자

}
