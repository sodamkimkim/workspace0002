package ch02;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame{
	
	// 배열 -> 어레이리스트로 변경해주기
	
	private ArrayList<JButton> jButtons = new ArrayList<JButton>();
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> directions = new ArrayList<String>();

	
	private BorderLayout borderLayout;

	
	

	public MyFrame2() {
				
		titles.add("북");
		titles.add("센터");
		titles.add("남");
		titles.add("동");
		titles.add("서");
		
		directions.add(BorderLayout.NORTH);
		directions.add(BorderLayout.CENTER);
		directions.add(BorderLayout.SOUTH);
		directions.add(BorderLayout.EAST);
		directions.add(BorderLayout.WEST);
		
		initData();
		setInitLayout();
		
	}
	
	private void initData() {
		// 초기화
		setTitle("BorderLayout TEST");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();
		
		
		for (int i = 0; i < titles.size(); i++) {
			jButtons.add(new JButton(titles.get(i)));
		}
		
//		jButtons.add(new JButton(titles.get(0)));
//		jButtons.add(new JButton(titles.get(1)));
//		jButtons.add(new JButton(titles.get(2)));
//		jButtons.add(new JButton(titles.get(3)));
//		jButtons.add(new JButton(titles.get(4)));
		

		
//		for (int i = 0; i < buttons.length; i++) {
//			buttons[i] = new JButton(titles[i]);
//		}
		
	}
	private void setInitLayout() {
		// 꾸며주기
		setVisible(true);
		setLayout(borderLayout);
		
		
//		for (int i = 0; i < buttons.length; i++) {
//			this.add(buttons[i], directions[i]);
//
//		}
		for (int i = 0; i < directions.size(); i++) {
			this.add(jButtons.get(i), directions.get(i));

		}
//		this.add(jButtons.get(0), directions.get(0));
//		this.add(jButtons.get(1), directions.get(1));
//		this.add(jButtons.get(2), directions.get(2));
//		this.add(jButtons.get(3), directions.get(3));
//		this.add(jButtons.get(4), directions.get(4));
		
	}
}
