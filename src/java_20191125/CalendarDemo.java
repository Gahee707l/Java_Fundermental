package java_20191125;

public class CalendarDemo {

	private int year, month, day, totalCount;
	private int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String[] dayArr = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

	public CalendarDemo(int y, int m, int d) {
		// 반환값을 지정하는 순간 생성자가 아닌 메소드로 분류된다.클래스 이름과 동일&반환값 없음 = 생성자
		//inst var 초기화
		year = y;
		month = m;
		day = d;
		getTotalCount();

	}

	public CalendarDemo(int y) {
		// 반환값을 지정하는 순간 생성자가 아닌 메소드로 분류된다.클래스 이름과 동일&반환값 없음 = 생성자
		// year = y;

		this(y, 0, 0);
		//매개변수 3개짜리를 호출한 것이다.
		
		// this
		// 2.클래스 내부의 다른 생성자(constructor) 호출 = this(매개변수>갯수에 따라 호출하며); << 생성자에서만 호출 가능.
		//이건 많이는...?안쓰는듯
	}

	public CalendarDemo(int y, int m) {
		// 반환값을 지정하는 순간 생성자가 아닌 메소드로 분류된다.클래스 이름과 동일&반환값 없음 = 생성자
		//year = y;
		//month = m;
		this(y, m, 0);
		//생성자 에서만 this(생성자) 가능

	}

	public void set(int year, int month, int day) {
		this.year = year;
		//this
		// 1.자기자신객체 = this.
		//멤버변수 = 배개변수; 이건 쓴다
		this.month = month;
		this.day = day;
		getTotalCount();

	}

	public int getTotalCount() {

		int prey = year - 1;
		int y = (prey / 4) - (prey / 100) + (prey / 400);
		// 작년까지의 윤년인 해 수
		boolean isLeafYear = (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0);

		if (isLeafYear) {
			monthArr[1] = 29;
		}

		totalCount = (365 * prey) + y;

		for (int i = 0; i < month - 1; i++) {
			totalCount += monthArr[i];
		}
		totalCount += day;

		return totalCount;
	}

	public void print() {
		// 이 총 날짜는 멤버 변수로 빼도 됨
		String message = null;
		message = dayArr[(totalCount % 7)];

		System.out.printf("%d년 %d월 %d일 %s 입니다", year, month, day, message);
	}

	public static void main(String[] args) {
		CalendarDemo c = new CalendarDemo(2019, 12, 25);
		// 생성자의 오버로딩...왠만하면 디폹트 생성자를 만들고 시작하는게 낫다,다른곳에서 매개변수가 필요 없이 호출 하기도 하고 기타
		// 등등,아무튼 오류는 안남.

		// c.set(1912,2,3);
		// set 하면서 걔선 험깨 하기
		c.print();
	}

	// 오버로딩 : 이름과 매개변수 다른 것만 따짐.가장 대표적 오버로딩 함수 = print

}
