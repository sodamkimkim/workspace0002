package ch04_h;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeesManagerInfoDto {

	private String emp_no;
	private String birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	
	@Override
	public String toString() {
		return "EmployeesManagerInfoDto [emp_no=" + emp_no + ", birth_date=" + birth_date + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", gender=" + gender + "]\n";
	}
}