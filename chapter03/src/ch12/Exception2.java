package ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception2 {
	public static void main(String[] args) {

		FileInputStream fis;
		try { // 예외가 발생할 수 있는 코드

			fis = new FileInputStream("a.txt"); // a.txt 파일 들고옴 stream은 빨대라고 생각
//			return;
			
		} catch (FileNotFoundException e) { // 예외를 어떻게 처리해야 하는지 작성하는 부분

			e.printStackTrace(); // e내용 (오류내용) 찍어줌
			System.out.println("파일이 없습니다.");
		} finally {
			
			// 여기는 반드시 실행되는 영역임
			// 심지어 return 키워드를 만나도 실행되는 영역임
			
			System.out.println("finally -> 반드시 실행되는 영역입니다.");
		}
		
		System.out.println("코드가 실행이 되나요?");
	}
}
