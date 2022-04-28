package tenco.com.test_17_pr;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundBubbleObserver {
	private int LEFT_XPOINT = 0;
	private int RIGHT_XPOINT = 60;
	private int CENTER_TOP = 25;

	private BufferedImage image;
	private Bubble bubble;

	public BackgroundBubbleObserver(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkLeftWall() {
		// checkLeftWall메서드는 bubble클래스에서
		// bubble이 더이상 left/right로 가는 것을 막고
		// 벽에 부딫히면 up()시켜주는 기능 구현할 때 사용됨

		return isCrashColor(LEFT_XPOINT);
		// checkLeftWall()메서드가 호출되면,
		// isCrashColor()메서드를 호출하여
		// 최종적인 return값을 받아온다.

		// isCrashColor(correctionPoint) -> 버블의 X좌표 + correctionPoint (0 || 25 || 60)좌표의
		// ServiceFrame 이미지 색상값을 구해서
		// 이 색상이 빨간색이면 -> 버블이 벽에 Crash o
		// 빨간색 아니면 -> 버블이 벽에 Crash x

		// Player의 playerWay가 left면 왼쪽으로 가고, correctionPoint == 0
		// Player의 playerWay가 right면 오른쪽으로 가고, correctionPoint == 60
	}

	public boolean checkRightWall() {
		return isCrashColor(RIGHT_XPOINT);
	}

	public boolean checkTopWall() {
		return isCrashColor(CENTER_TOP);
	}

	private boolean isCrashColor(int correctionPoint) {
		Color topColor = new Color(image.getRGB(bubble.getX() + correctionPoint, bubble.getY()));
		if (topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			return true;
		}
		return false;

	}
} // end of class
