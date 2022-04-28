package tenco.com.test_02;

public class WrapperClass2_pr {
	public static void main(String[] args) {
		String str = "100dfdfdfdfdfd";
		String str2 = "100.5";
		String str3 = "true";

		try {
			int i = Integer.parseInt(str); // int로 형변환해서 언박싱
			System.out.println("문자열 int값 변환 : " + i);
		} catch (Exception e) {
			System.out.println("int로 변환할 수 없습니다.");

		}

		try {
			double b = Double.parseDouble(str2); // double로 형변환해서 언박싱
			System.out.println("문자열 double값 변환 : " + b);

		} catch (Exception e) {
			System.out.println("double로 변환할 수 없습니다.");
		}
		try {
			boolean bool = Boolean.parseBoolean(str3); // boolean으로 형변환해서 언박싱
			System.out.println("문자열 boolean값 변환 : " + bool);
		} catch (Exception e) {
			System.out.println("boolean으로 변환할 수 없습니다.");
		}
	} // end of main
} // end of class
