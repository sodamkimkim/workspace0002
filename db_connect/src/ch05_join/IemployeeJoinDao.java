package ch05_join;

import java.util.ArrayList;

public interface IemployeeJoinDao {
	
	// 직원별 salary 뽑기
	ArrayList<Dto> selectSalary();
	// 재직중인 직원별 부서 조회
	ArrayList<Dto> selectDepartmentCurrentlyemployed();
	// 매니저별 부서이름 뽑기
	ArrayList<Dto> selectManagerDepartment();
	// 직원별 입사일과 부서 조회
	ArrayList<Dto> selectFromdateDepartment();
	// 재직중인 매니저 뽑기
	ArrayList<Dto> selectCurrentlyemployedManager();
}
