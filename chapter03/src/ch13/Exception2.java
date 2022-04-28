package ch13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception2 {
	public static void main(String[] args) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("b.txt");
//			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // e 내용 (오류내용) 찍어줌
			System.out.println("파일이 없습니다.");
			
		}finally {
			// 반드시 실행되는 영역임
			// 심지어 return 키워드를 만나도 실행되는 영역임
			System.out.println("fianlly는 반드시 실행되는 영역입니다.");
		}
		System.out.println("코드가 실행이 되나요? 네.");

	}
}
