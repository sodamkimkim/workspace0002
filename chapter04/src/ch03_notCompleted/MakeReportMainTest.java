package ch03_notCompleted;

import ch02.HackerNews;
import ch02.MyArticle;

public class MakeReportMainTest {

	public static void main(String[] args) {
		MainMakeReport mainMakeReport = new MainMakeReport();
		SubMakeReport subMakeReport = new SubMakeReport(mainMakeReport);
		subMakeReport.myHeader("야호 마이 헤더 작성중");
		subMakeReport.myBody("야호 마이 본문 작성중");
		subMakeReport.myFooter("야호 footer작성중");

	}

}

//
//HackerNews hackerNews = new HackerNews();
//// 기사 작성
//MyArticle article = new MyArticle("오늘 날씨가 좋음!!!", hackerNews);
//article.complete();