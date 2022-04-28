package ch04;

public class ToyRobot implements RemoteController {

	String name;

	public ToyRobot() {
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

}
