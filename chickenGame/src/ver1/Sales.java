package ver1;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sales extends JLabel {

	private Player player;

	static int totalSales = 0;
	static int goalSales;
	static int address;
	static final int HOUSE_AMOUNT = 8;

	private BackgroundMapFrame mContext;

	private JLabel delHere;

	public Sales(BackgroundMapFrame mContext) {
		this.mContext = mContext;
		player = Player.getInstance();
		address = getRandomAddress();

		delHere(address);

	}

	private void delHere(int address) {

		delHere = new JLabel(new ImageIcon("C:\\Users\\ITPS\\Desktop\\Workspace_chicken\\teamproject_C\\chickenGame\\images/delHere.png"));
		delHere.setSize(100, 100);
		mContext.deliveryMapImg.add(delHere);

		if (address == 1) {
		
			delHere.setLocation(12, 56);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 2) {
			delHere.setLocation(12, 224);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 3) {
			delHere.setLocation(418, 42);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 4) {
			delHere.setLocation(386, 320);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 5) {
			delHere.setLocation(384, 488);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 6) {
			delHere.setLocation(524, 312);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 7) {
			delHere.setLocation(862, 32);

			repaint();
			this.requestFocusInWindow();

		} else if (address == 8) {
			delHere.setLocation(858, 488);

			repaint();
			this.requestFocusInWindow();
		}
		mContext.repaint();
	}

	public int updateTotalSales() {
		if (player.isCompleteDelivery()) {
			totalSales += 19000;
			address = getRandomAddress();
			delHere(address);

			if (totalSales >= goalSales) {
				System.out.println("목표 매출 달성");
				totalSales = 0;
				getRandomGoalSales();
				new AfterSucceedLabel(mContext);
			}
		}
		return totalSales;
	}

	public int getRandomGoalSales() {
		Random rd = new Random();
		goalSales = (rd.nextInt(10) + 1) * 10000;
		return goalSales;
	}

	public int getRandomAddress() {
		Random rd = new Random();
		int localAddress = rd.nextInt(HOUSE_AMOUNT) + 1;
		return localAddress;
	}

}
