package myDiaryCallback_ref;

import lombok.Data;

@Data
public class WriteMyDiary {
	IMyDiary completeDiary = new CompleteDiary();

	String name;
	String header;
	String body;
	String footer;

	public WriteMyDiary(String name, String header, String body, String footer, IMyDiary completeDiary) {
//		WriteMyDiary wmd = new WriteMyDiary("name", "header", "body", "footer", cd);
		this.completeDiary = completeDiary;
		this.name = name;
		this.header = header;
		this.body = body;
		this.footer = footer;
	}

	public void complete() {
		completeDiary.printDiaryHeader(name, header);
		completeDiary.printDiaryBody(body);
		completeDiary.printDiaryFooter(footer);
	}

}
