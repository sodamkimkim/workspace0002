package thread_ex;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMiniGame extends JFrame {
	JButton btn1;
	JButton btn2;
//	Image2Thread image2Thread;
	CustomJpanel customJpanel;
//	private JPanel panel2;

//	Thread thread2 = new Thread(image2Thread);
//	Thread thread3 = new Thread(customJpanel); // 얘가 3
	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;

	private int icon2X = 0;
	private int icon2Y = 0;

	private int icon3X = 0;
//	private int icon3Y = 0;

	public MyMiniGame() {

		initData();
		setInitLayout();
		addEventListener();

		try {
			image1 = ImageIO.read(new File("루피배경.jpg"));
			image2 = ImageIO.read(new File("루피.jpg"));
			image3 = ImageIO.read(new File("루피아이콘2-removebg-preview.png"));

		} catch (IOException e) {
			System.out.println("사진이 없습니다.");

		} // end of try-catch

		Thread thread1 = new Thread(customJpanel);
		thread1.start();
//		 panel2 = new JPanel();

	}

	private void initData() {
		setTitle("이미지 백그라운드에서 이미지 움직이기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customJpanel = new CustomJpanel();
//		btn1 = new JButton("정지하기");
//		btn1.setSize(100, 100);
//
//		btn2 = new JButton("다시시작");
//		btn2.setSize(100, 100);

	}

	private void setInitLayout() {
		setVisible(true);
		// setResizable(false);
		
		setLayout(new GridLayout(2,1));
	
		add(customJpanel);
//		add(panel2);
//		panel2.add(btn1, BorderLayout.WEST);
//		panel2.add(btn2, BorderLayout.EAST);

	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 여기서는 이미지 2번을
				// key이벤트를 받아서 동작시켜주기

				int keyCode = e.getKeyCode();
				String eventObjInfo = e.toString();
				System.out.println(eventObjInfo);
				System.out.println(keyCode);

				if (keyCode == 37) { // 왼쪽키
					icon2X -= 50;
					if (icon2X <= 0) {
						icon2X = -10;
					}
					repaint();
				} else if (keyCode == 38) { // 상향키
					icon2Y -= 50;
					if (icon2Y <= 0) {
						icon2Y = -5;
					}
					repaint();
				} else if (keyCode == 39) { // 오른쪽키
					icon2X += 50;
					if (icon2X > 600 - 85) {
						icon2X = 600 - 85;
					}
					repaint();

				} else if (keyCode == 40) { // 아래키
					icon2Y += 50;
					if (icon2Y > 600 - 120) {
						icon2Y = 600 - 120;
					}
					repaint();

				}

			}
		});

//		btn1.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				   super.mouseClicked(e);
//				customJpanel.flag = false;
//
//			}
//		});
//
//		btn2.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				   super.mouseClicked(e);
//				customJpanel.flag = true;
//
//				System.out.println("dddd");
//
//			}
//		});
	}

//	private class panel2 extends JPanel implements MouseListener{
//
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
	private class CustomJpanel extends JPanel implements Runnable {
		boolean flag = true;


		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(image1, 0, 0, 800, 800, null);
			g.drawImage(image2, icon2X, icon2Y, 80, 80, null);
			g.drawImage(image3, icon3X, 200, 80, 80, null);

		}

		@Override
		public void run() {
			boolean direction = true;
			while (flag) {

				// 이미지 3번
				// x좌표값을 +
				// max좌표값까지 오면 x좌표값을 -
				// 좌표 이동하면 그림 다시 그려주기

				// thread.sleep(??)써야할듯..
				System.out.println("dd");
				if (direction) {
					icon3X += 10;
				} else {
					icon3X -= 10;
				}

				if (icon3X == 500) {
					direction = false;
				}
				if (icon3X == 100) {
					direction = true;
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				repaint();

			}
		}
	} // end of inner class

	public static void main(String[] args) {

		new MyMiniGame();

	}

} // end of outer class
