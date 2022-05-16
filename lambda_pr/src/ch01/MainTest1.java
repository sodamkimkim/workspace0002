package ch01;

public class MainTest1 {
	public static void main(String[] args) {
		// 익명구현클래스 사용
		IAdd iAdd = new IAdd() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		System.out.println("익명구현클래스 사용 결과 값: " + iAdd.add(10, 20));

		// 람다식으로 변경
		IAdd iAddLambda = (a, b) -> {
			return a + b;
		};
		System.out.println("람다식표현 결과 값: " + iAddLambda.add(10, 30));
	}
}
