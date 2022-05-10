/*
 * 인터페이스 설계.. 
 * 한개가 아니라 수십개 나오기도 함
 * IDepartment정의를해서
 *여기서 만들 기능은..
 *1. 
 *부서에 대한 전체 정보
 *void selectDepartment();
 *메서드 오버로딩활용할 수 있음.. 조인할때.. 
 * void selectDepartment(String deptNo);
 * --> 인터페이스를 정의할 때는 내가 무슨 기능을 만들것인지 정확하게 인지를 한 후 설계..
 * 
 * 2. department 하나말고 manager까지 출력하고 싶다??
 *ex) departments+팀장
 * select * from departments inner join dept_manager;
 *ㄴ여기에 특화된 dto 설계
 *ㄴ 상속은 ..bottom-up
 *많이 만들다 보면 common --> refactoring과정 거치기
 * */