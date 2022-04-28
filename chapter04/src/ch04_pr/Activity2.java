package ch04_pr;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Activity2 extends BaseActivity {
	CallbackCheckPosition callbackPosition;

	public void setCallbackPosition(CallbackCheckPosition callbackPosition) {
		this.callbackPosition = callbackPosition;
	}

	public Activity2(String name) {
		super(name);
		addEventListener();

	}

	private void addEventListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				callbackPosition.checkPosition(x, y);
			}
		});
	}

}
