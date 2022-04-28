package ch09_h;

public interface BookDao {
	
// 서비스
	
	
	// 저장하는 메서드
	void insertBookInfo(Book book);
	
	// 수정하는 메서드
	void updateBookInfo(Book book);
	
	// 삭제하는 메서드
	void deleteBookInfo(Book book);
	
	// 출력하는 메서드
	void readBookInfo(Book book);
}
