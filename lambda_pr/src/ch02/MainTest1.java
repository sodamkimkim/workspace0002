package ch02;

public class MainTest1 {
	// 익명구현객체
	ICalc ical=new ICalc(){@Override public int add(int x,int y){return x+y;}};
	// 람다.
	ICalc icalLamb = (x, y) -> {
		return x+y;
	};

}
