package tenco.com.test_17_pr;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {
	BufferedImage image;
	Player player;

	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
//			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
//			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
//			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
//					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);
//			
//			
			Color leftColor = new Color(image.getRGB(player.getX(), (player.getY() + player.getHeight() / 2)));

			Color rightColor = new Color(
					image.getRGB(player.getX() + player.getWidth(), (player.getY() + player.getHeight() / 2)));
			int bottomColor = image.getRGB((int) (player.getX() + player.getWidth() * 0.33),
					player.getY() + player.getHeight())
					+ image.getRGB((int) (player.getX() + player.getWidth() * 0.66),
							player.getY() + player.getHeight());

//			System.out.println(leftColor + ", " + rightColor + ", " + bottomColor);
			if (bottomColor != -2) { // 바닥이 흰색이 아니다 => 떨어지기 멈춰!
				player.setDown(false);
			} else { // 바닥이 흰색 => 떨어지기 가능!
				if(!player.isUp()&&!player.isDown()) {
					player.down();					
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
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}// end of class
