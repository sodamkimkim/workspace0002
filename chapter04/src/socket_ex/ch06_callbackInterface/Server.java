package socket_ex.ch06_callbackInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;

public class Server extends JFrame implements IServerAndUserSocket {
	// 소켓
	ServerSocket serverSocket;
	Vector<UserSocket> sockets = new Vector<>();
	Server mContext = this;

	// 메인쓰레드 --> 클라이언트 -> 서버
	public Server() {
		initNetwork();
	} // end of constructor

	public void initNetwork() {
		System.out.println("1. (콜백인터페이스사용)서버 소켓 시작");
		try {
			serverSocket = new ServerSocket(10001);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Socket socket = serverSocket.accept();
//						UserSocket userSocket = new UserSocket(this, socket);
						UserSocket userSocket = new UserSocket(mContext, socket);
						userSocket.start();
						sockets.add(userSocket);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	} // end of inner-class

	public void broadcast(String msg) {
		for (int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendMessage(msg);
		}
	}

	public static void main(String[] args) {
		new Server();
	}

} // end of outer-class