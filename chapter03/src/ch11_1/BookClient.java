package ch11_1;


public class BookClient {
	
	private static int serialBookNumber = 0;
	
	// c
	public Book createBook(String title, String author) {
		serialBookNumber++;
		return new Book(serialBookNumber, title, author);
	}
	
	// R
	
	// U
	
	// D
} // end of BookClient
