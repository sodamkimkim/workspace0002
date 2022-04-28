package ch02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawStringEx extends JFrame {

	private MyPanel myPanel;

	public GraphicsDrawStringEx() {
		myPanel = new MyPanel();
		setTitle("그래픽 그려보기");
		setSize(500, 500);
		setContentPane(myPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		Font font;
		JButton button = new JButton("안녕");

		public MyPanel() {
			setBackground(Color.pink);
			this.add(button); // 이런건 스윙 컴포넌트로 GUI구성하는 방식
		}

		@Override
		protected void paintComponent(Graphics g) { // Graphics, Font, Color를 이용하는게 그래픽 기반 GUI
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.setFont(new Font("Times New Roman", Font.ITALIC, 30));
			g.drawString("I love JAVA", 0,50);
			g.drawString("Really..", 100,100);

		}
	} // end of MyPanel

	public static void main(String[] args) {
		new GraphicsDrawStringEx();
	}
} // end of class
