package ch02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMainTest {
	public static void main(String[] args) {
//		Calendar calender = new Calendar; (x)
		Calendar calender = Calendar.getInstance();
		// 캘린더 아이덴터티를 생각해보면
		// 시간 날짜개념을 가질듯
		// 시간 날짜 개념을 힙이라는 객체에 많이 만들어 놓을필요 없음
		// 그래서 싱글톤으로 설계되어있음
		System.out.println(calender.getTimeInMillis());
// 1650416883076 -> 현재시간(1000분의 1초)
// --> 영어권, 아시아, 유럽.. 날짜, 시간을 보여주는 포맷팅 나라마다 다름

		// 보여주는 방식은 각자 알아서 구현하도록 설계
		// 보기 불편한 형식을 편하게 변환해서 사용하는 방법을 알아보자.
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(dateFormat); // 주소출력
		String date = dateFormat.format(calender.getTimeInMillis());
		System.out.println(date);
	}
}
