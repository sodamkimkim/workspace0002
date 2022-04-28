package ch01;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 콜백받는 객체
//- ICallBackBtnAction 인터페이스를 구현해서 정의하면 된다.

public class MainActivity extends JFrame implements ICallBackBtnAction {

	int count;
	JLabel label;

	public MainActivity() {
		count = 0;
		label = new JLabel("count : " + count);
		setSize(300, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new SubActivity(this); // 다형성. ICallBackBtnAction implements하므로

	}

	@Override
	public void clickedAddBtn() {
		System.out.println("+버튼에(서부터) 콜백받았습니다.");
		count++;
		label.setText("count :" + count);
	}

	// (-)버튼 동작 콜백 메서드 정의
	@Override
	public void clickedMinusBtn() {
		System.out.println("-버튼에(서부터) 콜백받았습니다.");
		count--;
		label.setText("count : " + count);
	}

	@Override
	public void clickedCalculateBtn(int num) {
		System.out.println("연산버튼에서부터 콜백받았습니다.");
		count = num;
		label.setText("count : " + count);
	}

	// (-) 연산 을 전달 받는 콜백 메서드 정의
} // end of class
