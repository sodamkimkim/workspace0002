package tenco.com.test_17;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel implements Moveable {

	// 위치상태
	private int x;
	private int y;

	// 플레이어의 방향
	private PlayerWay playerWay;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어 속도 상태. final로 speed
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 이미지 저장
	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();

	}

	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");

	}

	private void initSetting() {
		x = 80;
		y = 535;

		left = false;
		right = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;

		playerWay = PlayerWay.RIGHT;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void initBackgroundPlayerService() {
		// 백그라운드는 걔속계ㅒ속 돌아가게 만들어야 해서
		// thread바로 start
		new Thread(new BackgroundPlayerService(this)).start();
		// 우리가BackgroundPlayerService클래스를 runnable로 만들어서 쓰레드로 바로 만들고 .start할 수 있다.

	}

	// Event handler
	@Override
	public void left() {
		System.out.println("left");
		playerWay = PlayerWay.LEFT;

		left = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {

					setIcon(playerL);
//					x = x - 1;
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);

					} catch (Exception e) {
						e.printStackTrace();
					} // 0.01초

				}
			}

		}).start();

	}

	@Override
	public void right() {
		System.out.println("right");
		playerWay = playerWay.RIGHT;

		right = true;

		new Thread(new Runnable() {
			@Override
			public void run() {

				while (right) {
					setIcon(playerR);
//					x = x + 1;
					x = x + SPEED;
					setLocation(x, y);

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	// left + up, right + up
	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < (130 / JUMPSPEED); i++) { // 65번 반복
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				up = false;
				down();
			}

		}).start();
	}

	@Override
	public void down() {
		System.out.println("down");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();

					}

				}
				down = false;

//				for (int i = 0; i < (130 / JUMPSPEED); i++) {
//					y = y + JUMPSPEED;
//					setLocation(x, y);
//
//					try {
//						Thread.sleep(3);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				down = false;
			}

		}).start();
	}

	// 메서드 이름 지을때 '동사+명사' 많이활용. 왜냐면 메서드는 객체의 행위이기 때문에
	public Bubble attackBubble() {
		return new Bubble(this);
	}
} // end of class
