package myLoopyTalk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

//@Data
public class UsersocketFS extends Thread implements ISocket {

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	private Socket userSocket;
	private String userNickName;
	private String myCurrentRoomName;

	IServerAndUserSocket serverCallback; // callback인터페이스 이용해서 server랑 연결
	Server mServer; // 서버의 mContext

	public UsersocketFS(IServerAndUserSocket serverCallback, Server serverMContext, Socket socket) {
		System.out.println("생성확인!!!!!");
		this.serverCallback = serverCallback;
		this.mServer = serverMContext;
		this.userSocket = socket;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(userSocket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		network();
	}

	public void network() {
		try {
			userNickName = bufferedReader.readLine();
			mServer.textArea.append("[" + userNickName + "] 입장\n");
			//기존사용자들에게 신규 유저의 접속을 알린다.
			mServer.broadcast("NewUser/" + userNickName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() { // data 읽기

		while (true) {
			try {
				System.out.println("여기 확인 server!!!");
				String msg = bufferedReader.readLine();
				mServer.fileLog(msg);
				System.out.println("여기 찍히나요?");
				mServer.textArea.append("[" + userNickName + "]" + msg + "/n");
				serverCallback.broadcast(msg);
				seperateProtocol(msg);
				System.out.println("클라이언트로부터 받은 메시지: " + msg);

			} catch (IOException e) {
				try {
					mServer.textArea.append(userNickName + ":사용자 접속 끊어짐\n");
					bufferedReader.close();
					bufferedWriter.close();
					userSocket.close();
					mServer.vcUsers.remove(this);
					mServer.broadcast("UserOut/" + userNickName);
					mServer.broadcast("ErrorOutRoom/" + myCurrentRoomName);
					mServer.broadcast("UserData_Update/ok");
					break;
				} catch (IOException e1) {
					System.out.println("예외발생 : " + e.getMessage());
					e1.printStackTrace();
					break;
				}

			}

		}

	}

	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
			System.out.println("클라이언트한테 보낼거야 " + msg);
		} catch (IOException e) {
			System.out.println("예외발생 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void seperateProtocol(String msg) { // 서버가read받은 메시지를 seperate함.
		StringTokenizer st = new StringTokenizer(msg, "/");
		// 메모리 낭비 문제 때문에 새로운 객체는 최대한 쓸 때만 생성해 주는게 좋다.
		// 쌤의 Chatting - Server.java파일에서는 
		// server와 socket이 분리되어있지 않다,
		// 그래서 특히 server에서 멤버변수로 StringTokenizer st를 선언해 버리면
		// st는 쓰레드들의 공유자원이 된다.
		// 그렇게 되면 userSocket들이 접근을 하려고 할 때 cpu의 부하가 커지게 된다.
		// 그래서 쌤 코드에서 inmessage()에서 st를 생성해 주거나,
		// 내 코드 처럼 thread클래스인 UsersocketFS에 선언해 준다.
		// 특히 쓰레드 안에서도 멤버변수 보다
		// 메서드에 생성해 주면 st 쓰고 바로 내려가니까 더 좋다.
		String protocol = st.nextToken();
		String message = st.nextToken();

		System.out.println("protocol:" + protocol);
		System.out.println("message:" + message);

		if (protocol.equals("PrivateMsg to")) {

			System.out.println(message);
			st = new StringTokenizer(message, "@");

			String targetUser = st.nextToken();
			String privateMsg = st.nextToken();

			for (int i = 0; i < mServer.vcUsers.size(); i++) {
				UsersocketFS u = mServer.vcUsers.elementAt(i);
				// elementAt(i)
				// 명시된 index의 component를 리턴해줌.
				// get(i)이 메서드랑 기능적으로 같다!!(identical)
				if (u.userNickName.equals(targetUser)) {
					u.sendMessage("PrivateMsg to/" + userNickName + "@" + privateMsg);
				}
			}
		} else if (protocol.equals("CreateRoom")) {
			// TODO
		}
//TODO
	}
} // end of class
