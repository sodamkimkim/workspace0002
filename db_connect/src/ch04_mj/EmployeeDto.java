package ch04_mj;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {
	private String Employeeid;
	private String EmployeeName;
	private char gender;
	private String depart;
	private String title;
	
	
	@Override
	public String toString() {
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("id: " + Employeeid);
		System.out.println("이름: " + EmployeeName);
		System.out.println("성별: " + gender);
		System.out.println("근무 부서: " + depart);
		System.out.println("직급: " + title);
		return "";
	}
	
	

}