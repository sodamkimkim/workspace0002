package ch09;

public class Book {
	private int id;
	private String title;
	private String author;
	private int dateOfPublished;

	
	
	
	
	public int getDateOfPublished() {
		return dateOfPublished;
	}

	public void setDateOfPublished(int dateOfPublished) {
		this.dateOfPublished = dateOfPublished;
	}

	public Book(int id, String title, String author, int dateOfPublished) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.dateOfPublished = dateOfPublished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

} // end of class
