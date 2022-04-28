package tenco.com.test_17.test0001;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 캐릭터가 움직일 때마다 색 감지하는 쓰레드
// 메인쓰레드는 바쁨. 키보드 이벤트 처리를 해야하기 때문에.
// 백그라운드에서 계속 관찰.
public class BackgroundPlayerService implements Runnable {
	private BufferedImage image;
	private Player player;

	public BackgroundPlayerService(Player player) {
		// 상호작용하기 위해서 메서드에 참조타입 넣음.
		// player에 대한 참조 주소값을 넘겨받을 것임
		// 다른 메서드에서도 쓸 수 있도록 멤버변수로 만들것임
		this.player = player;
		try {
			image = ImageIO.read(new File("C:\\workspaceboot_002\\workspaceboot_002\\tenco_01\\images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		// 색상확인
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);

//			System.out.println("바닥 색상 : " + bottomColor);

			// -1이 아니라는 것은
			// 빨간색이거나 파란색이다.
			if (bottomColor != -2) {
				player.setDown(false);
//				System.out.println("바닥컬러 : " + bottomColor);

				// -2가 아니라면
			} else {
				// 점프하는 순간 down메서드가 호출되고 있다.
				if (!player.isUp() && !player.isDown()) { // 방어적 코드 작성안하면 지구끝까지 내려간다.
					player.down();
					// 버그.. 무한호출 .. 백그라운드 서비스는 계{속실행된다.
					// player에서 down == false일 경우에만 한번 실행되게 수정해야 함.
					// 일관성있게 bubbleFrame 에서 코드를 처리하자.
				}
			}
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌했어.");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌했어.");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

//			System.out.println("===============================================");
//			System.out.println("왼쪽 색상 : " + leftColor);
//			System.out.println("오른쪽 색상 : " + rightColor);
//			System.out.println("===============================================");

			try {
				Thread.sleep(3);// thread가 길면.. check해야하는애가 기다리고 있어서 컬러값 check못하고 떨어짐
				// 캐릭터가 이동될 때 color값을 못찾는 경우가 있다.
				// 이동속도보다 더 빠르게 움직여야 해결 가능.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
// end of class
