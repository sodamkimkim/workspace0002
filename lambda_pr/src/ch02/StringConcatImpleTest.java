package ch02;

public class StringConcatImpleTest {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "java";

		// 1. 우리가 알고 있던 oop방식
		StringConcatImple strc = new StringConcatImple();
		strc.makeStringConcat(s1, s2);

		// 2. 익명 클래스 활용 (익명 구현 클래스)
		IStringConcat strcc = new IStringConcat() {

			@Override
			public void makeStringConcat(String s1, String s2) {
				System.out.println("익명 구현 클래스 활용 :  " + s1 + s2);
			}
		};
		strcc.makeStringConcat(s1, s2);

		// 3. 람다식 활용
		IStringConcat strccc = (a, b) -> {
			System.out.println("람다식으로 사용 : " + a + b);
		}; // Interface안의 makeStringConcat 람다식으로 재정의
		strccc.makeStringConcat(s1, s2);
	}
}
