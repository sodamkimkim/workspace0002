package ch01;

public class MainTest1 {
	public static void main(String[] args) {
		// 익명 구현 클래스 방법
		IAdd iAdd = new IAdd() {

			@Override
			public int add(int x, int y) {

				return x + y;
			}
		};
		// 사용방법.
		System.out.println(iAdd.add(10, 20));

		// 람다식으로 변경하면..?
		// 타입 추론이 가능하기 때문에 이러한 표현이 가능하다.
		// 코드를 줄일 수 있다.
		IAdd iAddLambda = (x, y) -> {
			return x + y;
		};
		System.out.println(iAddLambda.add(10, 20));
		
		// 결론
		// 기본 OOP문법 :  인터페이스를 선언 --> 익명 구현 객체 --> 사용
		// 람다 표현식 : 인터페이스 선언 --> 람다 표현식으로 변경 --> 사용
	}
}
