package myDiary;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MyDiaryFrame extends JFrame {

	IMyDiary completeDiary; // 응답자(main)
	IMyDiary writeMyDiary; // 호출자(sub)
	SaveMyDiary saveMyDiary; // 파일에 기록

	private JLabel background;

	private JLabel decoUserNameTitle;
	private JTextArea userName;
	private JLabel date;

	private JLabel decoHeaderTitle;
	private JTextArea userHeader;

	private JLabel decoBodyTitle;
	private JTextArea userBody;

	private JLabel docoFooterTitle;
	private JTextArea userFooter;

	private JButton saveBtn;

	public MyDiaryFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);

	}

	private void initObject() {


		completeDiary = new CompleteDiary();
//		writeMyDiary = new WriteMyDiary(getName(), getTitle(), getWarningString(), getName(), completeDiary);
		saveMyDiary = new SaveMyDiary();

		// GUI구성
		background = new JLabel(new ImageIcon("images/diaryBackground.png"));
		setContentPane(background);
//		decoUserNameTitle = new JLabel("\t이름 : ");
//		decoUserNameTitle.setSize(100, 50);
//		decoUserNameTitle.setBounds(50,200,100,50);
//		decoUserNameTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
//
//		this.add(decoUserNameTitle);
//		userName = new JTextArea();
//		userName.setSize(100, 50);
//		userName.setBounds(200, 200, 600, 50);


	}

	private void initSetting() {
		setSize(800, 1000);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MyDiaryFrame();
	}
}
