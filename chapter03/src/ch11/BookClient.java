package ch11;

public class BookClient {

	// 매개변수로 객체를 넘겨주는 클래스
	// DB의 입맛에 맞게 변경
	public static int serialBookNumber = 0;
	

	
	// c
	public Book createBook(String title, String author) {
		serialBookNumber++;
		return new Book(serialBookNumber, title, author);
	}
	
	// R
	
	// U
	
	// D
	
	public void printTitle() {
		System.out.println("책 제목을 입력합니다.");
		System.out.println("공백은 입력하지 마세요");
	}
}
