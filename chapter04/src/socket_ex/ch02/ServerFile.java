package socket_ex.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;

	public ServerFile() {
		System.out.println("1. >>> 서버 소켓 시작 <<< ");
		try {
			serverSocket = new ServerSocket(10000);
			// 컴퓨터에 서버소켓이라는 프로그램하나 만드는 것.
			// 이거 접근하려면 포트 필요한 것.
			// 0~1023까진 못씀. 넉넉히 10000
			System.out.println("2. 서버 소켓 생성 완료.");
			socket = serverSocket.accept(); // 클라이언트 연결 대기중...
			System.out.println("3. 클라이언트 연결 완료.");

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 표준 입출력 is -- system.in
			// 서버측에는 왜 소켓이 두개가 필요한가????

			while (true) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메시지" + msg);
				//메인스레드가 계속 와일 돌고 있어서
				// 다른작업할 여력이 없다.
				// 서버 측에서는 원래 소켓  -> new 소켓 생성으로
				//여러 클라이언트 받을 수 있어야 하는데,
				// 메인 스레드는 new 소켓 생성할 여력이 없다.
				// 그래서 2번째 클라이언트가 연결할려고 할때 connection reset by peer 에러 뜬다.
				
				// 그리고 지금은 단방향인데 
				// 우리가 목표하는것은 양방향 통신. 서버 <-> 단방향
				

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("예외 발생 ");
		}

	}

	public static void main(String[] args) {
		new ServerFile();

	}

}
