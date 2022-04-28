package ch05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

//어댑터 클래스를 사용해 보자.
public class MyFrame6 extends JFrame {
	public MyFrame6() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("어댑터 클레스 사용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

	}

	private void setInitLayout() {
		setVisible(true);
	}

	private void addEventListener() {
		this.addMouseListener(new MyCustomMouseListener()); // new MyCustomMouseListener이것도 다형성.. MouseAdapter를 쓸 수 있다.
		
		//1. 클래스 구현 방법
		//2. 익명 구현 객체
		//3. 내부 클래스 정의해서(상속을 받고) 오버라이드 활용
	}

	// 내부 클래스 사용
	private class MyCustomMouseListener extends MouseAdapter {

//	    public void mouseClicked(MouseEvent e) {} -> 요런건 일반메서드. 후크. 필요하면 써라
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("x : " + x);
			System.out.println("y : " + y);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("마우스 in");

		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("마우스 out");

		}

	} // end of inner class

	public static void main(String[] args) {
		new MyFrame6();
	}
} // end of class
