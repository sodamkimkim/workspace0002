/*
 * 버블프레임이 메인가지고 있고
 * 버블도 스택에 있고
 * 플레이어도 스택에 있고
 * 
 * 자바에서 만드는 모든 프로그램은
 * 즉 메인함수를 가진 클래스는 모든 객체의 heap정보를 가지고 있다.**********************
 * 
 * - 버블프레임을 메인으로 만들었는데
 * player에 대한 정보, bubble, backgroundMap 등 대부분의 주소값을 가지고 있다.
 * 
 * @ context개념
 * - main에는 이 프로그램 환경정보를 가지고 있다.
 * 이런 '객체에대한 정보'를 context라 한다. 
 * 
 * 
 * - 쏘아지고 올라간 bubble이 2초뒤에 사라지고 그림을 다시 그려줘야 한다.
 * 이 것을 위해 context라는 개념이 필요
 * */

package tenco.com.test_15;

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
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		setContentPane(backgroundMap);

		player = new Player();
		add(player);

	}


	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // CSS의 absolute개념. 좌표값으로 자유롭게 그릴 수 있다.

		setLocationRelativeTo(null);// JFrame윈도우 창의 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	private void initListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());

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
					break;

				case KeyEvent.VK_SPACE: // space누르면 버블발사
					// space누를 때 마다 버블 객체 생성
					// 그리고 Bubble클레스 내부에서는 initThread()를 통해서 쓰레드를 발생시킨다.
					// Thread run할때 player.getPlayerWay가 LEFT이면
					// left함수 호출(left방향으로 포문돌려 버블 발사)
					Bubble bubble = new Bubble(player); 
					add(bubble);
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

	public static void main(String[] args) {
		new BubbleFrame();

	} // end of main
} // end of class
