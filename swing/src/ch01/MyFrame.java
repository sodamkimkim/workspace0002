package ch01;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

	public MyFrame() {
		setTitle("MyFrame"); // JFrame 상속받아서 쓸 수 있다.
//		super.setTitle("MyFrame");쓸 수 있다.S
		super.setSize(500, 500);
		super.setVisible(true);
//		super.setDefaultCloseOperation(JFrame);

	}

	public static void main(String[] args) {
//		new MyFrame();
		String title = JOptionPane.showInputDialog("입력값 받기");
		System.out.println(title);
	} // end of main

} // end of class
