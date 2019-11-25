package java_20191121;

public class CalendarDemo {
	public static void main(String[] args) {
		/*
		 * 달력만들기 , ctrl + shit+/ 총 일수 더해서 %7 값으로 요일 맞추기가 목표 1년 1월 1일 = 월요일 윤년:
		 * 366일2/29 2019/ 12/ 25 요일 은?
		 */

		int year = 1900;
		// 2019;
		int month = 9;
		// 12;
		int day = 8;
		// 25;
		int dayI = 0;

		int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] dayArr = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		// coding parts

		int prey = year - 1;
		// !!!!이전 년도...맞아 이전 년도 까지만 계산해야 한다.

		int sum = 0;
		int y = (prey / 4) - (prey / 100) + (prey / 400);
		// 작년까지의 윤년인 해 수

		if ((month >= 2) && (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0 )) {
			//	2월 이상인것도 확인 안하고,그냥 올해가 윤년이면 mothArr[1]만 29로 수정하고 더하면 됨.													한번 걸러진걸 다시 주워와야 하니까....
			y++;
		}

		/*
		 * if (prey % 4 == 0) { y += ((prey / 4)); if (prey % 100 == 0) { y -=
		 * (prey / 100); if (prey % 400 == 0) y += (prey / 400); } }
		 */

		// sum = (366 * y);
		sum += (365 * prey) + y;

		for (int i = 0; i < month - 1; i++) {
			sum += monthArr[i];
		}

		sum += day;
		// 오늘까지의 일수

		dayI = sum % 7;

		System.out.printf("%d년 %d월 %d일 %s 입니다", year, month, day, dayArr[dayI]);
		// 뭔가 됐다 안됐다 하고 있음.......
		//됐...다....
		
		//final : 상속이 안되는 클래스
		//abstract : 덜만들어졌으니 자식이 완성해야하는(상속을 하라는) 클래스
		//(default) : 같은 package끼리만 접근 가능
		//public class는 한 파일당 파일명과 같은 class에 하나씩만 만들 수 있음,그안의 main만 호출하니 다른 class의 main은 호출이 안됌.
	}

}
