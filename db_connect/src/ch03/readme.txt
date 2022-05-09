
statement에서..

preparedStatement사용 방법..

Statement와 preparedStatement의 차이점은 --> 캐시 사용 여부..

=> 따라서 반복적으로 쿼리를 수행한다면 Statement에 비해 성능이 훨씬 좋다.

+ 보안적인 측면에서도 Statement보다 preparedStatement가 안정성 높다.


-사용자가 서칭할때,

바나나를 찾고싶을때

1. 램에 먼저 찾고, 없으면

2. 하드디스크에서 서치--> 원판 돌아서 full-san =>느림

3. 있으면 가져와서 메모리에 올림

4. 사용자에게 연결해줌

-사용자가 또 검색?

=> 메모리에 있기 때문에 하드안가고 사용자에게 바로 돌려줄 수 있음

--> 메모리에 올라와있는 상태: is 캐시 되었다.



﻿