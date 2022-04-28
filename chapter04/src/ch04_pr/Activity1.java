package ch04_pr;

import java.awt.Color;

public class Activity1 extends BaseActivity {
	CallbackCheckPosition callback = new CallbackCheckPosition() {

		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + "가 콜백받았습니다. x" + x);
			System.out.println(name + "가 콜백받았습니다. y" + y);
		}
	};

	public Activity1(String name) {
		super(name);

	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		super.initData();
	}

	@Override
	protected void setInitLayout() {
		// TODO Auto-generated method stub
		super.setInitLayout();
		panel.setBackground(Color.blue);
	}

}
