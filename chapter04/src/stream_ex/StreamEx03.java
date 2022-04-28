package stream_ex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

// decorator pattern으로 기능 확장할 것임.
public class StreamEx03 {
	public static void main(String[] args) {

		InputStream in = System.in; // 키보드에 연결
		InputStreamReader ir = new InputStreamReader(in); // 65 --> A
		BufferedReader br = new BufferedReader(ir); // String으로 받을 수도 있다.!!!!!
		// 통신에는 항상 인코딩 디코딩개념이 들어간다.
		// 좋은 프레임워크일 수록 버퍼가 달려있다.
		try {
			String data = br.readLine();
			System.out.println(data);
		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());

		}
	}

//키보드와 연결해 주는 것은 사실 운영체제 system이 해주는 거임
}
