package ch06_mContext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserSocket extends Thread {
	Server mContext;
	Socket socket;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;

	// 의존성 컴포지션 관계
	public UserSocket(Server mContext, Socket socket) {
		this.mContext = mContext;
		// 생성자 객체가 메모리에 올라 갈 때 필요한 데이터 초기화.
		this.socket = socket;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						String msg = bufferedReader.readLine();
						System.out.println("서버에 있는 userSocket's msg : " + msg);
						mContext.broadcast(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}

		}).start();
	}

	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
