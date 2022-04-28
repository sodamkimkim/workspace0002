package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 외부클래스
public class MyPaint extends JFrame {

	MyPanel myPanel;

	public MyPaint() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("직접 그려보기 연습");
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		myPanel = new MyPanel();

	}

	private void setInitLayout() {
		setVisible(true);
		add(myPanel);

	}

	public static void main(String[] args) {
		new MyPaint();
	} // end of main

	// 내부클래스
	// MyPanel 은 MyPaint클래스에서만 쓸 것이기 때문에 따로 자바파일을 만들어서 파일을 늘리기 보다는 내부클래스로 쓰는게 괜찮다.
	private class MyPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g); // 이거 그대로 둬야 제대로 동작함.
			g.drawString("안녕 자바 2D", 100, 200);
			g.drawLine(20, 30, 100, 100); // y좌표값은 (-)인듯
			g.drawRect(100, 100, 150, 150); // 사각형 그리기

		}
	} // end of inner class
} // end of outer class
