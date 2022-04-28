package ch04;

import java.awt.Color;

public class Activity1 extends BaseActivity {
	// Base가 JFrame이라서 얘도 JFrame을 쓸 수 있다.

	// 변수, 초기화 동시에 실행,
	// 익명
	CallbackCheckPosition callback = new CallbackCheckPosition() {
// 다형성적용안됨.
		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + "가 콜백을 받았습니다. x" + x);
			System.out.println(name + "가 콜백을 받았습니다. y" + y);
		}
	};

	public Activity1(String name) {
		super(name);

	}

	// annotation.. 일종의 주석인데 //주석은 컴파일러가 무시하는 부분이지만 annotation은 무시안함. 활용?
	// 컴파일시점에 어노테이션은 부모한테 이 메서드가 정의되어있어 알려주는거임
	// 베이스액티비티에 가서 인잇데이터가 있는가 없는가 알려주고
	// 부모한테 가서 이 메서드가 없으면 우리한테 알려준다.
	// 컴파일러 체킹 정도로 어노테이션을 활용할 수 있다.
	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		super.initData();
//		setTitle(name);
//		setSize(500, 500);
	}

	@Override
	protected void setInitLayout() {
		// TODO Auto-generated method stub
		super.setInitLayout();
		panel.setBackground(Color.blue);
	}

}
