package ch02;

public class MainTest1 {
	ICalc iCalc = new ICalc() {

		@Override
		public int add(int x, int y) {
			return x + y;
		}

//		@Override
//		public int sub(int x, int y) {
//			return x - y;
//		}
	};
	// 하지만 람다 표현식을 사용하기 위해서는 반드시 추상메서드가 하나이어야 한다.
	// 람다 표현식은,, 타입추론이 가능하기 떄문에 줄여쓸 수 있는건데..
	ICalc iCalcLambda = (x, y) -> x + y;
}
