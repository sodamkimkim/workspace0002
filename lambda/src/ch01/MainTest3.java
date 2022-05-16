package ch01;

public class MainTest3 {
	public static void main(String[] args) {
//		ICalc iCalcAdd = new ICalc() {
//
//			@Override
//			public double calc(int a, int b, int c) {
//
//				return a + b + c;
//			}
//		};
//		ICalc iCalMinus = new ICalc() {
//
//			@Override
//			public double calc(int a, int b, int c) {
//				return a - b - c; // 인터페이스의 유연함! 쓰는 입장에서 수정해서 쓸 수 있음!!
//			}
//		};
//		ICalc iCalMulti = new ICalc() {
//
//			@Override
//			public double calc(int a, int b, int c) {
//				return a * b * c;
//			}
//		};
//		System.out.println(iCalcAdd.calc(1, 1, 1));
//		System.out.println(iCalMinus.calc(1, 1, 1));
//		System.out.println(iCalMulti.calc(1, 1, 1));
		
		// 문제 1 -> 람다 표현식으로 만들어서 사용해 주세요
		// 1
		ICalc iAddLambda = (a, b, c) -> {
			return a + b + c;
		};
		// 2
		ICalc iMinusLambda = (a, b, c) -> {
			return a - b - c;
		};
		//  실행문이 한 문장인 경우, 중괄호와 return키워드를 생략할 수 있다.
		ICalc iMultiLambda = (a, b, c) -> a * b * c;
		
		System.out.println(iAddLambda.calc(1, 1, 1));
		System.out.println(iMinusLambda.calc(2, 2, 2));
		System.out.println(iMultiLambda.calc(1, 1, 1));

	}
}
