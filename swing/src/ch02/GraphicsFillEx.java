package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsFillEx extends JFrame {
	public GraphicsFillEx() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setVisible(true);
	}

	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.blue);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.GREEN);
			g.fillRoundRect(10, 130, 50, 50, 20, 20);
			g.setColor(Color.magenta);
			g.fillArc(10, 190, 50, 50, 0, 270);
			g.setColor(Color.orange);
			int[] x = { 30, 10, 30, 60 };
			int[] y = { 250, 275, 300, 275 };
			g.fillPolygon(x, y, 4);
		}
	} // end of class

	public static void main(String[] args) {
		new GraphicsFillEx();

	}
} // end of main
