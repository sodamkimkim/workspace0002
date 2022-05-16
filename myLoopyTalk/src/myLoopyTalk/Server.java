package myLoopyTalk;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//@Data
public class Server extends JFrame implements IChatMessage {
	// Network
	private int port;
	ServerSocket serverSocket;
	Socket socket;
	Server mContext = this;
	// Flag
	boolean connectFlag;
	boolean mainFlag;
	boolean communicateFlag;
	// GUI자원
	private JPanel contentPane;
	private JTextField tfUserInputPort;
	protected JTextArea textArea;
	private JLabel lblPortNum;
	private JButton btnServerStart;
	private JButton btnServerStop;
	private JButton btnStartLogs;
	Vector<UsersocketFS> vcUsers = new Vector<UsersocketFS>();
	BufferedWriter fBufferedWriter;

	// 콜백 처리
	IServerAndUserSocket andUserSocket = new IServerAndUserSocket() {
		@Override
		public void broadcast(String msg) {
			System.out.println("broadcast시작 콜백 확인");
			for (int i = 0; i < vcUsers.size(); i++) {
				vcUsers.get(i).sendMessage(msg);
			}
		}
	};

	public Server() {
		initData();
		initAddEventListener();
	} // end of constructor

	@Override
	public void startServer() {
		try {
			System.out.println("1. 서버 소켓 시작.");
			serverSocket = new ServerSocket(port);
			System.out.println("2. 서버 소켓 생성 완료.");
			textArea.append("서버를 시작하겠습니다.\n");
			connect();
		} catch (IOException e) {
			System.out.println("startNetwork 예외발생 : " + e.getMessage());
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림", JOptionPane.ERROR_MESSAGE);
			btnServerStart.setEnabled(true);
			btnServerStop.setEnabled(false);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못입력하셨습니다.", "알림", JOptionPane.ERROR_MESSAGE);
			System.out.println("startNetwork예외발생 : "
					+ "" + e.getMessage());
			e.getStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	} // end of main

	public void initData() {

		connectFlag = true;
		mainFlag = true;
		communicateFlag = true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 460);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 309, 229);
		textArea = new JTextArea();
		textArea.setBounds(12, 11, 310, 230);
		scrollPane.add(textArea);
		contentPane.add(scrollPane);
		textArea.setEditable(false);

		lblPortNum = new JLabel("포트번호 : ");
		lblPortNum.setBounds(12, 273, 82, 15);
		contentPane.add(lblPortNum);

		tfUserInputPort = new JTextField();
		tfUserInputPort.setBounds(98, 270, 224, 21);
		contentPane.add(tfUserInputPort);
		tfUserInputPort.setColumns(10);

		btnServerStart = new JButton("서버실행");
		btnServerStart.setBounds(12, 315, 154, 23);
		contentPane.add(btnServerStart);

		btnServerStop = new JButton("서버중지");
		btnServerStop.setBounds(168, 315, 154, 23);
		contentPane.add(btnServerStop);
		btnServerStop.setEnabled(false);

		btnStartLogs = new JButton("로그시작");
		btnStartLogs.setBounds(98, 348, 154, 23);
		contentPane.add(btnStartLogs);
		btnStartLogs.setEnabled(true);

		setVisible(true);

	}

	public void initAddEventListener() {
		tfUserInputPort.addActionListener(this);
		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
		btnStartLogs.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnServerStart) {
			if (tfUserInputPort.getText().length() == 0) {
				System.out.println("값을 입력하세요.");
			} else if (tfUserInputPort.getText().length() != 0) {
				port = Integer.parseInt(tfUserInputPort.getText());
				textArea.append("서버를 시작합니다.\n");
				textArea.append("포트번호 : " + port);

				startServer();
				tfUserInputPort.setEditable(false);
				btnServerStart.setEnabled(false);
				btnServerStop.setEnabled(true);

			}

		} else if (e.getSource() == btnServerStop) {
			try {
				tfUserInputPort.setEditable(true);
				btnServerStart.setEnabled(true);
				btnServerStop.setEnabled(false);
				textArea.append("서버를 중지합니다.\n");
				serverSocket.close();
			} catch (IOException e1) {
				System.out.println("서버측 예외발생 : " + e1.getMessage());
			}
		} else if (e.getSource() == btnStartLogs) {
			btnStartLogs.setEnabled(false);
			System.out.println("로그기록을 시작합니다.");
			textArea.append("로그기록을 시작합니다.\n");
			try {
				fBufferedWriter = new BufferedWriter(new FileWriter("myLoopyTalkLogs.txt", true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void fileLog(String msg) {
		try {
			fBufferedWriter.write(msg + "\n");
			fBufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void connect() {
		Thread connectThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (connectFlag) {
					try {
						textArea.append("사용자 접속을 기다립니다.\n");
						socket = serverSocket.accept();
						UsersocketFS userSocket = new UsersocketFS(andUserSocket, mContext, socket);
						// 서버는 사용자와 연결된 소켓에 정보를 알아야 한다.
						vcUsers.add(userSocket);
//						.start를 통해서 쓰레드 .run()실행을 제어해 준다.
						userSocket.start();

					} catch (IOException e) {
						System.out.println("예외발생 : " + e.getMessage());
						e.printStackTrace();
						connectFlag = false;
						break;
					}
				}
			}
		});
		connectThread.start();

	}

} // end of outer-class
