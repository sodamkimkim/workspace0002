package stream_ex;

import java.io.InputStream;

// 1. 키보드에 A를 인코딩해서 01000001로 컴퓨터에게 전송
// 2. Byte Stream으로 흘러들어간다 (Input Stream발생)
// 3. read메서드로 2진수인 01000001 -> 65로 디코딩한다. 
// 4. 65를 문자A로 변환(부호화)
// 단점) 1바이트만 받음
// ABC -> A

public class StreamEx01 {
	public static void main(String[] args) {

		InputStream in = System.in; // 키보드에 연결
		try {
			int data = in.read(); // 1바이트(8bit)로 받을 거임
			System.out.println(data);
			System.out.println((char) data);// 부호화

		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());

		}
	}

//키보드와 연결해 주는 것은 사실 운영체제 system이 해주는 거임
}
