package myDiary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ch02.MyArticle;

public class MyDiaryMainTest {
	public static void main(String[] args) {

		CompleteDiary cd = new CompleteDiary();
		WriteMyDiary wmd = new WriteMyDiary("김소담", "문자단위 스트림 배운날", "많이배웠다.", "참 즐거운 하루였다.", cd);
		wmd.complete();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("myDiary.txt"));
			bw.write(cd.completeDiary());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}

	}
	

}
