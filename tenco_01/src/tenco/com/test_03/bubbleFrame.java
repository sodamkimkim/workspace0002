package tenco.com.test_03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

// 1. 윈도우 창
// 2. 윈도우 창은 내부에 기본 패널을 하나 가지고 있다.
public class bubbleFrame extends JFrame {

	private JTextField textField;

	public bubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // 기본 패널 가져옴 // layout에 널넣으면 직접 값 넣어야 한다.

		JButton button = new JButton("button1");
		button.setBounds(200, 100, 80, 20);
		getContentPane().add(button);
		textField = new JTextField();
		textField.setText("안녕하세요");
		textField.setBounds(450, 200, 100, 50);
		textField.setColumns(10);
		getContentPane().add(textField);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new bubbleFrame();
	}
}// end of class
