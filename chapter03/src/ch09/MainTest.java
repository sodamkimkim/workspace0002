package ch09;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		BookClient bookClient = new BookClient();
		Scanner scanner = new Scanner(System.in);
		
		String bookTitle = null;
		String bookAuthor = null;
		int bookId = 0;
		

		boolean flag = true;
		int userSelectedMenu = 0;
		int dateOfPublished=0;

		while (flag) {
			System.out.println("1. 책 정보 입력 | 2. 책 정보 수정 | 3. 책 정보 삭제 | 4. 책정보 읽어오기 | 5. 종료");
			if (userSelectedMenu == 1) {
				
				System.out.println("책 이름 : ");
				bookTitle = scanner.nextLine();
				System.out.println("작가 이름 : ");
				bookAuthor = scanner.nextLine();
				System.out.println("발간일 : 예) 220330 ");
				dateOfPublished = scanner.nextInt();
				bookClient.insertBookInfo(bookTitle, bookAuthor, dateOfPublished);
			} else if (userSelectedMenu == 2) {
				// 책 이름 받아서 작가 | 발간일 수정
			
				System.out.println("책 이름 : ");
			} else if (userSelectedMenu == 3) {

			} else if (userSelectedMenu == 4) {

			} else if (userSelectedMenu == 5) {
				flag = false;
			} else {

				System.out.println("메뉴를 다시 선택해 주세요");
			}
		} // end of while

	} // end of main

} // end of class
