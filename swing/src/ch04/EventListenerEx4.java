package ch04;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventListenerEx4 extends JFrame implements MouseListener {
	private JLabel label1;

	public EventListenerEx4() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("마우스 이벤트 확인");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("hello java!!!!~~~~~~~~~~~");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		add(label1);
		label1.setSize(100, 100);
		label1.setLocation(100, 100);

	}

	private void addEventListener() {
		this.addMouseListener(this);
	}

	// 마우스가 클릭되었을 때 호출
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(label1.getFont()); // font-size 12
		
		System.out.println("x좌표값: " + e.getX());
		System.out.println("y좌표값: " + e.getY());
		label1.setLocation(e.getX() - 50, e.getY()-88);

		System.out.println(label1.getBounds());
		System.out.println("label width : " + label1.getBounds().width);
		System.out.println("label height : " + label1.getBounds().height);
	}

	// 마우스가 눌러졌을 때 호출
	@Override
	public void mousePressed(MouseEvent e) {
		label1.setForeground(Color.blue);
	}

	// 마우스가 떨어졌을 때 호출
	@Override
	public void mouseReleased(MouseEvent e) {
		label1.setForeground(Color.RED);
	}

	// 마우스가 어떤 영역 안으로 들어갔을 때 호출
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// 마우스가 어떤 영역 밖으로 나갔을 때 호출
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new EventListenerEx4();
	}

} // end of class
