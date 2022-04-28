package v_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoFrame2 extends JFrame {

	private JButton startBtn;
	private int[] lotto = new int[LottoNumber.LOTTO_NUM_SIZE];
	private LottoNumber lottoNumber;
	private LottoPanel lottoPanel;

	public LottoFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("로또번호 생성기");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startBtn = new JButton(">>> 로또 번호 생성하기 <<<");
		lottoNumber = new LottoNumber();
		lottoPanel = new LottoPanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setBackground(Color.gray);
		add(startBtn, BorderLayout.NORTH);
		add(lottoPanel, BorderLayout.CENTER);
	}

	private void addEventListener() {
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lotto = lottoNumber.getLottoNumber();
				repaint();
			}

		});

	}

	private class LottoPanel extends JPanel {
		// 내부 클래스 .. 정적 내부 클래스로 만들 수 있다.
		// private static class ~
		// new 되기 전에 메모리에 뜨기 때문에
		// 이 클래스에서 인스턴스 변수를 사용할 수 없다.

		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("궁서체", Font.BOLD, 20));
			if (lotto[0] == 0) {
				g.drawString("로또 버튼을 클릭하세요", 200, 200);
				return;
			}
			int xPosition = 150;
			for (int i = 0; i < lotto.length; i++) {
				g.drawString(lotto[i] + "", xPosition, 150);
				xPosition += 50;
			}
		}

	}

} // end of class
