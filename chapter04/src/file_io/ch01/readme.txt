**** 입출력 스트림 개념****



**** 입출력 스트림의 구분 ****
@ 대상 기준 구분: 입력 스트림/ 출력 스트림
@ 자료의 종류로 구분 : 바이트 스트림/ 문자 스트림
@ 기능으로 구분 : 기반 스트림/ 보조 스트림


**** 입출력 스트림의 종류 ****
@ 입력 스트림 : FileInputStream, FileReader, BufferedInputstream, BufferedReader등
@ 출력 스트림 : FileOutputStream, FileWriter, BufferedOutStream, BuffereddWriter 등.


** 바이트 단위 스트림과 문자 단위 스트림 **
@ 바이트 단위 스트림 : 동영상, 음악파일, 실행파일 등 자료를 읽고 쓸 때 사용한다.
@ 문자 단위 스트림 : 바이트 단위로 자료를 처리하게 되면 문자는 깨짐.
 인코딩에 맞게 2바이트 이상 처리하도록 구현된 스트림.
 - 특히 중국어는 2바이트도 안되고 3바이트는 있어야 함.
 - 네모칸 하나에 하나의 문자를 표현하는 것임.
 
 ** 기반 스트림과 보조스트림 **
 @ 기반 스트림 : 대상에 직접 자료를 읽어 들이거나 쓰는 기능을 가지고 있다.(바이트단위 또는 문자단위로)
 @ 보조 스트림 : 직접 읽고 쓰는 기능은 없다. 추가적인 기능을 더해주는 스트림
 
 * 참고)) 보조 스트림은 직접 읽고 쓰는 기능이 없기 때문에,
 보조 스트림 생성자에 기반 스트림을 포함시켜서 사용한다.