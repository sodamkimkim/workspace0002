package socket_ex.ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	ServerSocket serverSocket;
	Socket socket;
	boolean flag;

	/////////// *******************
	BufferedReader keyboardBufferedReader;// 키보드 문자열 읽는 녀석
//	keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

	BufferedWriter bufferedWriter; // 클라이언트 쪽으로 데이터를 보내는 녀석
//	bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	BufferedReader bufferedReader; // 소켓으로 인풋받는 녀석
//	bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	/////////////// *****************

	public ServerFile() {
		flag = true;
		System.out.println("1. >>> 서버 소켓 시작 <<< ");
		try {
			serverSocket = new ServerSocket(10000);

			System.out.println("2. 서버 소켓 생성 완료.");
			socket = serverSocket.accept(); // 클라이언트 연결 대기중...
			System.out.println("3. 클라이언트 연결 완료.");

			// 초기화 처리
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// 버퍼리더넣어야 가변배열로 변경됨. 버퍼리더 전에 기반스트림에서 복부호화등 완료된다.

			// 클라이언트에게 보낼 스트림 연결(outputStream)
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 쓰레드 처리
			WriteThread writeThread = new WriteThread();
			Thread thread = new Thread(writeThread);
			thread.start();

			while (flag) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메시지" + msg);

			}

		} catch (IOException e) {
			System.out.println("예외 발생 ");
		}

	}

	private class WriteThread implements Runnable {
		// 스레드 한번 동작하면 죽어버린다. while문 달아야 한다.
		@Override
		public void run() {
			// 키보드에서 데이터를 읽어줌

			while (true) {
				try {
					String msg = keyboardBufferedReader.readLine();
					// 클라이언트로 데이터 보내기 --> 소켓에 연결해야 한다.
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
				} catch (IOException e) {

					System.out.println("예외발생 : " + e.getMessage());
				} finally {
					try {
						flag = false;
						bufferedReader.close();
						keyboardBufferedReader.close();
						bufferedWriter.close();
						bufferedReader.close();
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		}
	} // end of inner class

	public static void main(String[] args) {
		new ServerFile();

	}

}
