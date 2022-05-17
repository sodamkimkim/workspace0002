package myLoopyTalk2;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerFrame extends JFrame implements ActionListener {
	private JPanel mainPane;
	private ScrollPane scrollPane;
	private JTextArea txtArea;
	private JTextField fldPortNum;
	private JLabel lblPortNum;

	// 서버시작종료 버튼
	private JButton btnServerStart;
	private JButton btnServerStop;

	// 로그시작 종료
	private JButton btnLogStart;
	private JButton btnLogStop;

	// GUI 외
	private Server server;
	private ServerFrame mContext = this;

	public ServerFrame() {
		initData();
		addListener();
//		fldPortNum.requestFocus();
	}

	private void initData() {
		server = new Server(mContext);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		setTitle("myLoopyTalk");

		// pan1
		mainPane = new JPanel();
		scrollPane = new ScrollPane();
		setResizable(false);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		mainPane.setBackground(Color.DARK_GRAY);
		mainPane.setBounds(0, 0, 350, 410);

		// scrollPane
		scrollPane.setBounds(10, 10, 310, 200);
		scrollPane.setBackground(Color.CYAN);
		mainPane.add(scrollPane);

		// txtArea
		txtArea = new JTextArea();
		txtArea.setBounds(10, 10, 310, 200);
		txtArea.setBackground(Color.pink);
		txtArea.setEditable(false);
		scrollPane.add(txtArea);
		mainPane.add(scrollPane);

		// fldPortNum
		fldPortNum = new JTextField();
		fldPortNum.setText("포트번호를 입력하세요");
		fldPortNum.setBounds(120, 220, 200, 30);
		mainPane.add(fldPortNum);

		// 포트번호라벨
		lblPortNum = new JLabel("포트번호 : ");
		lblPortNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblPortNum.setForeground(Color.pink);
		lblPortNum.setBounds(10, 220, 100, 30);
		mainPane.add(lblPortNum);

		// 서버시작버튼
		btnServerStart = new JButton("서버생성");
		btnServerStart.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnServerStart.setBackground(Color.LIGHT_GRAY);
		btnServerStart.setForeground(Color.darkGray);
		btnServerStart.setBounds(10, 260, 150, 30);
		mainPane.add(btnServerStart);

		// 서버종료버튼
		btnServerStop = new JButton("서버종료");
		btnServerStop.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnServerStop.setBackground(Color.LIGHT_GRAY);
		btnServerStop.setForeground(Color.darkGray);
		btnServerStop.setBounds(170, 260, 150, 30);
		btnServerStop.setEnabled(false);
		mainPane.add(btnServerStop);

		// 로그시작버튼
		btnLogStart = new JButton("로그시작");
		btnLogStart.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnLogStart.setBackground(Color.LIGHT_GRAY);
		btnLogStart.setForeground(Color.darkGray);
		btnLogStart.setBounds(10, 300, 150, 30);
		mainPane.add(btnLogStart);

		// 로그종료버튼
		btnLogStop = new JButton("로그종료");
		btnLogStop.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnLogStop.setBackground(Color.lightGray);
		btnLogStop.setForeground(Color.darkGray);
		btnLogStop.setBounds(170, 300, 150, 30);
		btnLogStop.setEnabled(false);
		mainPane.add(btnLogStop);

		setContentPane(mainPane);
		setVisible(true);
	}

	private void addListener() {
		fldPortNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fldPortNum.getText().equals("포트번호를 입력하세요")) {
					fldPortNum.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fldPortNum.getText().equals(null)) {
					fldPortNum.setText("포트번호를 입력하세요");
				}
			}
		});

		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
		btnLogStart.addActionListener(this);
		btnLogStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnServerStart) {
			if (fldPortNum == null) {
				System.out.println("값을 입력하세요.");
			} else if (fldPortNum.getText().length() != 0) {
				// port번호 넣어주고
				// serverStart되어야함
				server.setPortNum(Integer.parseInt(fldPortNum.getText()));
				server.startNetwork();
			}
		} else if (e.getSource() == btnServerStop) {

		} else if (e.getSource() == btnLogStart) {

		} else if (e.getSource() == btnLogStop) {

		}
	}

	public static void main(String[] args) {
		new ServerFrame();
	}

}