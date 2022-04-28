package tenco.com.test_10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	// 위치상태
	private int x;
	private int y;

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

	private ImageIcon playerR;
	private ImageIcon playerL;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();

	}

	private void initBackgroundPlayerService() {
		// 백그라운드는 걔속계ㅒ속 돌아가게 만들어야 해서
		// thread바로 start
		new Thread(new BackgroundPlayerService(this)).start();// 우리가 백그라운드 클래스를 runnable로 만들어서 쓰레드로 바로 만들 수 있따.

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

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// Event handler
	@Override
	public void left() {
		System.out.println("left");
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
						// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
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
						// TODO: handle exception
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

}
