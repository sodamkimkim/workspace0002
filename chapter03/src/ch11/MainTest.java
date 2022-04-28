package ch11;

import java.util.Scanner;

public class MainTest {


	// 딱딱 떨어지게 생각하지말고
	// 일단 '이게 맞겠구나' 단순흡수, 단순 코딩!
	public static void main(String[] args) {
		


		// main에서만 스캐너 쓰도록 설계할 것임.
		Scanner scanner = new Scanner(System.in);
		BookClient bookClient = new BookClient();
		BookService bookArrayList = new BookArrayList();
//		BookArrayList bookArrayList = new BookArrayList(); 랑 같음

		// do - while문
		String selectedMenu = "";
		do {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1. 책 생성 2. 책 조회 3. 책 삭제 4. 책 전체 조회 5. 책 수정 0. 프로그램 종료"); // 인터페이스에서 선언한거 하나씩 구현할 거임
			System.out.println("----------------------------------------------------------------------------");
			selectedMenu = scanner.nextLine();

			if (selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
			} else if (selectedMenu.equals("1")) {

				bookClient.printTitle(); // 이렇게 client에 빼주면 더 꾸미거나 수정하기 쉬워진다.
				// 리펙토링: 성능이 아니라 가독성과 유지보수를 위해 코드를 가공해 주는 것.
				
				
				// 북 객체를 생성하는 코드 작성할건데 우리는 클라이언트를 만들어놨음.
				// 역할을 분담해야 유지보수가 쉽다.
				String title = scanner.nextLine();
				System.out.println("작가의 이름을 입력하세요");
				String author = scanner.nextLine();
				Book book = bookClient.createBook(title, author);

				bookArrayList.addBook(book);
				

				/**
				 * 메뉴 - 2. 책 조회
				 */
			} else if (selectedMenu.equals("2")) {
				System.out.println("책 제목을 입력해 주세요. (정보를 조회합니다.)");
				String title = scanner.nextLine();
				bookArrayList.selectedByTitleBook(title);

				
				/**
				 * 메뉴 - 3. 책 삭제
				 */
			} else if (selectedMenu.equals("3")) {
				System.out.println("삭제하려는 책 제목을 입력해 주세요.");
				String title = scanner.nextLine();
				bookArrayList.deleteBook(title);
		
				
				/**
				 * 메뉴 - 4. 책 전체 조회
				 */
			} else if (selectedMenu.equals("4")) {
				System.out.println("저장 되어있는 책 목록 조회");
				bookArrayList.showAllBook();
				
				/**
				 * 메뉴 - 5. 책 수정
				 */
			} else if (selectedMenu.equals("5")) {
				System.out.println("수정하려는 책 제목을 입력해 주세요");
				String savedTitle = scanner.nextLine();
				System.out.println("새로운 책 제목을 입력하세요.");
				String title = scanner.nextLine();
				System.out.println("새로운 작가 이름을 입력하세요.");
				String author = scanner.nextLine();
				Book book = bookClient.createBook(title, author); //////////////////////***************			
				bookArrayList.updateBook(savedTitle, book);//////////////////////******************
			
			
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		} while (!selectedMenu.equals("0")); // 0이라면 종료 / !=는 주소값을 비교한다. 문자값 비교할 때는 equals 써야한다.

	} // end of main
	
	public static String removeBlankString(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ", "");
		return result2;
		
	}

} // end of class
