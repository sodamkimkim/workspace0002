package tenco.com.test_01;

public class MainTest2 {

	public static void main(String[] args) {
		
		Powder powder = new Powder();
		Plastic plastic = new Plastic();
		
		
		ThreeDPrinter1 dPrinter1 = new ThreeDPrinter1();
		dPrinter1.setMaterial(plastic);
		ThreeDPrinter2 dPrinter2 = new ThreeDPrinter2();
		dPrinter2.setMaterial(powder);
		
		ThreeDPrinter3 dPrinter3 = new ThreeDPrinter3();
		dPrinter3.setMaterial(plastic);
		
		//1. dp1 재료 꺼내기
		Plastic getPlastic = dPrinter1.getMaterial();
		System.out.println(getPlastic);
		
		//2. dp2 재료 꺼내기
		Powder getPowder = dPrinter2.getMaterial();
		System.out.println(getPowder);
		
		//3. dp3 재료 꺼내기
		Plastic tempPlastic = (Plastic) dPrinter3.getMaterial();
		System.out.println(tempPlastic);
		// 형변환을 해야하는 번거로움이 있다. ( 코드를 살펴서 확인을 해야 한다.)
		
		

	} // end of main

} // end of class
