package tenco.com.test_09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMapService.png"));
		setContentPane(backgroundMap);

		player = new Player();
		add(player);

	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// true, false

					if (!player.isLeft() && !player.isLeftWallCrash()) { // 방어적코드
						player.left();
					}

					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:

					// 둘다 true true되어야 up호출
					if (!player.isUp() && !player.isDown()) { // 올라갈때 계속 올라가지 않게. 떨어진 후 다시 쓰레드 생성해야함.
						player.up();
					}
					player.up();
					break;

				default:
					break;
				} // end of switch
			} // end of keyPressed

			// 키보드 해제 이벤트 처리
			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;

				default:
					break;
				}

			}
		});
	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // CSS의 absolute개념. 좌표값으로 자유롭게 그릴 수 있다.

		setLocationRelativeTo(null);// JFrame윈도우 창의 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new BubbleFrame();

	} // end of main
} // end of class
