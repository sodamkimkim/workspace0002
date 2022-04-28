package ch02_ref;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HackerNews implements IWriteArticle {
	// 응답자. MinActivity 역할
	// 꾸며주는 기능

	private String printDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return dateFormat.format(Calendar.getInstance().getTime());
	}

	@Override
	public void PrintArticle(String article) {
		System.out.println("*********HackerNews********");
		System.out.println();
		System.out.println(article);
		System.out.println();
		System.out.println("기사 작성일 : " + printDate());
	}
}
