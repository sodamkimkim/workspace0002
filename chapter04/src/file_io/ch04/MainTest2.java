package file_io.ch04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainTest2 {

	public static void main(String[] args) {
		String text = "File Writer Test";
		String fileName = "result.txt";

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(text);
	
			// 보조스트림이라서
			// 실제로 파일에 쓰는 기능은 없음
			// 그냥 기능 확장

			// 버퍼는 자기 공간이 다 채워지면 자동으로 전달한다.
			// 버퍼라는 임시공간에 저장하고, 여유공간이 남아있어서 아직 출력은 안된다.
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
