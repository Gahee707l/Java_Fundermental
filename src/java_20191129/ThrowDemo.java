package java_20191129;

public class ThrowDemo {
	// 인위적 예외 정의및 발생
	public static double withraw(String acount, int amount) throws Exception {
		double myBalance = 10000;
		String myAcount = "123-123-1234";
		if (myAcount.equals(acount)) {
			if (myBalance - amount >= 0) {
				myBalance -= amount;
			} else {
				throw new InsufficientBalanceException("루저의 잔고가 부족합니다.");
				//		보통은 사용자정의 예외 클래스 정의해서 사용
			}
		} else {
			throw new IncorrectAccountException("계좌번호가 잘못 되었습니다.");
			// 반드시 해야 한다 = 익셉션
			// 안해도 된다 = 런타임
		}
		return myBalance;
	}

	public static void main(String[] args) {
		double balance = 0;
		try {
			balance = withraw("123-123-1234", 100000);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.printf("인출후 잔고는 %.2f원 입니다.", balance);
	}

}
