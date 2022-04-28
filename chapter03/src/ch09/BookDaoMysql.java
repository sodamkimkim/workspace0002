package ch09;

import java.util.ArrayList;

public class BookDaoMysql implements BookDao {

	// 인터페이스를 활용해서 기능 구현
	// ArrayList 사용

	int bookId;
	String bookTitle;
	String author;


	ArrayList<Book> books = new ArrayList<>();

	@Override
	public void insertBookInfo(Book book) {
		this.books.add(book);
		System.out.println("책 " + book.getTitle() + " 정보가 입력되었습니다.");

	}

	@Override
	public void updateBookInfo(Book book) {
		this.books.set(book.getId(), book);
		System.out.println(book.getId() + "번째 책 정보가 수정되었습니다.");

	}

	@Override
	public void deleteBookInfo(Book book) {
		this.books.remove(book.getId());
		System.out.println(book.getId() + "번째 책 정보가 삭제되었습니다.");
	}

	@Override
	public void readBookInfo(Book book) {

		if(bookId==book.getId()) {
			book.toString();
		}else {
			System.out.println("책 정보가 존재하지 않습니다.");
		}
	
		
	}

}
