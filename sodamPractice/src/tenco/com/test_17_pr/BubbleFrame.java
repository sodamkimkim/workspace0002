package tenco.com.test_17_pr;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	private JLabel backgrouondMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);

	}

	public void initObject() {
		backgrouondMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		setContentPane(backgrouondMap);
		player = new Player();
		add(player);

	}

	public void initSetting() {
		setSize(1000, 640);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getSource()); // The object on which the Event initially occurred.
//				System.out.println(e.toString());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT: // java.awt.event의 클래스 KeyEvent의 final상수 VK_LEFT
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				case KeyEvent.VK_SPACE:
					add(player.attackBubble()); // Bubble의 새로운 객체를 Frame에 add해준다. Bubble은 Label이다.
					break;
				}

			}// end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}// end of main

} // end of class
