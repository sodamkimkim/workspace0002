package ch04_mj;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor

public class DepartNumberEmployeeDto {
	private String departid;
	private String count;
	private String departName;

	private void searchName() {
		switch (departid.charAt(3)) {
		case '1':
			departName = "Marketing";
			break;
		case '2':
			departName = "Finance";
			break;
		case '3':
			departName = "Human Resources";
			break;
		case '4':
			departName = "Production";
			break;
		case '5':
			departName = "Development";
			break;
		case '6':
			departName = "Quality Management";
			break;
		case '7':
			departName = "Sales";
			break;
		case '8':
			departName = "Research";
			break;
		case '9':
			departName = "Customer Service";
		}
	}

	@Override
	public String toString() {
		if(departName == null || departName.equals("")) {
			searchName();
		}
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("부서 ID: " + departid);
		System.out.println("인원 수: " + count);
		System.out.println("부서 이름: " + departName);
		return "";
	}

}