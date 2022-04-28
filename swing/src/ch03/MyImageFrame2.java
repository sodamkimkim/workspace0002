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

public class MyImageFrame2 extends JFrame {
	//remove.bg가면 이미지 배경 제거해줌
	//코드를 수정해 주세요. 하드코딩(500,500) 되어있는 값들을 상수나 static활용해서 처리해 주세요.

	private BufferedImage backgroundImage;
	private BufferedImage imageIcon;
	private MyImagePanel myImagePanel;
	private JButton button;

	
	public MyImageFrame2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 백그라운드 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			backgroundImage = ImageIO.read(new File("image1.jpg"));
			imageIcon = ImageIO.read(new File("icon2.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		myImagePanel = new MyImagePanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(myImagePanel);
		
	}

	private class MyImagePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지 2개를 그려주는 기능을 완료할 것임.
			g.drawImage(backgroundImage, 0, 0, 500, 500, null);
			g.drawImage(imageIcon, 0, 0, 100, 100, null);
		}

	} // end of inner class

	public static void main(String[] args) {
		new MyImageFrame2();
	}
	
	public void addEventListener() {
		System.out.println("수정하였습니다.");
	}
} // end of outer class
