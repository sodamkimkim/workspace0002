package ch11_1;

import java.util.ArrayList;

public class BookArrayList implements BookDao {

	ArrayList<Book> books = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		System.out.println("저장합니다.");
		books.add(book);
		showAllBook();

	}

	@Override
	public void selectedByTitleBook(String title) {
		System.out.println("조회합니다.");
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				System.out.println("books.get(i)");
				return;
			}

		}
		System.out.println("책을 찾을 수 없습니다.");
	}

	@Override
	public void showAllBook() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Override
	public void updateBook(String title, Book book) {
		System.out.println("수정합니다.");
		
		int bookIndex = -1;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				bookIndex = i;
			}

		}
		if(bookIndex == -1) {
			System.out.println(title + "이름의 책이 존재하지 않습니다.");
		} else {
			books.set(bookIndex, book);
		}
		showAllBook();

	}

	@Override
	public void deleteBook(String title) {
//		books.remove(i);

		boolean deleteOk = false;
		for (int i = 0; i < books.size(); i++) {
			// title이름과 맞는 걸 찾으면 해당 book 삭제
			// 못찾으면 없습니다 출력

			if (books.get(i).getTitle().equals(title)) {
				System.out.println("찾았습니다. 삭제합니다.");
				books.remove(i);
				deleteOk = true;

			}
			// for문 돌려서 title 책 정보 여러개 다 찾고
			// flag변수인 deleteOk 값 변경을 통해서
			// "책을 삭제하였습니다." 한번만 출력
		}

		if (deleteOk) {
			System.out.println(title + "책을 삭제하였습니다.");
		} else {
			System.out.println(title + "책 정보를 찾을 수 없습니다.");
		}

		showAllBook();

	}

}
