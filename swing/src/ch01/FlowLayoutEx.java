package ch01;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame {
	public FlowLayoutEx() {
		setTitle("FlowLayout  Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("calculate"));
		setSize(300, 200);
//		setResizable(false);
		setVisible(true);

	}
	public static void main(String[] args) {
		new FlowLayoutEx();
	}

}
