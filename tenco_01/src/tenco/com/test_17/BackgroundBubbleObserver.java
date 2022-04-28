package tenco.com.test_17;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundBubbleObserver {
	// 쓰레드쓰면 느려질거라서 안쓸거임
	
//	background bubble oserver
//	thread로 만들지 않았다.
//
//	thread로 만드는게 무조건 좋은게 아니다.
//	하나의 버블은 하나의 쓰레드인데
//	이걸 감시하기 위해서 또 하나의 쓰레드를 만들면
//
//	버블 백개쏘면 쓰레드 200개되는 거임.
//	메모리 낭비가 심하다.
//
//	포문 한번에 함수 호출하고 끝나면 메모리 내려가는게 호ㅝㄹ씬 좋은 방식
//
//	-- 
//
//	버블 하나에 백그라운드플레이서비스처럼
//	전체 감시하는 쓰레드를 만들 수도 있을 거다.
//	단점은
//	버블생성할때마다 쓰레드 관리해야함.
//	계속 다시그려줘야함
//
//	그래서 지금처럼 포문한번에 함수호출하고 내려가게하는게 훨씬 좋은 방식.

	private static int LEFT_XPOINT = 0;
	private static int RIGHT_XPOINT = 60;
	private static int CENTER_TOP = 25;

	private BufferedImage image;
	private Bubble bubble;

	// Color를 멤버변수로 만드는게 좋은가?? -> 지역변수를 쓰는 것을 추천.
	// refactorying 과정 연습

	public BackgroundBubbleObserver(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}

	}

	public boolean checkLeftWall() {

		return isCrashColor(LEFT_XPOINT);

	}

	public boolean checkRightWall() {

		return isCrashColor(RIGHT_XPOINT);
	}

	public boolean checkTopWall() {
		// 3단계
		return isCrashColor(CENTER_TOP);
	}
	
//	

	private boolean isCrashColor(int correctionPoint) {

		Color topColor = new Color(image.getRGB(bubble.getX() + correctionPoint, bubble.getY()));
		// 버블이미지의 왼쪽 상단 & 오른쪽 상단 & 상단 중앙부 배경값을 받는다.
		// ㄴ 좌표색 -> X + correctionPoint으로 왼/오/중앙 구분함.

		// ㄴ이 값들이 빨간색이면
		// isCrashColor == true, else isCrashColor == false 반환.
		if (topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			return true;
		}
		return false; // 빨간색 아니면 isCrashColor == false
	}
} // end of class
