package ch03_notCompleted;

import ch02.WriteArticle;

public class SubMakeReport {
	IMakeReport onMakeReport;
	String myHeader;
	String myBody;
	String myFooter;

	public SubMakeReport(IMakeReport onMakeReport) {
		this.onMakeReport = onMakeReport;
		this.complete();

	}

	public void myHeader(String myHeader) {
		this.myHeader = myHeader;
	}

	public void myBody(String myBody) {
		this.myBody = myBody;
	}

	public void myFooter(String myFooter) {
		this.myFooter = myFooter;
	}

	public void complete() {
		onMakeReport.header(myHeader);
		onMakeReport.body(myBody);
		onMakeReport.footer(myFooter);
		onMakeReport.makeReport();

	}

} // end of class

//
//String article;
//WriteArticle onWriteArticle; // 콜백의 인터페이스는 on을 잘붙임
//
//// 주소값 연결
//// -> 1. 생성자에서 연결하는 방법
//
//public MyArticle(String article, WriteArticle onWriteArticle) {
//	this.article = article;
//	this.onWriteArticle = onWriteArticle;
//}
//
//public void complete() {
//	// 이 메서드가 호출되어지면
//	// 작성한 article전달.
//
//	onWriteArticle.PrintArticle(article);
//}