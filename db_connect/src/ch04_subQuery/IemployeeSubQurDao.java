package ch04_subQuery;

import java.util.ArrayList;
public interface IemployeeSubQurDao {
	// senior engineer 뽑기
	ArrayList<SQDto> selectSeniorEngineers();
	// 직원별 이름과 직함 뽑기
	ArrayList<SQDto> selectEmployeeTitle();
	// 직원별 이름, 직함, 부서번호 뽑기
	ArrayList<SQDto> selectEmployeeTitleDepno();
	// 직원별 이름, 직함, 부서번호, 부서이름 뽑기
	ArrayList<SQDto> selectEmployeeTitleDepname();
	// staff 생일 뽑기
	ArrayList<SQDto> selectstaffBirth();
	

}
