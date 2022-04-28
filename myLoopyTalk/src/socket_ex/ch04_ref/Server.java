package socket_ex.ch04_ref;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class Server extends JFrame {
	// 소켓
	ServerSocket serverSocket;
	Socket socket;

	// 입출력Stream
	BufferedReader keyboardBufferedReader; // 서버측 키보드 문자열 읽기
	BufferedReader bufferedReader; // 서버 -> 클라 데이터 읽어오기
	BufferedWriter bufferedWriter; // 클라 -> 서버 데이터 쓰기

	// flag
	boolean mainFlag;
	boolean threadFlag;

	// 메인쓰레드 --> 클라이언트 -> 서버
	public Server() {
		initFrameObject();
		initLayout();
		initAddEventListener();
		initNetwork();
		setVisible(true);

	} // end of constructor

	private void initFrameObject() {
		// TODO Auto-generated method stub

	}

	private void initLayout() {
		// TODO Auto-generated method stub

	}

	private void initAddEventListener() {
		// TODO Auto-generated method stub

	}

	public void initNetwork() {

		mainFlag = true;
		threadFlag = true;
		try {
			System.out.println("1. 서버 소켓 시작.");
			serverSocket = new ServerSocket(10001); // 서버 포트 10001할당, 모든 local포트들이 공유할 포트번호.
			System.out.println("2. 서버 소켓 생성 완료.");
			socket = serverSocket.accept();
			System.out.println("3. 클라이언트 연결 완료.");

			// from 키보드
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// from 클라이언트
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// To 클라이언트
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 서버 -> 클라 데이터 보낼 때 쓰레드처리
			WriteThread writeThread = new WriteThread();
			Thread thread = new Thread(writeThread);
			thread.start();

			// 클라 -> 서버 데이터 읽어올 때
			while (mainFlag) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로부터 받은 메시지 : " + msg);

			}
		} catch (IOException e) {
			System.out.println("서버측 통신 연결 예외발생 : " + e.getMessage());
			mainFlag = false;

		}
		try {
			keyboardBufferedReader.close();
			bufferedReader.close();
			bufferedWriter.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("서버 closing 예외 발생 : " + e.getMessage());
		} finally {
			mainFlag = false;
			threadFlag = false;

		}

	}

	// 서버 -> 클라이언트
	// 서버의 키보드에서 데이터를 읽어서
	// 클라이언트에 데이터 날려줌.
	private class WriteThread implements Runnable {

		@Override
		public void run() {
			while (threadFlag) {
				try {
					String msgFromServerToClient = keyboardBufferedReader.readLine();
					bufferedWriter.write(msgFromServerToClient + "\n");
					bufferedWriter.flush();
				} catch (IOException e) {
					System.out.println("서버측 WriteThread 예외발생 : " + e.getMessage());
					threadFlag = false;

				}
			}

		}

	} // end of inner-class

	public static void main(String[] args) {
		new Server();
	}
} // end of outer-class