package thread_ex;

import java.util.Scanner;

class MyThread1 extends Thread {
	
	boolean flag = true;
	@Override
	public void run() { // 서브작업자가 하고있음

		while (flag) {
			System.out.println("-");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEnd {

	public static void main(String[] args) {
		System.out.println("작업자를 생성합니다.");
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();

		// 메인 thread가 하고 있음
		System.out.println("중지 0을 입력");
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();
		if(userInput == 0) {
//			myThread1.stop();
			//deprecated : 더이상 쓰지 않는 메서드 폐지된것...가능한 쓰지말 것.호환문제도 있어서 ..
			myThread1.flag = false;
		}
	} // end of main
}// end of class

