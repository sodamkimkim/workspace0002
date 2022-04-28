package ch06;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame8_seperated_pr extends JFrame implements MouseListener, KeyListener {

	private BufferedImage bgImage;
	private BufferedImage imageIcon;
	private ImagePanel imagePanel;
	private int iconX = -15;
	private int iconY = -5;

	// 생성자
	public MyFrame8_seperated_pr() {
		initData();
		setInitLayout();
		addEventListener();
	} // end of 생성자

	public void initData() {
		setTitle("이미지 백그라운드에서 이미지 움직이기 연습");
		setSize(1000, 1200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			bgImage = ImageIO.read(new File("루피배경2.jpg"));
			imageIcon = ImageIO.read(new File("루피아이콘2-removebg-preview.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("사진이 없습니다.");
		}

		imagePanel = new ImagePanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLayout(null);

		add(imagePanel);
		imagePanel.setSize(800, 1000);
		imagePanel.setLocation(0, 0);

	}

	private void addEventListener() {
		this.addKeyListener(this);
		this.addMouseListener(this);
	}

	/////////////// mouse////////////////////
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x좌표값 : " + e.getX());
		System.out.println("y좌표값 : " + e.getY());
		iconX = e.getX();
		iconY = e.getY();
		repaint();
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
	/////////////// key///////////////////////

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		String eventObjInfo = e.toString();
		System.out.println(eventObjInfo);
		System.out.println(keyCode);

		if (keyCode == 37) { // 왼쪽키
			iconX -= 50;
			if (iconX <= -15) {
				iconX = -15;
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
			if (iconX > imagePanel.getWidth() - 65) {
				iconX = imagePanel.getWidth() - 65;
			}
			repaint();
		} else if (keyCode == 40) { // 아래키
			iconY += 50;
			if (iconY > imagePanel.getHeight() - 80) {
				iconY = imagePanel.getHeight() - 80;
			}
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private class ImagePanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(bgImage, 0, 0, 800, 1000, null);

			g.drawImage(imageIcon, iconX, iconY, 80, 80, null);
		}
	}

	public static void main(String[] args) {
		new MyFrame8_seperated_pr();
	}
} // end of outer class
