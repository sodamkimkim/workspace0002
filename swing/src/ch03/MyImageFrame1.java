package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame1 extends JFrame {
	private ImagePanel imagePanel;

	public MyImageFrame1() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JPanel에 이미지 넣기");
		setSize(500, 500);
//		imagePanel = new ImagePanel();
	}

	private void setInitLayout() {
		setVisible(true);
		add(new ImagePanel());
	}
	
	public static void main(String[] args) {
		new MyImageFrame1();
	} // end of main

	private class ImagePanel extends JPanel {
		private Image image; // ctrl + shift + o하면 자동으로 import됨

		public ImagePanel() {
			image = new ImageIcon("image1.jpg").getImage();

		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null); // getwidth 와 getHeight 는 값따로 지정안하면 부모꺼 들고옴

		}
	} // end of inner class
} // end of outer class
