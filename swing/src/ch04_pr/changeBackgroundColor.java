package ch04_pr;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class changeBackgroundColor extends JFrame implements ActionListener {
	private JPanel panel1;
	private JPanel panel2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;

	public changeBackgroundColor() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("백그라운드 바꾸기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setBackground(Color.blue);

		panel2 = new JPanel();
		panel2.setBackground(Color.yellow);

		button1 = new Button("button1");
		button2 = new Button("button2");
		button3 = new Button("button3");
		button4 = new Button("button4");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2, 1));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		add(panel1);
		add(panel2);

		panel1.add(button1);
		panel1.add(button2);
		panel2.add(button3);
		panel2.add(button4);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}

	public static void main(String[] args) {
		new changeBackgroundColor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.out.println(e.getActionCommand() + "버튼이 클릭되었습니다.");
		if(e.getActionCommand().equals("button1")) {
			panel1.setBackground(Color.black);
		}else if(e.getActionCommand().equals("button2")) {
			panel1.setBackground(Color.cyan);
		}else if(e.getActionCommand().equals("button3")) {
			panel2.setBackground(Color.DARK_GRAY);
		}else if(e.getActionCommand().equals("button4")){
			panel2.setBackground(Color.LIGHT_GRAY);
		}
		
	}

}// end of class
