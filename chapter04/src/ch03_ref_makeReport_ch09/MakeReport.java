package ch03_ref_makeReport_ch09;

public class MakeReport {

	private StringBuilder str= new StringBuilder("");
	// StringBuider, 사실 String도 new로 객체를 올려줘야함.
	private String line = "=============================\n";
	private String title;

	private String name;
	private String address;
	private String phone;

	// 생성자
	public MakeReport(String name, String address, String phone) {
		// 필요한 값이 있으면 초기화 한다.
		// 이스케이프 문자(제어문자)
		// 인쇄할 수 없거나 키보드로 표현할 수 없는 특별한 문자를 가리킨다.
		// 역슬래시와 한개의 문자와 결합하여 사용.

		this.title = "이름\t\t주소  전화번호     \n";
		this.name= name;
		this.address= address;
		this.phone= phone;
		

	}

	private void makeHeader() {

		// 처음부터 str += line 하면 str의 초기값인 null이 찍힌다.
		// int = 0
		// string = null
		// double = 0.0 초기값.
		str.append(title);
		str.append(line);
	}

	private void generateBody() {


		str.append(name + "\t");
		str.append(this.address + "\t");
		str.append(this.phone + "\n");

//		str += "김소담 \t";
//		str += "서울 \t";
//		str += "01012341234\n";

	}

	private void makeFooter() {
		str.append(line);
	}

	public StringBuilder getReport() {

		makeHeader();
		generateBody();
		makeFooter();
		
		return this.str;
	}
} // end of class
