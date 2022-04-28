package myLoopyTalk;

import java.awt.event.ActionListener;

public interface IChatMessage extends ActionListener {
//인터페이스는 '기능'에대한정의 ..

	// 서버시작
	default void startServer() {
	}; // 자유

	// connect - > 서버에서는 thread로 socket.accept, 클라에서는 IP, Port넣는거
	public abstract void connect(); // 서버 & 클라 둘다 강제

	default void broadcast(String msg) {
	}; // 자유

	default void saveLogs(String log) {
	} // 서버만
} // end of interface
