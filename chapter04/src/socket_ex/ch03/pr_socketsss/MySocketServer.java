package socket_ex.ch03.pr_socketsss;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// 소켓통신용 서버 코드
public class MySocketServer extends Thread {
	static ArrayList<Socket> list = new ArrayList<Socket>();// 유저 확인용
	static Socket socket = null;

	public MySocketServer(Socket socket) {
		this.socket = socket; 
		list.add(socket);
	}

	public static void main(String[] args) {
		int socketPort = 1234;
		try {
			ServerSocket serverSocket = new ServerSocket(socketPort);
			System.out.println("socket : " + socketPort + "으로 서버가 열렸습니다.");

			// 소켓 서버가 종료될 때까지 무한루프
			while (true) {
				Socket socketUser = serverSocket.accept(); // 서버에 클라이언트 접속

				// Thread안에 클라이언트 정보를 담아줌
				Thread thd = new MySocketServer(socketUser);
				thd.start(); // Thread시작
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // 서버 소켓 만들기
	}

}
