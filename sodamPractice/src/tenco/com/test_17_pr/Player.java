package tenco.com.test_17_pr;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel implements Moveable {
	// 위치상태
	private int x;
	private int y;

	// ** 플레이어 방향상태.. 왜있는거지 .. 밝혀짐. 버블 쏘려고, 버블 쏘는 방향
	// player의 left right변수 활용해도 되지않을까 생각하긴 했는데
	// 일단 기능별로 나누는거..
	private PlayerWay playerWay;
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 스피드
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// 부딪힘
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 이미지저장
	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();

	}

	private void initObject() {
		playerL = new ImageIcon("images/playerL.png");
		playerR = new ImageIcon("images/playerR.png");

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
//		playerWay = PlayerWay.RIGHT; ** ?? 왜쓰는거임?

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void initBackgroundPlayerService() {
		new Thread(new BackgroundPlayerService(this)).start();
	}

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
					x = x - SPEED;
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

	@Override
	public void right() {
		System.out.println("right");
		playerWay = PlayerWay.RIGHT;
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					setIcon(playerR);
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}).start();

	}

	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
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
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				down = false;
			}
		}).start();

	}

	public Bubble attackBubble() {
		return new Bubble(this);
	}

} // end of class
