package socket_ex.ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//현재 버퍼가..
// 보내는 버퍼만 있음
// 읽을 버퍼도 필요
public class ClientFile {
	boolean flag;
	Socket socket;
	BufferedReader keyboaredBufferedReader; // 키보드에다가 연결할 Stream (InputStream)
	BufferedWriter bufferedWriter; // 소켓에다가 Stream을 연결할 outputStream

	// 서버에서 보낸 메시지를 읽기 위한 bufferedReader장착.
	// 이녀석 동작시키기 위해선 새로운 쓰레드 필요
	BufferedReader bufferedReader;

//	final String IP = "localhost"; // 자기 자신을 나타내는 주소 (127.0.0.1)
	final String IP = "192.168.4.15"; // 자기 자신을 나타내는 주소 (127.0.0.1)
	final int PORT = 10000; // 아까 serverfile에서 지정한 포트번호

	public ClientFile() {
		flag = true;
		try {

			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(IP, PORT); // IP에 목적지, Port에 목적지의 port번호
//socket2 = new Socket()
			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));// 출력이라서 키보드가 아니라 소켓에
																									// 연결

			// 키보드 연결
			System.out.println("3. 키보드 버퍼 연결");
			keyboaredBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			// 초기화 처리
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 새로운 스레드 시작
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start(); // 스레드 한번 동작하면 죽어버린다. while문 달아야 한다.

			while (flag) {
				System.out.println("4. 키보드 입력 대기중..");
				String msg = keyboaredBufferedReader.readLine(); // 입력대기중
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();

			}

			// 클라이언트측 사용자에게 문자열을 받았으면 보내야 한다 -> 소켓에 연결되어있는 writer를 이용해서 보내야 한다.

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class ReadThread implements Runnable {

		@Override
		public void run() {

			while (true) {
				try {
					String msg = bufferedReader.readLine();
					System.out.println("서버로 부터 받은 메시지 : " + msg);

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						flag = false;
						bufferedWriter.close();
						bufferedReader.close();
						keyboaredBufferedReader.close();
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

		}

	}

	public static void main(String[] args) {
		new ClientFile();
	}

}
