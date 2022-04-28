package tenco.com.test_02;

public class WrapperClass1 {
	public static void main(String[] args) {
		// 기본 데이터타입들을 클레스처럼 감싸줌
		// 기본 데이터 타입과 참조데이터타입으로 나뉘는데 .

		Integer num = new Integer(100); // 박싱
		Number n1 = 10;

//		int n = num; // auto Boxing
		int n = num.intValue(); // Unboxing
		System.out.println(n);
		System.out.println("------------집중해 소담~! ---------");

		Integer num1 = 200; // 컴파일러가 new Integer(200); --> 자동 박싱을 해주는 거임
		int num10 = num1; // auto Unboxing -> num.intValue();

	} // end of main
} // end of class


