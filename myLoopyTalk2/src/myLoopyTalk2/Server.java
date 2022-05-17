package myLoopyTalk2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {
	private int portNum;
	private Socket socket;
	private ServerSocket serverSocket;
	private ServerFrame mContext;

	private Vector<UserInformation> vcUserInfo = new Vector<UserInformation>();

	public Server(ServerFrame mContext) {
		this.mContext = mContext;
	}

	public void startNetwork() {
		try {
			serverSocket = new ServerSocket(portNum);
			mContext.getTxtArea().append("통신을 시작합니다." + " 포트번호: " + portNum);
			mContext.getFldPortNum().setEditable(false);
			mContext.getBtnServerStart().setEnabled(false);
			mContext.getBtnServerStop().setEnabled(true);
			connect();
		} catch (IOException e) {
			mContext.getTxtArea().append("서버 중지됨!!");
			e.printStackTrace();
		}
	}

	public void connect() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					// 사용자 접속 기다리기
					mContext.getTxtArea().append("사용자의 접속을 기다립니다.");
					// ServerSocket에 연결되면 새 socket생성.
					socket = serverSocket.accept();
					// list에 각 thread등록시켜주기
					
				} catch (IOException e) {
					mContext.getTxtArea().append("서버 중지됨!!");
					e.printStackTrace();
				}

			}
		});
		thread.start();
	}
}
