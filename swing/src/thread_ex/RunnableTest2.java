package thread_ex;

import javax.swing.JFrame;

class MyRunnable2 extends JFrame {

	// 인터페이스.. 익명구현객체로는 new 가능
	// 내부 익명 구현 객체를 변수에 담기
	Runnable a = new Runnable() { // Runnable 데이터타입 선언, new라고 선언해서 anonymous inner타입으로..
		// 선언과 동시에 초기화..

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("-");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	};

	// 생성자
	public MyRunnable2() {
//		a.run();
	}
} // end of class

public class RunnableTest2 {

	public static void main(String[] args) {
		MyRunnable2 myRunnable2 = new MyRunnable2();
		myRunnable2.a.run();

	} // end of main

} // end of class
