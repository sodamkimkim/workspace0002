package ch04_mj;

import java.util.Scanner;

public class View {
	Scanner scanner = new Scanner(System.in);

	public int indexView() {
		System.out.println("================================");
		System.out.println("환영합니다.");
		System.out.println("================================");
		System.out.println("1. 직원정보 조회");
		System.out.println("2. 부서 최고연봉자 조회");
		System.out.println("3. 부서별 직원 수 조회");
		System.out.println("4. 직원 월봉/직급 조회");
		System.out.println("5. 장기근무자 조회");
		System.out.println("0. 종료");
		System.out.println("--------------------------------");
		System.out.print("입력: ");
		int select = scanner.nextInt();
		return select;
	}

	public String selectDepartView() {
		System.out.println("----------------------");
		System.out.println("Depart_Id Index");
		System.out.println("----------------------");
		System.out.println("1. Marketing");
		System.out.println("2. Finance");
		System.out.println("3. Human Resources");
		System.out.println("4. Production");
		System.out.println("5. Development");
		System.out.println("6. Quality Management");
		System.out.println("7. Sales");
		System.out.println("8. Research");
		System.out.println("9. Customer Service");
		System.out.println("-------------------------");
		System.out.print("부서를 선택해 주세요: ");
		int select = scanner.nextInt();
		String str = "d00"+select;
		return str;
	}

}
