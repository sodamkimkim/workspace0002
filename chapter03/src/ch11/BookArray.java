package ch11;

public class BookArray implements BookService {

	Book[] books = new Book[10];

	@Override
	public void addBook(Book book) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = book;
				showAllBook();
				return;
			}
		}
		System.out.println("저장할 공간이 부족합니다.");

	}

	@Override
	public void updateBook(String title, Book book) {

		int bookIndex = -1;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getTitle().equals(title)) {
					bookIndex = i;

				}
			}
		}
		if (bookIndex == -1) {
			System.out.println(title + "이름의 책이 존재하지 않습니다.");
		} else {

			books[bookIndex] = book;

		}
		showAllBook();
	}

	@Override
	public void deleteBook(String title) {

		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getTitle().equals(title)) {
					books[i] = null;

				}
			}
		}

	}

	
	
	
	
	
	
	
	
	

	@Override
	public void selectedByTitleBook(String title) {
		System.out.println("조회합니다.");
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getTitle().equals(title)) {
					System.out.println(books[i]);

				}
			}

		}

		System.out.println("책을 찾을 수 없습니다.");
	}

	@Override
	public void showAllBook() {

		System.out.println("현재 저장된 배열 데이터 확인");
		for (Book book : books) {
			System.out.println(book);
		}

	}

}
