package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author 김소담 입력 스트림 파일에서 한 바이트씩 데이터를 읽기 - 1 
 * 
 * try - with -resources : try(...)
 *         오토 클로즈 제공
 * 
 */
public class MainTest2_2 {

	public static void main(String[] args) {
		System.out.println("시작 - 파일에서 데이터를 읽어 화면에 출력해 주세요");
//		FileInputStream fis = null;
		try (FileInputStream fis = new FileInputStream("boot_a.txt")) { 
			// auto closed방식. fis.close안써도 된다. 
			// -> 자원을 닫아야 할때는 이 구문을 쓸 때, 코드 가독성이나 실수 방지 차원에서 좋다.
			int i;

			while ((i = fis.read()) != -1) {
//				System.out.print((char) fis.read());
				// while조건문에서 fis.read()하고나서 -(1)
				// 또 sysout한다고 fis.read()하면 -(2)
				// (1)값이 출력되는 것이 아니라 (2)값이 출력되어서
				// 문자를 불러올 때 띄엄띄엄 불러오게됨
				System.out.print((char) i);
//				System.out.println((char)fis.read()); // a 읽음

			}

		} catch (FileNotFoundException e1) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력오류");

		}
		System.out.println();
		System.out.println("끝.");
	}

}

//
//try {
//	fis = new FileInputStream("boot_a.txt");
//	int i;
//
//	while ((i = fis.read()) != -1) {
////		System.out.print((char) fis.read());
//		// while조건문에서 fis.read()하고나서  -(1)
//		// 또 sysout한다고 fis.read()하면 -(2)
//		// (1)값이 출력되는 것이 아니라 (2)값이 출력되어서 
//		// 문자를 불러올 때 띄엄띄엄 불러오게됨
//		System.out.print((char) i);
////		System.out.println((char)fis.read()); // a 읽음
//
//	}
//
//} catch (FileNotFoundException e1) {
//	System.out.println("파일이 없습니다.");
//} catch (IOException e) {
//	System.out.println("입출력오류");
//} finally {
//	try {
//		fis.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//System.out.println();
//System.out.println("끝.");
//}