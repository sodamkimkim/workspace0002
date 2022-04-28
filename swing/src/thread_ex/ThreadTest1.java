package thread_ex;

import java.util.Iterator;

public class ThreadTest1 {

	// 메인 코드의 시작점
	// 메인쓰레드라고 함
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			System.out.println(i + "\t ");

			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // end of main
} // end of class
