package socket_ex.ch03.pr_socketsss_ref;

import java.io.IOException;
import java.net.Socket;

public class MySocketClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = null;
			socket = new Socket("��������_������_IP��, ��������_��Ʈ��ȣ��_������", 1234); // ���� ������ ���� 
			System.out.println("������ ���� ����!"); // ���� Ȯ�ο�
			
			ListeningThread t1 = new ListeningThread(socket); // �������� ���� �޼��� �д� Thread
			WritingThread t2 = new WritingThread(socket); // ������ �޼��� ������ Thread

			t1.start(); // ListeningThread Start
			t2.start(); // WritingThread Start
            
		} catch (IOException e) {
			e.printStackTrace(); // ����ó��
		}
	}
}

