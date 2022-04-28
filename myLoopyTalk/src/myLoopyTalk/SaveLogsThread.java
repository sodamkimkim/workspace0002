package myLoopyTalk;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLogsThread extends Thread {
	BufferedWriter bufferedWriter;

	public SaveLogsThread() {
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("myLoopyTalk.txt", true));

		} catch (IOException e) {
			System.out.println("로그쓰레드 생성예외발생 : " + e.getMessage());
			e.printStackTrace();

		}
	}

	public void saveLogInFile(String log) {
		try {
			bufferedWriter.write(log + "\n");
			bufferedWriter.flush();
		} catch (IOException e) {
			System.out.println("로그저장예외발생 : " + e.getMessage());
			e.printStackTrace();
			try {
				bufferedWriter.close();
			} catch (IOException e1) {
				System.out.println("로그쓰레드종료 예외발생: " + e.getMessage());
				e1.printStackTrace();

			}
		}
	}
}
