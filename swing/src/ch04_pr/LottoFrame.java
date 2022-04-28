package ch04_pr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton startButton;
	private int[] lottoNumbers = new int[6];
	private BufferedImage imageIcon;

	public LottoFrame() {
		setSize(600, 400);
		setBackground(Color.lightGray);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startButton = new JButton("로또");
		add(startButton, BorderLayout.NORTH);
		startButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lottoNumbers = getLotto();
		// 그림을 다시 그려라
		repaint(); // paint메서드를 다시 호출
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		Font font = new Font("궁서체", Font.BOLD, 20);

		g.setFont(font);
		if (lottoNumbers[0] == 0) {
			g.drawString("로또 버튼을 클릭하세요", 50, 100);
			return;
		}
		// lottoNumber[0]값이 있다면 6개 번호를 생성한 후
		// 여기서 번호를 그려봅시다.

		g.drawString(lottoNumbers[0] + "", 400, 100); // int + "" 문자열로 바꿔줌
		g.drawString(lottoNumbers[1] + "", 450, 100); // int + "" 문자열로 바꿔줌
		g.drawString(lottoNumbers[2] + "", 500, 100); // int + "" 문자열로 바꿔줌
		g.drawString(lottoNumbers[3] + "", 550, 100); // int + "" 문자열로 바꿔줌
		g.drawString(lottoNumbers[4] + "", 600, 100); // int + "" 문자열로 바꿔줌
		g.drawString(lottoNumbers[5] + "", 650, 100); // int + "" 문자열로 바꿔줌
		
		try {
			imageIcon = ImageIO.read(new File("루피.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일이 없습니다.");
		}
		g.drawImage(imageIcon, 50, 70, 150, 150, null);	}

	public int[] getLotto() {
		int[] lotto = new int[6];
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			int j = random.nextInt(45) + 1;
			lotto[i] = j;
			for (int e = 0; e < i; e++) {
				if (lotto[i] == lotto[e]) {
					i = i - 1;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		for (int i : lotto) {
			System.out.println(i);
		}

		return lotto;
	}

	public static void main(String[] args) {
		new LottoFrame();
	} // end of main
} // end of class
