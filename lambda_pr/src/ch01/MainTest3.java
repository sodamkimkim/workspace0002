package ch01;

public class MainTest3 {
	public static void main(String[] args) {

//		ICalc iCalcAdd = new ICalc() {
//			@Override
//			public double calc(int a, int b, int c) {
//				return a + b + c;
//			}
//		};
//		ICalc iCalMinus = new ICalc() {
//			@Override
//			public double calc(int a, int b, int c) {
//				return a - b - c;
//			}
//		};
//		ICalc iCalMulti = new ICalc() {
//			@Override
//			public double calc(int a, int b, int c) {
//				return a * b * c;
//			}
//		};
//		System.out.println(iCalcAdd.calc(1, 1, 1));
//		System.out.println(iCalMinus.calc(2, 1, 3));
//		System.out.println(iCalMulti.calc(5, 5, 5));
//	
		ICalc iAddLambda = (a, b, c) -> a + b + c;
		ICalc iMinusLambda = (a, b, c) -> a - b - c;
		ICalc iMultiLambda = (a, b, c) -> a * b * c;
		System.out.println(iAddLambda.calc(5, 10, 4));
		System.out.println(iMinusLambda.calc(50, 10, 2));
		System.out.println(iMultiLambda.calc(10, 20, 30));
	}
}
