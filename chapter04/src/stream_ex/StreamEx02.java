package stream_ex;

import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {
	public static void main(String[] args) {

		InputStream in = System.in; // 키보드에 연결
		// 기능을 확장을 위해서 상속이라는 구조대신
		// ++ decoration pattern으로 되어있음
		// 인풋통신은 1바이트단위로 통신하는건데.. (단점 명확)
		// InputStreamReader사용
		InputStreamReader ir = new InputStreamReader(in); // 기능 확장만 일어남
		// ㄴ --> 추가하면서 점진적으로 나아감 -> 데코레이터 패턴 방식
		// 형변환 강제적으로 하지 않더라도 65 --> A부호화가 일어남.

		try {
//			int data = in.read(); // 1바이트(8bit)로 받을 거임
			char[] data = new char[3]; // A, B, C 받기 위해 char공간 3개 필요
			ir.read(data);
			
			// new char[1000]
			// A한개만 입력 -> 999개의 공간 낭비 발생
			// 잘 사용하지 않음. (특히 통신에서 사용안한다.)
			// => sol) 버퍼 사용
			
			System.out.println(data);
//			System.out.println((char) data);// 부호화

		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());

		}
	}

//키보드와 연결해 주는 것은 사실 운영체제 system이 해주는 거임
}
