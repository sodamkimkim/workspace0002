package file_io.ch01;

import java.io.IOException;

public class MainTest2 {

	public static void main(String[] args) {
		System.out.println("알파벳 여러개 쓰고 엔터");
		int i;
		try {
			// 알파벳 여러개를 쓰고, 화면에 출력할 수 있도록 코드를 변경하자.
			// 버퍼스트림 쓰면되지만, 그거말고 다른방법으로!!
			// 반복문 사용하는데 얼마나 입력할지 모르니까 for문 말고 while사용

			while ((i = System.in.read()) != '\n') {
				// 입력스트림을 열어서 변수에 입력값을 1바이트씩 넣는다.
				// 연산을 일으킨 후 i에 저장,
				// 엔터치면
				// 연산결과가 false되어서 반복문이 종료된다.

				System.out.print("i : " + i);
				System.out.print("는 " + (char) i + "이다.");
				System.out.print("\t");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
