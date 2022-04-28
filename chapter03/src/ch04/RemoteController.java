package ch04;

public interface RemoteController {
	public static final int SERIAL_NUMBER = 1000;

	public abstract void turnOn();

	int SERIAL_NUMBER2 = 100; // public static final 생략

	void turnOff(); // public abstract 생략
	
}
