package ch03_ref_makeReport_ch09;

public class MakeReportTest {

	public static void main(String[] args) {
		MakeReport makeReport1 = new MakeReport("김소담", "부산", "01050270220");
		MakeReport makeReport2 = new MakeReport("홍길동", "부산", "01050270220");
		

		
		System.out.println(makeReport1.getReport());
		System.out.println(makeReport2.getReport());
		
	}

}
