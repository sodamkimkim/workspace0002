package myLoopyTalk;

public interface ISocket {
	public void run();

	// write
	public abstract void sendMessage(String msg);// 서버 & 클라 둘다 강제

	// 프로토콜vs 메시지 구분
	public abstract void seperateProtocol(String msg); // 서버 & 클라 둘다 강제

}
