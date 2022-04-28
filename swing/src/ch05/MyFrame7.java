package ch05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrame7 extends JFrame implements KeyListener {

	private JTextArea textArea;

	public MyFrame7() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("키 이벤트 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea();

	}

	private void setInitLayout() {
		setVisible(true);
		add(textArea);
	}

	private void addEventListener() {
		textArea.addKeyListener(this);
	}

	// 문자 키에만 반응
	@Override
	public void keyTyped(KeyEvent e) {

	}

	// 키보드를 눌렀을 때만 반응
	@Override
	public void keyPressed(KeyEvent e) {
//		char c = e.getKeyChar();
//		int keyCode = e.getKeyCode();
//		System.out.println("c : " + c);
//		System.out.println("keyCode : " + keyCode);
//		textArea.append("\n" + "c : " + c + " : " + "keyCode : " + keyCode);
//		// textArea 키코드 그리고 c 값을 보이게 코딩해 주세요
		int keyCode = e.getKeyCode();
		String eventObjInfo = e.toString();
		System.out.println(eventObjInfo);
		System.out.println(keyCode);
		
//		if(keyCode == KeyEvent.VK_UP) {} // 이런식으로 써도 된다.
		if (keyCode == 37) {
			textArea.append("왼쪽" + "\n");
//			textArea.setText(keyCode + "왼쪽");
		} else if (keyCode == 38) {
			textArea.append("위" + "\n");
//			textArea.setText(keyCode + "위");
		} else if (keyCode == 39) {
			textArea.append("오른쪽" + "\n");
//			textArea.setText(keyCode + "오른쪽");

		} else if (keyCode == 40) {
			textArea.append("아래" + "\n");
//			textArea.setText(keyCode + "아래");

		}

//		

//	    public JTextArea(String text) {
//	        this(null, text, 0, 0);
//	    }
	} // end of keyPressed

	// 키보드를 눌렀다가 뗐을 때 반응
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MyFrame7();
	}

} // end of class
