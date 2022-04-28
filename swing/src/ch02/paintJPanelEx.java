package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame {
	private MyPanel myPanel = new MyPanel();

	public paintJPanelEx() {
		setTitle("JPanel paintComponent() 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(myPanel);
		setSize(250, 200);
		myPanel.setBackground(Color.black);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // JPanel의 paintComponent()호출 --> 패널 내에 이전에 그려진 잔상을 지우기 위해 호출
			g.setColor(Color.PINK);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.GREEN);
			g.drawRect(90, 90, 50, 50);
		}
	} // end of MyPanel

	public static void main(String[] args) {
		new paintJPanelEx();
	} // end of main
}// end of class
