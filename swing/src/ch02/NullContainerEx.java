package ch02;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {
	public NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 0500);
		Container c = getContentPane();
		c.setLayout(null); // 컨텐트팬의 배치관리자 제거

		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50);
		la.setSize(200, 20);
		c.add(la);

		for (int i = 0; i < 9; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*15, i*15);
			b.setSize(50,20);
			c.add(b);
		}

		setVisible(true);

	}

	public static void main(String[] args) {
		new NullContainerEx();
	} // end of main

} // end of class
