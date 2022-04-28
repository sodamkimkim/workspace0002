package tenco.com.test_01;

public class MainTest3 {
	public static void main(String[] args) {
		// 재료
		Powder powder = new Powder();
		Plastic plastic = new Plastic();

		// 완전하게 컴파일 하지 않았다가, 사용하는 시점에 지정된 자료형으로 컴파일된다.
		GenericPrinter<Powder> genericPrinter1 = new GenericPrinter<>();
		genericPrinter1.setMaterial(powder);
		System.out.println(genericPrinter1.getMaterial());

		GenericPrinter<Plastic> genericPrinter2 = new GenericPrinter<Plastic>();
		genericPrinter2.setMaterial(plastic);

		System.out.println(genericPrinter2.getMaterial());

		GenericPrinter<Water> genericPrinter3 = new GenericPrinter<>();
		genericPrinter3.setMaterial(genericPrinter3.getMaterial());

		GenericPrinter2<Powder> g2 = new GenericPrinter2<>();
		g2.setMaterial(powder);
//		g2.setMaterial(plastic); 이상한거 넣으면 오류난다.
		System.out.println(g2);
		
//		<T extends 클래스> 사용하기
		// 상위클래스의 필요성
		// T자료형의 범위를 제한할 수 있다.(제한하지 않으면 아무 클래스나 올 수 있다.)
		
	}
} // end of class
