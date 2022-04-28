package tenco.com.test_02;

public class WrapperClass1_pr {
	public static void main(String[] args) {
		Integer num = new Integer(17); // 박싱.. 근데 deprecated
		int n = num.intValue(); // 언박싱
		System.out.println(n);
		System.out.println("-----------------");
		
		Integer num1 = 200; // 박싱 -> 컴파일러가 자동으로 new Integer(200);해줌. 자동박싱
		int num10 = num1; // 언박싱
	} // end of main
} // end of class
