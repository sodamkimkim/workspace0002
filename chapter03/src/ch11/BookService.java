package ch11;

public interface BookService {
//추상- is a
// 인터- has a. 강제성, 규약, 표준
// 추이로 인해	ㅋㅋ 근데 일단 쉅때는 논리적이해보다는 공식처럼 빠르게 받아들이고 따라가자!!!!!!!!!
	
	// 북 객체를 저장하는 기능
	void addBook(Book book);
	
	// 북 객체를 수정하는 기능(ArrayList 인덱스에 접근해서 객체 교체)
	// String title로 접근해서 수정할 것임.  title 없으면 없습니다 출력
	void updateBook(String title, Book book);
	
	// 북 객체를 삭제하는 기능
	void deleteBook(String title);
	
	// 책 1권의 정보를 출력하는 기능
	void selectedByTitleBook(String title);
	
	// ArrayList에 저장 되어있는 책 정보를 전부 출력
	void showAllBook(); // 매개변수 필요 없다.


	
	
}
