package ch11_1;

import java.util.Scanner;



public class MainTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BookDao bookArrayList = new BookArrayList();
		BookDao bookArray = new BookArray();
		BookClient bookClient = new BookClient();

		String userSelectedMenu = "";
		do {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("1. 책 생성 2. 책 조회 3. 책 삭제 4. 책 전체 조회 5. 책 수정 0. 프로그램 종료");
			System.out.println("-----------------------------------------------------------------------------");
			userSelectedMenu = removeBlankString(scanner.nextLine());

			if (userSelectedMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");

				/**
				 * 메뉴 - 1. 책 생성
				 */
			} else if (userSelectedMenu.equals("1")) {
				System.out.println("책 이름을 입력해 주세요.");
				String title = removeBlankString(scanner.nextLine());
				System.out.println("작가 이름을 입력해 주세요");
				String author = removeBlankString(scanner.nextLine());
				Book book = bookClient.createBook(title, author); // book 객체 생성

				bookArrayList.addBook(book); // book객체를 ArrayList에 저장

				/**
				 * 메뉴 - 2. 책 조회
				 */
			} else if (userSelectedMenu.equals("2")) {
				System.out.println("정보를 조회합니다. 책 제목을 입력해 주세요.");
				String title = removeBlankString(scanner.nextLine());
				bookArrayList.selectedByTitleBook(title);
				
				/**
				 * 메뉴 - 3. 책 삭제
				 */
			} else if (userSelectedMenu.equals("3")) {
				System.out.println("책을 삭제합니다. 책 제목을 입력해 주세요");
				String title = removeBlankString(scanner.nextLine());
				bookArrayList.deleteBook(title);

				/**
				 * 메뉴 - 4. 책 전체 조회
				 */
			} else if (userSelectedMenu.equals("4")) {
				System.out.println("저장 되어있는 책 목록 조회");
				bookArrayList.showAllBook();
				
				/**
				 * 메뉴 - 5. 책 수정
				 */
			} else if (userSelectedMenu.equals("5")) {
				System.out.println("수정하려는 책 제목을 입력해 주세요.");
				String titleOfOld = removeBlankString(scanner.nextLine());
				System.out.println("새로운 책 제목을 입력하세요.");
				String title = removeBlankString(scanner.nextLine());
				System.out.println("새로운 작가이름을 입력하세요.");
				String author = removeBlankString(scanner.nextLine());
				Book book = bookClient.createBook(title, author);
				bookArrayList.updateBook(titleOfOld, book);
				
				
				
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		} while (!userSelectedMenu.equals("0"));

	} // end of main

	public static String removeBlankString(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ", "");
		return result2;
	}

} // end of class
