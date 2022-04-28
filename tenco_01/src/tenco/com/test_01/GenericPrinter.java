package tenco.com.test_01;

public class GenericPrinter<T> { // <임의의 대문자>
	// T라는 대체문자를 사용한다.
	// E - element, K - key, V - value (암묵적 통일..)
	
	// 위에서 선언한 자료형을 여기서 타입으로 쓸 수가 있다.
	private T material; // T 자료형으로 선언한 변수

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	

} // end of class



