package ch01;

//1. 인터페이스 선언
/**
 * 
 * @author 김소담 콜백 메서드 만드는 연습
 *
 */
public interface ICallBackBtnAction {
	public abstract void clickedAddBtn(); // 추상메서드

	public abstract void clickedMinusBtn();

	public abstract void clickedCalculateBtn(int num);
	// ㄴ 매개변수를 통해서 sub객체의 값을 main에 보낼 수 있다.

//	void passValue(int num); // 쌤은 이렇게 선언하셨음
}
// 모바일은 이벤트 드리븐함수방식 많음
// 콜백 많이 쓰면 디버깅도 굉장히 어렵긴 함