package ch03;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainTest2 extends JFrame {
	private BufferedImage backgroundImage;
	private BufferedImage imageIcon;
	private MyImagePanel myImagePanel;
	private JButton button;
	Dimension dimension;

	public MainTest2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 백그라운드 연습");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myImagePanel = new MyImagePanel();
		setSize(dimension);

	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(myImagePanel);

	}

	public static void main(String[] args) {
		// 도전과제
		// 메인함수 외부에서 파일을 전달 받아서 넣어주세요
		// 여기서 파일명을 선언해서 전달 후에 코드가 동작하게 수정.

		MainTest2 mainTest2 = new MainTest2();
		try {
			mainTest2.backgroundImage = ImageIO.read(new File("image1.jpg"));
			mainTest2.imageIcon = ImageIO.read(new File("icon2.png"));
		} catch (IOException e) {

			System.out.println("파일이 없습니다.");

		}
		mainTest2.dimension = new Dimension(500, 500);

	} // end of main

	private class MyImagePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지 2개를 그려주는 기능을 완료할 것임.
			g.drawImage(backgroundImage, 0, 0, 500, 500, null);
			g.drawImage(imageIcon, 0, 0, 100, 100, null);
		}

	} // end of inner class
}// end of class
