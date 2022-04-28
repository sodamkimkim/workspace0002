package ch03;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTwoPanel_pr extends JFrame {
	private JPanel panel1;
	private JPanel panel2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;

	public MyTwoPanel_pr() {
		initData();
//		setInitLayout();
	}
	
	private void initData() {
		setTitle("패널연습");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.blue);
	
		button1 = new Button("button1");
		button2 = new Button("button1");
		button3 = new Button("button1");
		button4 = new Button("button1");
		button5 = new Button("button1");
		
	}
}
