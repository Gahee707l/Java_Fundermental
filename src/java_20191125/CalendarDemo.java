package java_20191125;

public class CalendarDemo {

	private int year, month, day, totalCount;
	int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String[] dayArr = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

	public void set(int a, int b, int c) {
		year = a;
		month = b;
		day = c;

	}

	public int getTotalCount() {

		int prey = year - 1;
		int y = (prey / 4) - (prey / 100) + (prey / 400);
		// 작년까지의 윤년인 해 수
		boolean isLeafYear = (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0);

		if (isLeafYear) {
			monthArr[1] = 29;
		}

		totalCount += (365 * prey) + y;

		for (int i = 0; i < month - 1; i++) {
			totalCount += monthArr[i];
		}

		return totalCount + day;
	}

	public void print() {
		// 이 총 날짜는 멤버 변수로 빼도 됨
		String message = null;
		message = dayArr[(totalCount % 7)];

		System.out.printf("%d년 %d월 %d일 %s 입니다", year, month, day, message);
	}

	public static void main(String[] args) {
		CalendarDemo c = new CalendarDemo();
		c.set(2019, 12, 25);
		c.print();
	}
	
	//오버로딩 : 이름과 매개변수 다른 것만 따짐.가장 대표적 오버로딩 함수 = print

}
