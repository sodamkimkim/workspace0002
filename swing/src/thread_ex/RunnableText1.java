package thread_ex;

import javax.swing.JFrame;

//Runnable 인터페이스를 구현해서 만들기 - thread 구현 2번쨰
// 자바는 다중상속이 허용되지 않으므로
// 다른 클래스를 상속한 경우에도
// thread를 만들기 위해 Runnable interface를 구현한다.

class MyRunnable1 extends JFrame implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("00 ");
		}
	}

}

public class RunnableText1 {
	public static void main(String[] args) {
		//사용하는 방법
		MyRunnable1 myRunnable1 = new MyRunnable1();
		// Runnable 구현한 객체는 Thread를 생성해서 매개변수에 담고
		// 스레드를 시작하면 된다.
		
		Thread thread1 = new Thread(myRunnable1);
		thread1.start();
		
	} // end of main
} // end of class
