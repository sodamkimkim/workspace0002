package thread_ex;

class PriorityThread extends Thread {

	@Override
	public void run() {
		int sum = 0;
		Thread t = Thread.currentThread();
		System.out.println(t + "start");

		for (int i = 0; i < 1_000_000; i++) {
			sum += i;

		}
		System.out.println(t.getPriority() + " end");
	}
} // end of class

public class ThreadTest4 {

	public static void main(String[] args) {
		int i;

		// 우선순위 1,2,3,4,5,6,7,8,9,10으로 셋팅
		for (i = Thread.MIN_PRIORITY; i <= Thread.MAX_PRIORITY; i++) {
			PriorityThread pt = new PriorityThread();
			pt.setPriority(i);
			pt.start();
		}
	}
} // end of class
