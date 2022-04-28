package myLoopyTalk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class UsersocketFC extends Thread implements ISocket {

	boolean readThreadFlag;
	Client mClient;
	Socket socket;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	public UsersocketFC(Client mContext, Socket socket) {
		this.mClient = mContext;
		this.socket = socket;
		readThreadFlag = true;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("클라이언트 소켓 예외발생:" + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (readThreadFlag) {
			try {
				String msg = bufferedReader.readLine();
				System.out.println("서버로 부터 받은 메시지: " + msg);
			} catch (IOException e) {
				System.out.println("예외발생 :" + e.getMessage());
				e.printStackTrace();
				try {
					bufferedReader.close();
					bufferedWriter.close();
					socket.close();
					JOptionPane.showMessageDialog(null, "서버가 종료됨!!", "알림", JOptionPane.ERROR_MESSAGE);
					break;
				} catch (IOException e1) {
					e1.printStackTrace();
					break;
				}

			}

		}

	}

	@Override
	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
			System.out.println("서버로 보낼거야. sendMessage : " + msg);

		} catch (IOException e) {
			System.out.println("예외발생 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void seperateProtocol(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "/");
		String protocol = st.nextToken();
		String message = st.nextToken();

		System.out.println("프로토콜 : " + protocol);
		System.out.println("메시지 : " + message);

		if (protocol.equals("NewUser")) {
//			mClient.add(mess)
		}
	}

}
