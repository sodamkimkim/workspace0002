package ch13;

public class Exception1 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5 };
		
		

		try { // 예외가 발생한 곳
			for(int i = 0; i < 10 ; i++) { // Index 5 out of bounds for length 5상황임.
				System.out.println(arr[i]);
			}
		} catch (Exception e) { // 대체코드
			System.out.println(e); // e에 대한 메시지 찍어줌
			System.out.println("예외발생");
		} 
		
		System.out.println("코드가 여기까지 실행되나요? 네ㅎㅎ.");
	}
}
