package thread_ex;

class MyCustomThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + " : " + Thread.currentThread());
		}
	}
}

public class ThreadTest3 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		MyCustomThread2 t1 = new MyCustomThread2();
		MyCustomThread2 t2 = new MyCustomThread2();
		MyCustomThread2 t3 = new MyCustomThread2();

		t1.start();
		t2.start();
		t3.start();

	}
} // end of class

//<Thread 개념 정리>
// @ Process : 프로그램이 실행되면 OS로 부터 메모리를 할당받아, 프로세스 상태가 된다.
// @ Thread : 하나의 프로세스는 하나 이상의 thread를 가지게 되고,
// 실제 작업을 수행하는 단위는 thread이다.

// @ multi-threading
// : 여러 thread가 동시에 수행되는 프로그래밍
// 여러 작업이 동시에 실행되는 효과를 낸다

// thread는 각각 자신만의 작업공간을 가진다 (context)
// - 자신만의 멤버변수 가질 수 있다.
// String name 선언한 것처럼

// @ 동기화 # race - condition ,  # critical section
// 각 쓰레드는 공유하는 자원이 생길 수 있다.
// 여러 thread가 자원을 공유하여 작업이 수행되는 경우
// 서로 자원을 차지하려는 race - condition(임계 영역)이 발생할 수 있어서
// 의도하지 않은 결과를 만들어 낼 수 있다.

// critical section.. 
// 해결방법으로는 동기화 처리를 해줘야 한다.