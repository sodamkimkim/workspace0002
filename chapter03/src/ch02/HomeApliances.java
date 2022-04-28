package ch02;

public abstract class HomeApliances { // abstract -> HomeApliances를 new하지 못함.
	int width;
	int height;
	String color;

	public abstract void turnOn(); // 냉장고, 티비에 turn on, turn off 구현 강제성 생긴다.

	public abstract void turnOff();// 냉장고, 티비에 turn on, turn off 구현 강제성 생긴다.
}
