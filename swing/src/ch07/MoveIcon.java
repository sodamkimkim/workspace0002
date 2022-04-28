package ch07;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveIcon extends JFrame implements KeyListener{
	BufferedImage bgImage;
	BufferedImage imageIcon;
	private ImagePanel imagePanel;
	private String bgImageFileName = "루피배경.jpg";
	private String imageIconFileName = "루피.jpg";
	
	int xPoint = 200;
	int yPoint = 200;

	public MoveIcon() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bgImage = ImageIO.read(new File(bgImageFileName));
			imageIcon = ImageIO.read(new File(imageIconFileName));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일없습니다.");
//			System.exit(0); // 0 누르면 종료
		}
		imagePanel = new ImagePanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(imagePanel);
	}

	private void addEventListener() {
		this.addKeyListener(this);
	}



	private class ImagePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, 500, 500, null);
			g.drawImage(imageIcon, xPoint, yPoint, 80, 80, null);
		}

	
	}
	
	public static void main(String[] args) {
		new MoveIcon();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP) {
			yPoint -= 10;
			yPoint = (yPoint < 0)?0 : yPoint -10; // if문 대신 삼항연산자 사용

		
		}else if(keyCode == KeyEvent.VK_DOWN) {
			
			yPoint += 10;
	
			yPoint = (yPoint >420)? 420:yPoint +10; // if문 대신 삼항연산자 사용

		

		}else if(keyCode == KeyEvent.VK_LEFT) {
			xPoint -= 10;
			xPoint = (xPoint <0)? 0:xPoint -10; // if문 대신 삼항연산자 사용

			

		}else if(keyCode == KeyEvent.VK_RIGHT) {
			xPoint += 10;
			xPoint = (xPoint >420)? 420:xPoint +10; // if문 대신 삼항연산자 사용


		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

} // end of class
