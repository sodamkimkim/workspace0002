package tenco.com.test_18;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class MyFrame extends JFrame {
	public MyFrame() {

		Container contentPane1;
		Container contentPane2;
		
		contentPane1 = getContentPane();
		System.out.println(contentPane1);// 초기 ContentPane의 정보를 불러와보자

		setContentPane(new MyCustomPane());
//		setContentPane(contentPane1);
		contentPane2 = getContentPane();
		System.out.println(contentPane2);// MyCustomPane으로 변경 후, ContentPane의 정보를 불러와보자
		contentPane2.setBackground(Color.lightGray);
		add(new JButton("OK"));
		contentPane2.add(new JButton("Cancel"));
		contentPane2.add(new JButton("Ignore"));
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
} // end of class

class MyCustomPane extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 패널 내에 이전에 그려진 잔상을 지우기 위해 호출
		setBackground(Color.pink);
//		setOpaque(true);
		g.setColor(Color.blue);
		g.drawRect(10, 10, 50, 50);
		g.drawRect(50, 50, 50, 50);
		g.setColor(Color.GREEN);
		g.drawRect(90, 90, 50, 50);
	}

} // end of class
