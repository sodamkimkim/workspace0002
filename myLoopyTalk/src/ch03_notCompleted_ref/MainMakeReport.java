package ch03_notCompleted_ref;


public class MainMakeReport implements IMakeReport {
	String header;
	String body;
	String footer;

	public MainMakeReport() {
		new SubMakeReport(this);
		makeReport();
	}

	@Override
	public void header(String header) {
		this.header = header;

	}

	@Override
	public void body(String body) {
		this.body = body;

	}

	@Override
	public void footer(String footer) {
		this.footer = footer;
	}

	@Override
	public void makeReport() {
		System.out.println("--Report--");
		System.out.println(header);
		System.out.println(body);
		System.out.println(footer);
	}

}
