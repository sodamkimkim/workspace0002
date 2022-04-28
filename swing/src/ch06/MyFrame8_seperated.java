package ch06;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame8_seperated extends JFrame implements MouseListener, KeyListener {
	private BufferedImage bgImage;
	private BufferedImage imageIcon;
	private ImagePanel1 imagePanel1;
	private int iconX = -10;
	private int iconY = -5;
	// 내부 클래스 선언 - paint override필요..
	// 변수를 잘 써라.
	// 이벤트 리스너 등록 아무데나
	// 백그라운드 이미지에다가 클릭하면 사진 움직이게 하기(위, 아래 , 왼쪽, 오른쪽)

	public MyFrame8_seperated() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("이미지 백그라운드에서 이미지 움직이기");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			bgImage = ImageIO.read(new File("루피배경.jpg"));
			imageIcon = ImageIO.read(new File("루피.jpg"));
		} catch (IOException e) {
			System.out.println("사진이 없습니다.");
		}

		imagePanel1 = new ImagePanel1();

	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLayout(null);

		add(imagePanel1);

		imagePanel1.setSize(800, 800);
		imagePanel1.setLocation(0, 0);

		imagePanel1.setBounds(0, 0, 800, 800);

	}

	private void addEventListener() {
		this.addKeyListener(this);
		this.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println("x좌표값: " + e.getX());
		System.out.println("y좌표값: " + e.getY());
		iconX = e.getX() - 25;
		iconY = e.getY() - 25;
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		String eventObjInfo = e.toString();
		System.out.println(eventObjInfo);
		System.out.println(keyCode);
		
		if (keyCode == 37) { // 왼쪽키
			iconX -= 50;
			if (iconX <= 0) {
				iconX = -10;
			}
			repaint();
		} else if (keyCode == 38) { // 상향키
			iconY -= 50;
			if (iconY <= 0) {
				iconY = -5;
			}
			repaint();
		} else if (keyCode == 39) { // 오른쪽키
			iconX += 50;
			if (iconX > imagePanel1.getWidth() - 85) {
				iconX = imagePanel1.getWidth() - 85;
			}
			repaint();

		} else if (keyCode == 40) { // 아래키
			iconY += 50;
			if (iconY > imagePanel1.getHeight() - 120) {
				iconY = imagePanel1.getHeight() - 120;
			}
			repaint();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	// 내부 클래스(패널)
	private class ImagePanel1 extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, 800, 800, null);
			g.drawImage(imageIcon, iconX, iconY, 80, 80, null);

		}

	} // end of inner class1

	// 메인함수
	public static void main(String[] args) {
		new MyFrame8_anonymous();
	}

} // end of outer class
