package socket_ex.ch06_callbackInterface;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	// 소켓
	Socket socket;
	// 입출력 Stream
	BufferedReader keyBoardBufferedReader; // 클라이언트측 키보드 문자열 읽기
	BufferedReader bufferedReader; // 서버 -> 클라 데이터 읽어오기
	BufferedWriter bufferedWriter; // 클라 -> 서버 데이터 쓰기
	// 주소 정보
	final String SERVERIP = "localhost";
	final int SERVERPORT = 10001;
	// Flag
	boolean mainFlag;
	boolean threadFlag;

	public Client() {
		try {
			mainFlag = true;
			threadFlag = true;
			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(SERVERIP, SERVERPORT); // server측 IP와 PORT에 소켓 연결 , 이 소켓으로 데이터 통신할 것임.
			System.out.println("2. 버퍼 연결");
			// 키보드 연결
			System.out.println("3. 키보드 연결");
			keyBoardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// 소켓 연결
			// from 서버
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// To 서버
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// ReadThread
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			while (mainFlag) {
				System.out.println("4. 키보드 연결 대기중..");
				String msg = keyBoardBufferedReader.readLine();
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			System.out.println("예외발생: UnknownHostEx : " + e.getMessage());
			mainFlag = false;

		} catch (IOException e) {
			System.out.println("클라측 통신연결 예외발생: IOEx : " + e.getMessage());
			mainFlag = false;

		}

		try {
			keyBoardBufferedReader.close();
			bufferedWriter.close();
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("클라 closing 예외 발생 : " + e.getMessage());
			
		} finally {
			mainFlag = false;
			threadFlag = false;

		}
	} // end of constructor

	// 서버 - > 클라 데이터 읽어올 쓰레드
	private class ReadThread implements Runnable {
		@Override
		public void run() {
			while (threadFlag) {
				try {
					String msg = bufferedReader.readLine();
					System.out.println("서버로 부터 받은 메시지 : " + msg);
				} catch (IOException e) {
					System.out.println("클라측 ReadThread 예외발생 : " + e.getMessage());
					threadFlag = false;
				}

			}
		}
	} // end of inner-class

	public static void main(String[] args) {
		new Client();
	} // end of main
} // end of outer-class