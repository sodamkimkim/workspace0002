package ch12;

import java.util.logging.Logger;

class Student {
	String name;
	int grade;
}

public class MyLog {
	public static void main(String[] args) {
		// 로그 남겨보기
		Logger logger = Logger.getLogger("MyLog");

		Student student = null;

		try {
			student.name = "홍길동";

		} catch (NullPointerException e) {
			e.printStackTrace(); // 오류 내용만 알려줌. Cannot assign field "name" because "student" is null
			System.out.println("-----------------------------------------");
			logger.warning("오류확인 : " + e.toString()); // error좀 더 디테일하게 알려준다. 시간같은거도 
		}
		System.out.println("여기코드 실행 확인");

	} // end of main

} // end of class
