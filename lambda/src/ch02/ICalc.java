package ch02;

@FunctionalInterface // 컴파일 시점에 바로 에러뜸. 메서드 한개만 쓰도록 막아주는 거임.
public interface ICalc {
	int add(int x, int y);

//	int sub(int x, int y); -- > 람다 표현식에 쓸 Interface에는 메서드 두개쓰면 안된다.!
}
