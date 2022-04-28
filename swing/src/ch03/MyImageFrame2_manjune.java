package ch03;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame2_manjune extends JFrame {
	private BufferedImage backGroundImage;
	private BufferedImage imageIcon;
	private MyImagePanel myImagePanel;
	private JButton button;
	private final int[] frameSize = { 800, 600 };
	private final String backgroundUrl = "image1.jpg";
	private final String iconUrl = "icon2.png";

	public MyImageFrame2_manjune() {
		initData();
		setInitLayout();

	}

	private void initData() {
		setTitle("이미지 백그라운드 넣는 연습");
		setSize(frameSize[0], frameSize[1]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		try {
			imageIcon = ImageIO.read(new File(iconUrl));
			backGroundImage = ImageIO.read(new File(backgroundUrl));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		Scanner sc;
		private int[] iconLocation = { 0, 0 };
		private final int[] iconSize = { 100, 100 };
		private final int[] backGroundSize = { 800, 600 };

		public MyImagePanel() {
			setIconLocation();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(backGroundImage, 0, 0, backGroundSize[0], backGroundSize[1], null);
			g.drawImage(imageIcon, iconLocation[0], iconLocation[1], iconSize[0], iconSize[1], null);

		}

		public void setIconLocation() {
			sc = new Scanner(System.in);
			System.out.println("아이콘의 위치를 입력하세요.");
			System.out.println("x축 : ");
			int x = sc.nextInt();
			System.out.println("y축 : ");
			int y = sc.nextInt();

			iconLocation[0] = x;
			iconLocation[1] = y;

		}
	} // end of inner class
	
	public static void main(String[] args) {
		new MyImageFrame2_manjune();
	}
	

} // end of outer class
