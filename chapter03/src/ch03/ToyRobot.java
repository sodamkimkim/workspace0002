package ch03;

public class ToyRobot implements RemoteController, SoundEffect {
	// ToyRobot, RemoteController 각각 타입으로 바라볼 수 있다.

	
	// 인터페이스는 강제성 있는 약속이다.
	
	//ToyRobot과 HomeApliances를 묶기 애매할 때
	// 기능에 대한 부분을 인터페이스로 설정한 뒤 
	// ToyRobot, Refrigerator, Television은 인터페이스의 메서드를 공유한다.
	// HomeApliances는 TV와 냉장고만 extends한다.
	
	String name;

	public ToyRobot() {
		// 생성자
		this.name = "건담로봇";
	}

	@Override
	public void turnOn() {
		System.out.println("장난감 로봇 on");

	}

	@Override
	public void turnOff() {
		System.out.println("장난감 로봇 off");
	}
	public void notification() {
		System.out.println("띠리리");
	}
} // end of class
