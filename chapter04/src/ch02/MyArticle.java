package ch02;

// 호출자.
// 인터페이스를 멤버변수로 선언
public class MyArticle {

	String article;
	WriteArticle onWriteArticle; // 콜백의 인터페이스는 on을 잘붙임

	// 주소값 연결
	// -> 1. 생성자에서 연결하는 방법

	public MyArticle(String article, WriteArticle onWriteArticle) {
		this.article = article;
		this.onWriteArticle = onWriteArticle;
	}

	public void complete() {
		// 이 메서드가 호출되어지면
		// 작성한 article전달.

		onWriteArticle.PrintArticle(article);
	}
}
