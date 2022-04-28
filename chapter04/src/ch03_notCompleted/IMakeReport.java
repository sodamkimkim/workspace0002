package ch03_notCompleted;

public interface IMakeReport {
	public abstract void header(String header);

	public abstract void body(String body);

	public abstract void footer(String footer);

//	public abstract void makeReport(String myHeader, String myBody, String myFooter);
	public abstract void makeReport();

}
