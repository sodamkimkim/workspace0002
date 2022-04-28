package ch03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyComponents extends JFrame {
	// 새 컴포넌트 받기

	private JPanel jPanel;
	private JButton button;
	JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox checkBox;
	private JLabel label;
	// 컴포넌트안에 포함관계임. 멤버변수로 만들어냄.

	public MyComponents() {
		initData();
		setInitLayout();

	}

	private void initData() {
		// 멤버변수 값 초기화

		setTitle("컴포넌트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);

		jPanel = new JPanel();
		Dimension dimension = new Dimension(100, 300);
		jPanel.setPreferredSize(dimension);

		button = new JButton("button");
		label = new JLabel("label");
		textField = new JTextField("hint", 20);
//		text the text to be displayed, or <code>null</code>
//	    columns  the number of columns to use to calculate
//	    the preferred width
		passwordField = new JPasswordField(20);
		checkBox = new JCheckBox("checkBox", true);
	}

	private void setInitLayout() {

		// 화면처리

		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 200));
		add(jPanel);
		jPanel.setBackground(Color.BLUE);
		// setBackground control하고 눌러서 매게변수인 color들어가서 gray값 확인해서 들고올 수도 있고
		// Color로 바로 접근해서 final 값 들고올 수도 있고.
		

		jPanel.add(button);
		//add(button); 
		// ㄴ 이렇게 적으면 this.pannel(root pannel)임. 우리가 하고싶은건 jPanel에 붙이고 싶은거임
		jPanel.add(label);
		jPanel.add(textField);
		jPanel.add(passwordField);
		jPanel.add(checkBox);

	}

//	public static void main(String[] args) {
//		new MyComponents();
//		// textField에 글자를 넣으려면 메인함수에서 코딩을 해야할 것임.
//		
//		
//		
//	} // end of main
} // end of class
