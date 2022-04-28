package socket_ex.ch03.pr_socketsss_ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MySocketServer extends Thread {
	static ArrayList<Socket> list = new ArrayList<Socket>(); // ���� Ȯ�ο�
	static Socket socket = null;
	
	public MySocketServer(Socket socket) {
		this.socket = socket; // ���� socket�� �Ҵ�
		list.add(socket); // ������ list�� �߰�
	}
	
    public void run() { // Thread ���� start() �޼ҵ� ��� �� �ڵ����� �ش� �޼ҵ� ���� (Thread���� ������ ����)
		try {
			System.out.println("���� : " + socket.getInetAddress() + " IP�� Ŭ���̾�Ʈ�� ����Ǿ����ϴ�"); // ���� Ȯ�ο�
			
			// InputStream - Ŭ���̾�Ʈ���� ���� �޼��� �б�
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			// OutputStream - �������� Ŭ���̾�Ʈ�� �޼��� ������
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
			
			// Ŭ���̾�Ʈ���� ����Ǿ��ٴ� �޼��� ������
			writer.println("������ ����Ǿ����ϴ�! ID�� �Է��� �ּ���!");
			
			String readValue; // Client���� ���� �� ����
			String name = null; // Ŭ���̾�Ʈ �̸� ������
			boolean identify = false;
			
			while((readValue = reader.readLine()) != null ) { // Ŭ���̾�Ʈ�� �޼��� �Է½ø��� ����
				if(!identify) { // ���� �� �ѹ��� ����
					name = readValue; // �̸� �Ҵ�
					identify = true;
					writer.println(name + "���� �����ϼ̽��ϴ�.");
					continue;
				}
				
				for(int i = 0; i<list.size(); i++) { // list �ȿ� Ŭ���̾�Ʈ ������ �������
					out = list.get(i).getOutputStream();
					writer = new PrintWriter(out, true);	
					writer.println(name + " : " + readValue); // Ŭ���̾�Ʈ���� �޼��� �߼�
				}
			}
		} catch (Exception e) {
		    e.printStackTrace(); // ����ó��
		}    		
    }	
	
	public static void main(String[] args) {
		try {
			int socketPort = 1234; // ���� ��Ʈ ������
			ServerSocket serverSocket = new ServerSocket(socketPort); // ���� ���� �����
			System.out.println("socket : " + socketPort + "���� ������ ���Ƚ��ϴ�"); // ���� ���� Ȯ�ο�
			
            // ���� ������ ����� ������ ���ѷ���
            while(true) {
                Socket socketUser = serverSocket.accept(); // ������ Ŭ���̾�Ʈ ���� ��
                Thread thd = new MySocketServer(socketUser); // Thread �ȿ� Ŭ���̾�Ʈ ������ �����
                thd.start(); // Thread ����
            }                 
            
		} catch (IOException e) {
			e.printStackTrace(); // ����ó��
		}

	}

}
