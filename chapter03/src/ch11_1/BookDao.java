package ch11_1;

public interface BookDao {

//	    public static final float pi = 3.14F; 모든 변수 상수로 선언
//	    public void makeSomething(); 모든 메서드 추상메서드

	// C
	public void addBook(Book book);

	// R
	public void selectedByTitleBook(String string);

	public void showAllBook();

	// U
	public void updateBook(String title, Book book);

	// D
	public void deleteBook(String title);
	


}
