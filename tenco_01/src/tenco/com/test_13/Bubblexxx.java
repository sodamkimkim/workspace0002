package tenco.com.test_13;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubblexxx extends JLabel implements Moveable {
	// 의존성 컴포지션 관계
	private Player player; // 버블은 player의 기준으로 나온다.

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0.기본, 1. 적군 가둔 상태

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	public Bubblexxx(Player player) {
		this.player = player; // 의존 주입.
		// 보통 생성자에서 주입을 받는다.
		// 버블객체가 생성될 때 의존해서 생성됨
		// 타이트 커플링, 루즈커플링 중 tight coupling
		// player기능혹은 좌표가 바뀌면 버블도 수정이 일어난다.
		// 객체와 객체간의 결합도가 타이트하게 묶인 상태
		// 의존성 컴포지션관계라고도 함

		initObject();
		initSetting();
		initThread();

	}

	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");

	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		state = 0;

	}

	private void initThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				} else {
					right();
				}
			}
		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			threadSleep(1);

		}
		up();

	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			threadSleep(1);

		}
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			threadSleep(1);
		}

	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

//	@Override
//	public void down() { // interface에서 default로 선언해 둔 down..  기능상 필요없는 down은 구현하지 않아도 된다.
//		// TODO Auto-generated method stub
//		
//	}
} // end of class
