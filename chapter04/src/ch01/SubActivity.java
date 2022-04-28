package ch01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//호출자(콜리, callee)
//멤버 변수로 '징검다리' 역할을 하는 인터페이스를 멤버 변수로 먼저 선언한다.
//sub가 인터페이스의 함수를 호출해서 main쪽으로 값 전달함
//callBackBtnAction.clickedCalculateBtn(result);

public class SubActivity extends JFrame {
	JButton button1;

	// 마이너스 버튼
	JButton button2;

	// 값 전달 메서드 추가
	JButton button3;

	int result = 999;
	ICallBackBtnAction callBackBtnAction; // 인터페이스를 멤버변수로 선언.

	// 콜리는 콜백받는 객체의 주소값을 알고 있어야
	// 메서드가 호출되었다고 알릴 수 있다.
	public SubActivity(ICallBackBtnAction callBackBtnAction) {
//		callBackBtnAction.clickedAddBtn();// 추상메서드 호출. 근데 new 안해서 null point exception 발생할 듯
		// 생성자에 매개변수로 받을거임
		// 서브 생성받는 시점에 인ㅌ페이스 주소값 넘겨받음
		// 메인엑
		this.callBackBtnAction = callBackBtnAction;
		setSize(300, 300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(400, 0);

		button1 = new JButton("더하기 버튼 + ");
		add(button1);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("더하기 버튼 클릭!!!");
				callBackBtnAction.clickedAddBtn();
			}
		});

		button2 = new JButton("빼기 버튼 - ");
		add(button2);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("빼기 버튼 클릭!!!");
				callBackBtnAction.clickedMinusBtn();
			}
		});

		// button3
		button3 = new JButton("result값 전달");
		add(button3);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("result값 전달");
				callBackBtnAction.clickedCalculateBtn(result);
			}
		});

	}
}// end of class