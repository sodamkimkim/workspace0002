package ch06_mContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;

public class Server extends JFrame {
	// 소켓
	ServerSocket serverSocket; // 다른 클라이언트 연결 대기
	Vector<UserSocket> sockets = new Vector<>();// 객체가 하나생성될 때 넣어둠
	Server mContext = this;

	// 메인쓰레드 --> 클라이언트 -> 서버
	public Server() {
		initNetwork();
	} // end of constructor

	public void initNetwork() {

		System.out.println("1. 서버 소켓 시작.");
		try {
			serverSocket = new ServerSocket(10001);
		} catch (IOException e) {
			e.printStackTrace();
		} // 서버 포트 10001할당, 모든 local포트들이 공유할 포트번호.
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) { // socket무한대기해야하기 때문에 while돌린다.
					try {
						Socket socket = serverSocket.accept();
						UserSocket userSocket = new UserSocket(mContext, socket);

						userSocket.start();
						sockets.add(userSocket);
						System.out.println("계속 도나요?");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

		}).start();

	}

	// 생성된 userSocket에 접근해서 하나씩 메시지 보내기
	// 방송하다(전체방송)
	public void broadcast(String msg) {
		for (int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendMessage(msg);
			// 클라1이 서버측에 메시지 보내면
			// 받은 시점에 broadcast호출하면됨.
		}
	}

	public static void main(String[] args) {
		new Server();
	}
} // end of outer-class