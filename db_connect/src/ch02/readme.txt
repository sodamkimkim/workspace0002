** executeQuery와 executeUpdate의 차이점
- executeQuery는 resultSet을 만드는 sql문에서 사용한다.
주로 select문을 수행할 때 사용된다.

executeUpdate는 insert나 update와 같은 쿼리문에서 사용된다.



** Can not issue data manipulation statements with executeQuery().
update, insert, delete 문을 사용할 때 executeUpdate()로 전송하지 않았을 경우 발생한다.
executeUpdate() 리턴 값은 쿼리를 전송해서 변화한 행의 갯수를 나타낸다.


** mysql에서 확인해보기
use shopdb;
select * from membertbl;
delete from membertbl where memberId = 'asdfasdf';
-- ㄴ 실제 지워지던 안지워지던 수행된다.

** 쉬는 날
쿼리문 복습
dto만드는거 
수없이 해보기
기본구문 말고 어려운 구문도 만들어서 실행해보도록~~!~!