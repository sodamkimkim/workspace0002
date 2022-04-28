package ch04_pr;

public class MainTest {
	public static void main(String[] args) {
		Activity1 activity1 = new Activity1("화면1");
		Activity2 activity2 = new Activity2("화면2");
		activity2.setCallbackPosition(activity1.callback);
	}
}
