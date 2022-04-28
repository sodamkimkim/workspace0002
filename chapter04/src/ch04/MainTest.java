package ch04;

public class MainTest {
	// 객체들 연결방법
	// 1. 생성자를 받아서 연결
	// 2. 메서드로 연결
	public static void main(String[] args) {
		Activity1 activity1 = new Activity1("화면1");
		Activity2 activity2 = new Activity2("화면2");
		// 메서드를 통해서 콜백 연결하기
		activity2.setCallbackCheckPosition(activity1.callback);// ******
		// 셋 메서드를 활용해서 콜백 구현하는 방식
		// 콜백 -> 사실 옵저버 패턴중 하나임.
		// 디자인 패턴
		// 스프링이 프레임워크기 때문에 디자인패턴많이 사용됨
		// 디자인 패턴 중요하고, 스프링 들어가기전에 강의할것임

	} // end of main

} // end of class
