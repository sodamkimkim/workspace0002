package tenco.com.test_09;

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
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		// 색상확인
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX(), player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + player.getWidth(), player.getY() + 25));

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

			System.out.println("===============================================");
			System.out.println("왼쪽 색상 : " + leftColor);
			System.out.println("오른쪽 색상 : " + rightColor);
			System.out.println("===============================================");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			}

		}

	}
}
// end of class
