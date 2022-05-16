package ch02;

public class MainTestFindMax {

	public static void main(String[] args) {
		// 익명구현객체로 큰값찾기
		IFindMax iFindMax = new IFindMax() {

			@Override
			public int findMax(int a, int b) {
				return a > b ? a : b;
			}
		};
		System.out.println(iFindMax.findMax(20, 10));

		// 람다식으로 표현해서 큰값찾기
		IFindMax iFindMaxLambda = (a, b) -> a > b ? a : b;
		System.out.println(iFindMaxLambda.findMax(30, 40));
	}

}
