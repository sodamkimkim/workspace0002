package tenco.com.test_17_pr;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable {

	// 버블 쏘는 위치 참조
	// 의존성 컴포지션 관계
	private Player player;

	// 하나의 버블만 감시
	private BackgroundBubbleObserver backgroundBubbleObserver;
	private Bubble bubbleContext = this;

	// 위치상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	private ImageIcon bubble;
	private ImageIcon bomb;

	public Bubble(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();

	}

	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bomb = new ImageIcon("images/bomb.png");
		backgroundBubbleObserver = new BackgroundBubbleObserver(this);
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);

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
			if (backgroundBubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}
			threadSleep(1);

		}
		left = false;
		up();
	}

	@Override
	public void right() {
		right = true;

		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleObserver.checkRightWall()) {
				right = false;
				break;
			}
			threadSleep(1);
		}
		right = false;
		up();

	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleObserver.checkTopWall()) {
				up = false;
				break;
			}
			threadSleep(1); // threadSleep안주면 갑자기 천장에 붙어서 나타남.
		//while반복 한번에 y좌표 하나 (-)잖아, 그리고x, y위치 set해주고.
			// 반복문 1회 돌 때 threadSleep안걸어주면
			// 반복문이 다 돌고 끝난 후의 결과만 나오니까,  checkTopWall일때 -> up= false -> break;
		// 더이상 버블 라벨 setLocation 일어나지 않으니까 버블이 천장에 붙어서 드러나게 되는것.
		}
		up = false;
		removeBubble();
	}

	private void removeBubble() {
		threadSleep(2000);
		setIcon(bomb);
		threadSleep(2000);
		bubbleContext = null;
		setIcon(null);
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}// end of class
