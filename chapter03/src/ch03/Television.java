package ch03;

public class Television extends HomeApliances implements RemoteController {

	// Television, HomApliances, RemoteController 각각 타입으로 바라볼 수 있다.
	
	@Override
	public void turnOn() {
		System.out.println("티비 on");
	}

	@Override
	public void turnOff() {
		System.out.println("티비 off");
	}

} // end of class
