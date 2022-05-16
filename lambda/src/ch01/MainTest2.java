package ch01;

public class MainTest2 {
	public static void main(String[] args) {

		ICalc iCalcAdd = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {

				return a + b + c;
			}
		};
		ICalc iCalMinus = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a - b - c; // 인터페이스의 유연함! 쓰는 입장에서 수정해서 쓸 수 있음!!
			}
		};
		ICalc iCalMulti = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a * b * c;
			}
		};
		System.out.println(iCalcAdd.calc(1, 1, 1));
		System.out.println(iCalMinus.calc(1, 1, 1));
		System.out.println(iCalMulti.calc(1, 1, 1));
		
		//문제 1 -> 람다 표현식으로 만들어서 사용해 주세요 
		//1
		
		//2
		//3
	}
}
