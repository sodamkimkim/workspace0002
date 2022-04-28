package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private BorderLayout borderLayout; // 버튼들 어떻게 배치해줄까. 배치관리자

	public BorderLayoutEx() {
		setTitle("테스트1");
		setSize(500, 500);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 메모리까지 완전 내려간다.

		initData();
		setInitLayout();
	}

	private void initData() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		button4 = new JButton("button4");
		button5 = new JButton("button5");
		borderLayout = new BorderLayout();

	}

	private void setInitLayout() {
		this.setLayout(borderLayout);
		this.add(button1, BorderLayout.NORTH); // 메서드 오버로딩
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.CENTER);
		this.add(button4, BorderLayout.WEST);
		this.add(button5, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		new BorderLayoutEx();
	} // end of main
} // end of class
