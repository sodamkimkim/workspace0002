package myDiary;

public interface IMyDiary {

	String printDiaryHeader(String name, String header);

	String printDiaryBody(String body);

	String printDiaryFooter(String footer);

	String completeDiary();
}
