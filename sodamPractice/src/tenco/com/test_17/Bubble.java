package tenco.com.test_17;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Bubble extends JLabel implements Moveable {

//	// 1단계
//	private BubbleFrame mContext;
//	모든 버블객체는 bubbleFrame에 대한 정보를 가질 필요가 없을 듯 해서 이 패키지에선 지운다.

	// 2단계
	private Bubble bubbleContext = this;

	// 버블 쏘는 위치 참조
	// 의존성 컴포지션 관계
	private Player player;

	// ---------- 이 밑에건 생성자에서 안받아도 된다. 버블객체생성될 때 new하면됨
	// 하나의 버블만 감시
	private BackgroundBubbleObserver backgroundBubbleObserver;

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0이면 기본, 1이면 적군 가둔 상태

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태


	

	// 의존 주입 : 보통 생성자에서 주입을 받는다.
	public Bubble(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();
	}

	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
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
//		setLocation(x, y);

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
			// 현재 색상 체크(메서드 호출)
			if (backgroundBubbleObserver.checkLeftWall()) {
				left = false;
				break;// 반복문 멈추고 up해줌
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
				break;// 반복문 멈추고 up해줌
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
				break;// 반복문 멈추고 up해줌

			}
			threadSleep(1);
		}
		up = false;

		removeBubble();
	}

	private void removeBubble() {
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);

			// 다시 그림을 그려라. JFrame자체에서 지워야 한다. => bubbleFrame에서 수정(repaint)
//			mContext.remove(this); // -> 메모리에서 제거. 메모리에 지운다음 repaint해줘야 한다.
//			mContext.repaint();
			// ㄴ> 이 코드만 작성하면 그림을 다시그릴때 ,, repaint해줘도 메모리에 살아있어서 버블이 지워지지 않음

			/*
			 * 이벤트 드리븐 방식 우리는 이벤트 처리를 low레벨에서 배우고 있음 low에서 배우면 나중에 라이브러리로 개발한다. low레벨에대한 개념이
			 * 잘 서면, 라이브러리 사용 잘 할수 있다.
			 */
			bubbleContext = null; // -> 메모리에서 내려가게되고, garbage collector가 자기 스케줄에 맞춰서 적절한 시간에 제거해줌.
			setIcon(null); // 도화지를 다시 repaint하지 않더라도 자기자신만 null

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
