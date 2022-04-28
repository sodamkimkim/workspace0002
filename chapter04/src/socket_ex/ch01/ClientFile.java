package socket_ex.ch01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

	Socket socket;
	BufferedReader keyboaredBufferedReader; // 키보드에다가 연결할 Stream (InputStream)
	BufferedWriter bufferedWriter; // 소켓에다가 Stream을 연결할 outputStream
	// IP주소라는 것은..
	// @ IPv4..
	// ㄴ 전세계 IP라는것은 다 연결되어있다.
	// 주소는 각 컴퓨터의 아이덴터티를 나타내야한다. 그래야 스트림을 통해서 찾아갈 수 있다.
	// IPv4버전으로는 약42억개 정도가 만들어져 있다.
	// 확장이 필요해서 IPv6 만듬 => 더많은 주소 쓸 수 있음

	// 우리가 기억해야할 것? '고유한 주소값을 IP주소ㄱ라고 한다. 한대의 컴퓨터가 다른컴퓨터에 접근하기 위해서는
	// IP주소를 알아야 하고
	// 자기자신을 가리키는 주소도 알아야 하는데 그것은 (127.0.0.1) = localhost
	final String IP = "localhost"; // 자기 자신을 나타내는 주소 (127.0.0.1)
	final int PORT = 10010; // 아까 serverfile에서 지정한 포트번호

	public ClientFile() {
		try {
			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(IP, PORT); // IP에 목적지, Port에 목적지의 port번호

			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));// 출력이라서 키보드가 아니라 소켓에
																									// 연결

			// 키보드 연결
			System.out.println("3. 키보드 버퍼 연결");
			keyboaredBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("4. 키보드 입력 대기중..");
			String msg = keyboaredBufferedReader.readLine(); // 입력대기중

			// 클라이언트측 사용자에게 문자열을 받았으면 보내야 한다 -> 소켓에 연결되어있는 writer를 이용해서 보내야 한다.
			bufferedWriter.write(msg + "\n");
			// \n,, readLine으로 줄단위로 읽을 거기 때문에 메시지 끝을 알려줘야 한다.
			bufferedWriter.flush();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClientFile();
	}

}
