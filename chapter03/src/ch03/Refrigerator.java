package ch03;

public class Refrigerator extends HomeApliances implements RemoteController, SoundEffect {
	// Refrigerator, HomApliances, RemoteController 각각 타입으로 바라볼 수 있다.

	@Override
	public void turnOn() { // 인터페이스인 RemoteController의 추상메서드 turnOn()
		System.out.println("냉장고 켭니다.");
	}

	@Override
	public void turnOff() { // 인터페이스인 RemoteController의 추상메서드 turnOff()
		System.out.println("냉장고 끕니다.");
	}
	public void notification() {
		System.out.println("띠리리");
	}

} // end of class
