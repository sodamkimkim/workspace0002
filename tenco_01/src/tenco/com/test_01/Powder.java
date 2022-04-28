package tenco.com.test_01;

public class Powder extends Material {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "재료는 Powder입니다.";

	}

	@Override
	public void doPrinting() {
		System.out.println("파우더로 출력합니다.");
	}
}
