package ch02;

public class StringConcatImpleTest {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "java";
		// 1. 우리가 알고 있던 OOP방식
		StringConcatImple impl = new StringConcatImple();
		impl.makeString(s1, s2);

		// 2. 익명 클래스 활용 (익명 구현 클래스)
		IStringCouncat iStringCouncat = new IStringCouncat() {

			@Override
			public void makeString(String s1, String s2) {
				System.out.println("[[[" + s1 + ": " + s2 + "]]]");

			}
		};
		// 3. 람다식 활용
		IStringCouncat iStringConcatLambda = (a, b) -> {
			System.out.println(a + b);
		};
		iStringConcatLambda.makeString("안녕", "람다");
		// 클래스 설계 없이 바로 사용 가능.
		// 함수형프로그래밍
		// 매개변수만을 이용해서 함수의 기능 구현

		// Thread runnable 익명클래스 사용한 거를 람다로 바꿔서 쓸 수 있음.
		// Thread인터페이스에 runnable이라는 추상메서드 하나있기 때문에 가능함
		new Thread(() -> {
		});

	}
}
