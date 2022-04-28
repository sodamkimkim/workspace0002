package ch03;

public interface RemoteController {
	//인터페이스 : 강제성이 있는 약속이다. 또는 표준, 규칙, 규약
	// 구현된 것이 아무것도 없는 밑그림만 있는 기본설계도.
	// 멤버 변수, 일반 메서드를 가질 수 없고
	// 오직 추상메서드와 상수만을 멤버로 가질 수 있다.
	
	// 추상 클래스보다 추상화가 더 높다.
		
	// <사용방법>
	// class 키워드 대신에 interface키워드를 사용한다.
	// public 이나 default사용할 수 있다.
	
	// 원형... 간소화해서 쓸 수 있다.
	public static final int SERIAL_NUMBER = 1000; //상수
	public abstract void turnOn();
	
	// 축약형...
	// 어차피 인터페이스는 new할 수 없기때문에 이렇게 축약형을 써도 상관 없음
	int SERIAL_NUMBER2 = 100; //(public static final 생략되었다.)
	void turnOff(); // (public abstract 생략되었다.)
}
