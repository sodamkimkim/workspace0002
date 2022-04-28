package myLoopyTalk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame implements IChatMessage, ActionListener {
	// GUI
	private JPanel mainPanel;
	private JTabbedPane tabs;
	private JLabel lblBgimage;
	// 로그인패널
	private JPanel panel1;
	private JLabel lblHostIP;
	private JTextField tfHostIP;
	private JLabel lblServerPort;
	private JTextField tfServerPort;
	private JLabel lblUserID;
	private JTextField tfUserID;
	private JButton btnConnect;
	// 대기실패널
	private JPanel panel2;
	private JLabel lblTotalUserLst;
	private JLabel lblTotalRoomLst;
	private JList lstTotalUser;
	private JList lstRooms;
	private JButton btnSendPrivateMsg;
	private JButton btnJoinInChatRoom;
	// 채팅
	private JPanel panel3;
	private JTextArea txtAreaViewChat;
	private JTextField tfForChat;
	private JButton btnSubmit;
	private JScrollPane scrollPane;
	// 방만들기, 방나가기, 종료
	private JButton btnMakeRoom;
	private JButton btnOutRoom;
	private JButton btnEndChat;

	// network 자원
	private Socket socket;
	private String serverIP;
	private int serverPort;
	private String userId;

	// Flag
	boolean mainFlag;

	// 그외
	private Vector<String> vcUsers = new Vector<String>();
	private Vector<String> vcRooms = new Vector<String>();
	private StringTokenizer st; // ?
	private String myRoomName; // ?

	Client mContext = this;

	UsersocketFC userSocket;

	public Client() {
		initData();
		initAddEventListener();
	} // end of constructor

	public static void main(String[] args) {
		new Client();
	} // end of main

	public void initData() {

		mainFlag = true;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		setResizable(false);

		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		lblBgimage = new JLabel(new ImageIcon("images/diaryBackground.png"));
		lblBgimage.setSize(480, 600);
		mainPanel.add(lblBgimage);

		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setBounds(12, 27, 328, 407);
		lblBgimage.add(tabs);

		panel1 = new JPanel();
		tabs.addTab("로그인", null, panel1, null);
		panel1.setLayout(null);

		lblHostIP = new JLabel("Host_IP");
		lblHostIP.setFont(new Font("맑은고딕", Font.BOLD, 13));
		lblHostIP.setBounds(12, 25, 91, 15);
		panel1.add(lblHostIP);

		tfHostIP = new JTextField();
		tfHostIP.setFont(new Font("맑은고딕", Font.BOLD, 13));
		tfHostIP.setBounds(112, 21, 199, 21);
		panel1.add(tfHostIP);
		tfHostIP.setColumns(10);
		tfHostIP.setText("127.0.0.1");

		lblServerPort = new JLabel("Server_Port");
		lblServerPort.setFont(new Font("맑은고딕", Font.BOLD, 13));
		lblServerPort.setBounds(12, 72, 91, 15);
		panel1.add(lblServerPort);

		tfServerPort = new JTextField();
		tfServerPort.setFont(new Font("맑은고딕", Font.BOLD, 13));
		tfServerPort.setBounds(112, 69, 199, 21);
		tfServerPort.setColumns(10);
		panel1.add(tfServerPort);

		lblUserID = new JLabel("User_ID");
		lblUserID.setFont(new Font("맑은고딕", Font.BOLD, 13));
		lblUserID.setBounds(12, 122, 91, 15);
		panel1.add(lblUserID);

		tfUserID = new JTextField();
		tfUserID.setBounds(112, 119, 199, 21);
		tfUserID.setColumns(10);
		panel1.add(tfUserID);

		btnConnect = new JButton("connect");
		btnConnect.setFont(new Font("맑은고딕", Font.BOLD, 13));
		btnConnect.setBounds(214, 162, 97, 23);
		panel1.add(btnConnect);

		panel2 = new JPanel();
		tabs.addTab("대기실", null, panel2, null);
		panel2.setLayout(null);

		lblTotalUserLst = new JLabel("전체접속자");
		lblTotalUserLst.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalUserLst.setFont(new Font("맑은고딕", Font.BOLD, 13));
		lblTotalUserLst.setBounds(12, 28, 102, 15);
		panel2.add(lblTotalUserLst);

		lblTotalRoomLst = new JLabel("방 리스트");
		lblTotalRoomLst.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalRoomLst.setFont(new Font("맑은고딕", Font.BOLD, 13));
		lblTotalRoomLst.setBounds(209, 27, 102, 15);
		panel2.add(lblTotalRoomLst);

		lstTotalUser = new JList();
		lstTotalUser.setBounds(12, 69, 102, 257);
		panel2.add(lstTotalUser);
		lstRooms = new JList();
		lstRooms.setBounds(209, 69, 102, 257);
		panel2.add(lstRooms);

		btnSendPrivateMsg = new JButton("쪽지보내기");
		btnSendPrivateMsg.setFont(new Font("맑은고딕", Font.BOLD, 13));
		btnSendPrivateMsg.setBounds(12, 345, 102, 23);
		panel2.add(btnSendPrivateMsg);

		btnJoinInChatRoom = new JButton("채팅방참여");
		btnJoinInChatRoom.setFont(new Font("맑은고딕", Font.BOLD, 13));
		btnJoinInChatRoom.setBounds(209, 345, 102, 23);
		panel2.add(btnJoinInChatRoom);

		panel3 = new JPanel();
		tabs.addTab("채팅", null, panel3, null);
		panel3.setLayout(null);

		txtAreaViewChat = new JTextArea();
		txtAreaViewChat.setEnabled(false);
		txtAreaViewChat.setEditable(false);
		txtAreaViewChat.setFont(new Font("맑은고딕", Font.BOLD, 13));
		txtAreaViewChat.setBounds(0, 0, 323, 337);
		panel3.add(txtAreaViewChat);

		tfForChat = new JTextField();
		tfForChat.setFont(new Font("맑은고딕", Font.BOLD, 13));
		tfForChat.setBounds(0, 347, 214, 21);
		tfForChat.setColumns(10);
		panel3.add(tfForChat);

		btnSubmit = new JButton("전송");
		btnSubmit.setFont(new Font("맑은고딕", Font.BOLD, 13));
		btnSubmit.setBounds(226, 346, 97, 23);
		panel3.add(btnSubmit);

		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setEnabled(false);
		scrollPane.setBounds(0, 0, 323, 337);
		panel3.add(scrollPane);

		btnMakeRoom = new JButton("방 만들기");
		btnMakeRoom.setFont(new Font("맑은고딕", Font.BOLD, 13));
		btnMakeRoom.setBounds(352, 93, 97, 23);
		lblBgimage.add(btnMakeRoom);

		btnOutRoom = new JButton("방나가기");
		btnOutRoom.setFont(new Font("맑은고딕", Font.BOLD, 13));
		btnOutRoom.setBounds(352, 150, 97, 23);
		lblBgimage.add(btnOutRoom);
//		btnOutRoom.setEnabled(false);
		btnEndChat = new JButton("종료");
		btnEndChat.setBounds(352, 398, 97, 23);
		lblBgimage.add(btnEndChat);
		setVisible(true);

	}

	public void initAddEventListener() {

		// 로그인패널
		btnConnect.addActionListener(this);
		// 대기실패널 버튼
		btnSendPrivateMsg.addActionListener(this);
		btnJoinInChatRoom.addActionListener(this);
		// 채팅패널 버튼
		btnSubmit.addActionListener(this);
		// 메인패널 btnJoinInChatRoom버튼
		btnMakeRoom.addActionListener(this);
		btnOutRoom.addActionListener(this);
		btnEndChat.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConnect) { // connect버튼 누르면
			if (tfHostIP.getText().length() == 0) {
				tfHostIP.setText("IP를 입력하세요.");
				tfHostIP.requestFocus();
			} else if (tfServerPort.getText().length() == 0) {
				tfServerPort.setText("포트번호를 입력하세요");
				tfServerPort.requestFocus();
			} else if (tfUserID.getText().length() == 0) {
				tfUserID.setText("id를 입력하세요");
				tfUserID.requestFocus();

			} else {
				serverIP = tfHostIP.getText();
				serverPort = Integer.parseInt(tfServerPort.getText().trim());
				userId = tfUserID.getText().trim();
				connect();
				setTitle("[" + userId + "]님, 루피톡에 오신걸 환영합니다.");
			}
		} else if (e.getSource() == btnSubmit) {
			System.out.println("여기 호출???");
			userSocket.sendMessage(tfForChat.getText());
			tfForChat.setText("");
		} else if (e.getSource() == btnEndChat) {
			System.out.println("클라이언트 종료");
			System.exit(0);
		} else if (e.getSource() == btnSendPrivateMsg) {
			System.out.println("쪽지보내기 버튼 클릭");
			String targetUser = (String) lstTotalUser.getSelectedValue();
			if (targetUser == null) {
				JOptionPane.showMessageDialog(null, "대상을 선택하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			String privateMsg = JOptionPane.showInputDialog("보낼메시지");
			if (privateMsg != null) {
				userSocket.sendMessage("PrivateMsg to/" + targetUser + "@" + privateMsg);
			}
		} else if (e.getSource() == btnJoinInChatRoom) {
			System.out.println("채팅방참여 버튼 클릭");
			String joinRoom = (String) lstRooms.getSelectedValue();
			btnOutRoom.setEnabled(true);
			btnMakeRoom.setEnabled(false);
			userSocket.sendMessage("JoinRoom/" + joinRoom);
			// TODO
		} else if (e.getSource() == btnMakeRoom) {
			System.out.println("방 만들기 버튼 클릭");
			String roomName = JOptionPane.showInputDialog("방 이름을 입력하세요");
			if (roomName != null) {
				userSocket.sendMessage("CreateRoom/" + roomName);
			}
		} else if (e.getSource() == btnEndChat) {
			System.out.println("방 나가기 버튼 클릭");
			userSocket.sendMessage("OutRoom/" + myRoomName);
		} else if (e.getSource() == tfForChat) {
			if (tfForChat.getText().length() == 0) {
				System.out.println("이게 0값이면 뭐길래 쌤이 적어노신거지");
				userSocket.sendMessage("Chatting/" + myRoomName + "/" + tfForChat.getText() + "  ");
			} else {
				userSocket.sendMessage("Chatting/" + myRoomName + "/" + tfForChat.getText());
			}
		}
		tfForChat.setText("");
	}// end of actionPerformed

	@Override
	public void connect() {
		System.out.println("1. 클라이언트 소켓 시작");
		try {
			serverIP = tfHostIP.getText();
			serverPort = Integer.parseInt(tfServerPort.getText().trim());
			socket = new Socket(serverIP, serverPort);
			userSocket = new UsersocketFC(mContext, socket);
			userSocket.start();
			System.out.println("이거 찍히면 userSocket쓰레드 돌려놓고 다시 client로 돌아온거임");
//이래 하는 거 맞나?
			userId = tfUserID.getText().trim();
			userSocket.sendMessage(userId);
			vcUsers.add(userId);
			lstTotalUser.setListData(vcUsers);

		} catch (UnknownHostException e) {
			System.out.println("클라이언트소켓 예외발생 : " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("클라이언트소켓 예외발생 : " + e.getMessage());
			e.printStackTrace();
		}

	}

} // end of outer-class
