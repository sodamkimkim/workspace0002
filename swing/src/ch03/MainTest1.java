package ch03;

import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) {
		// 1. MyComponent 화면에 띄우기
		// 2. textField안녕하세요라는 글자를 코드로 셋팅해 주세요
		MyComponents components = new MyComponents();

		Scanner scanner = new Scanner(System.in);
		System.out.println("글자를 입력하세요");
		String userInput = scanner.nextLine();

		components.textField.setText(userInput);
		

	} // end of main

} // end of class
