package tenco.com.test_15;

/*
 * 인터페이스에서 default를 사용하면
 *  인터페이스도 몸체가 있는 메서드를 만들 수 있게된다.
 *  
 *  자바에서 다중상속이 안되기 때문에 추가된 기능이다.
 *  adapter pattern보다는 좀 더 유연한 코드를 작성할 수 있다.
 * 
 * */
public interface Moveable {
	void left();

	void right();

	public abstract void up();

	default public void down() {
	}; // **

} // end of interface
