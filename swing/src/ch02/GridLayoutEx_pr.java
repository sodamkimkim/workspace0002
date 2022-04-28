package ch02;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx_pr extends JFrame {
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JButton button4 = new JButton();

	private GridLayout gridLayout;

	public GridLayoutEx_pr() {
		initData();
		setInitLayout();

	}

	private void initData() {
		setTitle("GridLayout 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		button1 = new JButton("가");
		button2 = new JButton("나");
		button3 = new JButton("다");
		button4 = new JButton("라");
		gridLayout = new GridLayout(3,2,10,10);

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(gridLayout);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		
	}

	public static void main(String[] args) {
		new GridLayoutEx_pr();
	}
}