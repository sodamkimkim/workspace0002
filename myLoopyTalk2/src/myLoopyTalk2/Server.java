package myLoopyTalk2;

import java.net.ServerSocket;
import java.net.Socket;

import lombok.Data;

@Data
public class Server {
	private int portNum;
	private Socket socket;
	private ServerSocket serverSocket;

}
