package myDiary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.Data;

@Data
public class CompleteDiary implements IMyDiary {

	String text;
	String fileName = "myDiary.txt";
	String name;
	String header;

	String body;
	String footer;

	private String completeDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return dateFormat.format(Calendar.getInstance().getTime());

	}

	@Override
	public String printDiaryHeader(String name, String header) {
		String headDeco = "******** My Diary********";
		this.name = name;
		this.header = header;

		return headDeco + "\n" + completeDate() + "\n작성이 : " + name + "\n제목 : " + header;

	}

	@Override
	public String printDiaryBody(String body) {
		this.body = body;
		return "\n본문내용 : " + "\n" + "\t\t\t" + body;
	}

	@Override
	public String printDiaryFooter(String footer) {
		this.footer = footer;
		return "\n꼬릿말 : " + "\n" + "\t\t\t" + footer;
	}

	@Override
	public String completeDiary() {

		return printDiaryHeader(name, header) + printDiaryBody(body) + printDiaryFooter(footer);
	}

}
