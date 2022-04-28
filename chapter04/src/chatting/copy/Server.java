package chatting.copy;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanProperty;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.SocketTimeoutException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel contentPane; // 패널을 붙여쓸건가봄
	private JTextField tfPort; // 텍스트필드는 문자를 입력한다.// 한줄만 입력가능 // 이 클래스에선 포트번호입력받는 데에 사용
	private JTextArea textArea; //텍스트에리어는 문자들을 많이 쓸 때 유용
	
	private JLabel lblPortNum; 
	private JButton btnServerStart;
	private JButton btnServerStop;

	// Network 자원
	private ServerSocket server_socket; // server-socket
	// ㄴ # ServerSocket.class
	// This class implements server sockets.
	// A server socket waits for requests to come in over the network.
	// It performs some operation based on that request, and then possibly returns a result to the requester.
	// The actual work of the server socket is performed by an instance of the {@code SocketImpl} class.
	private Socket socket; // client-socket
	// ㄴ # Socket.class
	// This class implements client sockets (also called just "sockets").
	// A socket is an end-point for communication between two machines.
	// The actual work of the socket is performed by an instance of the {@code SocketImpl} class.

	private int port;

	// 그외 자원들
	private Vector<UserInfomation> vc = new Vector<UserInfomation>();
	private Vector<RoomInfomation> vc_room = new Vector<RoomInfomation>();
	

	public Server() {
		init();
		addListener();
		tfPort.requestFocus();
	}

	// GUI 초기화
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
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

		lblPortNum = new JLabel("포트번호 :");
		lblPortNum.setBounds(12, 273, 82, 15);
		contentPane.add(lblPortNum);

		tfPort = new JTextField();
		tfPort.setBounds(98, 270, 224, 21);
		contentPane.add(tfPort);
		tfPort.setColumns(10);

		btnServerStart = new JButton("서버실행");
		btnServerStart.setBounds(12, 315, 154, 23);
		contentPane.add(btnServerStart);

		btnServerStop = new JButton("서버중지");
		btnServerStop.setBounds(168, 315, 154, 23);
		contentPane.add(btnServerStop);
		btnServerStop.setEnabled(false);

		setVisible(true);
	}

	// 이벤트 리스너
	private void addListener() {

		tfPort.addActionListener(this);
		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnServerStart) { // server시작버튼 누름 이벤트 발생
			if (tfPort.getText().length() == 0) {
				System.out.println("  값을 입력 하세요 ");
			} else if (tfPort.getText().length() != 0) { // textfield의 text 길이기ㅏ 0이 아니면,
														// 이제 서버 시작할 수 있음

				// 값을 가져와서 port변수에 저장시키기
				port = Integer.parseInt(tfPort.getText()); //통신 port번호 값 초기화
				// textField에 입력된 값을 .getText를 통해 값 들고옴.
				// 그 값을 parseInt 해줌
				
				// ㄴ # Integer.parseInt()
//			    public static int parseInt(String s) throws NumberFormatException {
//			        return parseInt(s,10);
//			    }
				//- String s를 부호있는 10진 정수로 구문분석한다.
				// @param s : int로 parsed될 String
				// @return : 10진 정수
				// @throws : NumberFormatException // 구문분석가능한 String이 없을 경우 NumberFormatException!!
				
				
				//--			
				//??근데, port번호 TextField에 666666666666666이런거 입력하면,, 정수인데 왜 NumberFormatException뜸? 
				//ㄴ 왜냐하면 정수 허용 범위는 2의 31승-1까지임. 그걸 넘겼음.
				//--
				
				
				
				startNetwork(); // 통신시작
	
				tfPort.setEditable(false); // 더 이상 포트번호 수정 할 수 없음
				// setEditable은 TextComponent가 수정될 수 있을지 없을지 나타내기 위해 설정한다.

				btnServerStart.setEnabled(false); // 서버 시작했으니까 => 시작 버튼 비활성화 
				// setEnable(boolean b) -> Enable(활성화) or disables(비활성화)
				// true (btn활성화)
				// false (btn비활성화)

				btnServerStop.setEnabled(true); // 서버 시작했으니까 => 종료 버튼 활성화
			}

		} else if (e.getSource() == btnServerStop) { // server종료버튼 누름 이벤트 발생
			try {
				server_socket.close(); // socket close
				vc.removeAllElements();
				vc_room.removeAllElements();
				tfPort.setEditable(true);
				btnServerStart.setEnabled(true);
				btnServerStop.setEnabled(false);
			} catch (IOException e1) {

			}
		}
	}

	private void startNetwork() {
		try {
			server_socket = new ServerSocket(port); 
			// a server socket을 생성 => 이 소켓을 명시된{port}번호를 가진 local port number에 할당한다.			
			// --> port번호는 1024~65535범위에서 사용자가 port넘버를 주거나, 0을 넣으면 자동으로 빈 port에 server-socket이 할당됨.
			// 0을 넣어 자동할당 되게 하면 --> ehemeral port range인 1024~65535사이에서 할당해 준다.
			
			
			
			
//		    public ServerSocket(int port) throws IOException {
//		        this(port, 50, null);
//		    }
			
			// 1. Creates a server socket and binds it to the specified local port number!!!!!!!!!!!!
			// with the specified backlog 
			// ㄴ backlog는 물리적 네트워크 포트에서 패킷을 쌓아두는 커널의 큐 크기
			
			// 2. port number'0' 
			// ㄴ->means that the port number is automatically allocated, typically from an ephemeral port range.
			// ㄴ * ephemeral port range : 1024-65535
			// This port number can then be retrieved by calling....#getLocalPort getLocalPort
			
			
			//3. 연결요청대기열은 50개이고 full일때 connection-indication들어오면 connection is refused.
			// * incoming connection indications : a request to connect
			
			//4. If the application has specified a server socket implementation factory,
			// that factory's {createSocketImpl} method is called to create the actual socket implementation.
			// 그렇지않으면 ,, a system-default socket implementation is created.
			
			// 5. If there is a security manager, its {checkListen} method is called
			// with the {port} argument as its argument --> port번호를 가지고 security manager의 method도 호출한다.
			// to ensure the operation is allowed..... --> 이 서버 소켓 사용할 수 있는지 보장받기 위해서 
			// this could result in a SecurityException --> SecurityException뜰수도 있다.
			
			// @param : port number,, --> 사용자 입력 number를 사용하거나 {0} to use a portNum that is automatically allocated.
			// @throws : 1. IOException --> if an I/O error occurs.. when opening the socket.
			// 			 2. SecurityException --> a security manager가 존재하고,
			//									 and its {checkListen} method doesn't allow the operation.
			//			 3. IllegalArgumentException --> port파라미터가 is outside the specified range of
			//											valid port values, which is 0~65535, inclusive.


			textArea.append("서버를 시작 하겠습니다.\n");
			// textArea 의 끝에 해당 text를 append 한다.
			connect();
			
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림",
					JOptionPane.ERROR_MESSAGE);
			btnServerStart.setEnabled(true); //socket 생성 안되면 버튼 활성화해줘야 한다.
			btnServerStop.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못입력하였습니다.", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void connect() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = server_socket.accept(); // -> 새로운 소켓을 생성하여서 return 값을 socket에다가 넣어준다.
						
//					    public Socket accept() throws IOException {
//					        if (isClosed())
//					            throw new SocketException("Socket is closed");
//					        if (!isBound())
//					            throw new SocketException("Socket is not bound yet");
//					        Socket s = new Socket((SocketImpl) null);  // -> 새로운 소켓을 생성하여서 return 해준다.
//					        implAccept(s);
//					        return s;
//					    }
						
						
//					    protected Socket(SocketImpl impl) throws SocketException {
//					        checkPermission(impl);
//					        this.impl = impl;
//					    }
						
						
						
						
						
						
						
						   /**
					     * Listens for a connection to be made to this socket and accepts
					     * it. The method blocks until a connection is made.
					     *
					     * <p>A new Socket {@code s} is created and, if there
					     * is a security manager,
					     * the security manager's {@code checkAccept} method is called
					     * with {@code s.getInetAddress().getHostAddress()} and
					     * {@code s.getPort()}
					     * as its arguments to ensure the operation is allowed.
					     * This could result in a SecurityException.
					     *
					     * @implNote
					     * An instance of this class using a system-default {@code SocketImpl}
					     * accepts sockets with a {@code SocketImpl} of the same type, regardless
					     * of the {@linkplain Socket#setSocketImplFactory(SocketImplFactory)
					     * client socket implementation factory}, if one has been set.
					     *
					     * @throws     IOException  if an I/O error occurs when waiting for a
					     *               connection.
					     * @throws     SecurityException  if a security manager exists and its
					     *             {@code checkAccept} method doesn't allow the operation.
					     * @throws     SocketTimeoutException if a timeout was previously set with setSoTimeout and
					     *             the timeout has been reached.
					     * @throws     java.nio.channels.IllegalBlockingModeException
					     *             if this socket has an associated channel, the channel is in
					     *             non-blocking mode, and there is no connection ready to be
					     *             accepted
					     *
					     * @return the new Socket
					     * @see SecurityManager#checkAccept
					     * @revised 1.4
					     */
						
						
						
					    /**
					     * Creates an unconnected Socket with a user-specified
					     * SocketImpl.
					     *
					     * @param impl an instance of a <B>SocketImpl</B>
					     * the subclass wishes to use on the Socket.
					     *
					     * @throws    SocketException if there is an error in the underlying protocol,
					     * such as a TCP error.
					     *
					     * @throws SecurityException if {@code impl} is non-null and a security manager is set
					     * and its {@code checkPermission} method doesn't allow {@code NetPermission("setSocketImpl")}.
					     *
					     * @since   1.1
					     */
						

						UserInfomation useInfo = new UserInfomation(socket);
						// 각각의 스레드를 등록시켜준다.
						useInfo.start();
					} catch (IOException e) {
						textArea.append("서버가 중지됨! 다시 스타트 버튼을 눌러주세요\n");
						break;
					}
				}
			}
		});
		th.start();
	}

	// 전체 사용자에게 메세지를 보내는 부분
	public void broadCast(String str) {
		for (int i = 0; i < vc.size(); i++) {
			UserInfomation uinf = vc.elementAt(i);
			// 여기서 프로토콜의 개념을 사용
			uinf.sendmessage(str);
		}
	}

	// 내부클래스
	class UserInfomation extends Thread {
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		String nickName;
		String myCurrentRoomName;
		private Socket user_socket;

		private boolean roomCheck = true;

		public UserInfomation(Socket soc) {
			this.user_socket = soc;
			network();
		}

		private void network() {
			try {
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);

				// 처음 접속시 유저의 id를 입력받는다.
				nickName = dis.readUTF();
				textArea.append("[[" + nickName + "]] 입장\n");

				// 기존사용자들에게 신규 유저의 접속을 알린다.
				broadCast("NewUser/" + nickName);

				// 자신에게 기존 사용자들을 알린다.
				for (int i = 0; i < vc.size(); i++) {
					UserInfomation uinf = vc.elementAt(i);
					sendmessage("OldUser/" + uinf.nickName);
				}
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation room = vc_room.elementAt(i);
					sendmessage("OldRoom/" + room.roomName);
				}

				// 사용자에게 자신을 알린후 벡터에 자신을 추가한다.
				vc.add(this);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// 브로드캐스트
		@Override
		public void run() {
			while (true) {
				try {
					String msg = dis.readUTF();
					textArea.append("[["+ nickName + "]]" + msg + "\n");
					inmessage(msg);
				} catch (IOException e) {
					try {
						textArea.append(nickName + " : 사용자접속끊어짐\n");
						dos.close();
						dis.close();
						user_socket.close();
						vc.remove(this);
						vc_room.remove(this);
						broadCast("UserOut/" + nickName);
						broadCast("ErrorOutRoom/"+myCurrentRoomName);
						broadCast("UserData_Updata/ok");
						break;
					} catch (IOException e1) {
						break;
					}
				}
			}
		}

		private void inmessage(String str) {
			StringTokenizer st = new StringTokenizer(str, "/");
			
			// public StringTokenizer(String str, String delim) {
			// 			this(str, delim, false);
			// }
			
			// 1.str에 대한 a string tokenizer를 생성한다.
			
			// 2. delim에 해당하는 문자는 각각 토큰을 seperate하기 위한 구분자(delimiters)이다.
			
			// 3. 구분자들은 토큰으로 다뤄지지 않는다. 
			
			// 4. 만약 delimiter가 null이면, exception을 던지지는 않지만,
			// StringTokenizer에서 다른 메서드를 호출하려고 하면 NullPointerException 뜬다.\		
				//ㄴ if {@code delim} is null, this constructor does not throw an exception.
				// However, trying to invoke other methods on the resulting {@code StringTokenizer}
				// may result in a NullPointerException.

			
			

			String protocol = st.nextToken();
			String message = st.nextToken();

			System.out.println("protocol : " + protocol);
			System.out.println("message : " + message);

			if (protocol.equals("Note")) {
				System.out.println(message);
				st = new StringTokenizer(message, "@");
				String user = st.nextToken();
				String note = st.nextToken();
				// 백터에서 해당 사용자를 찾아서 쪽지를 전송한다.
				for (int i = 0; i < vc.size(); i++) {
					UserInfomation u = vc.elementAt(i);
					// 쪽지는 반드시 찾은 사용자에게 메세지를 보내줘어야 한다.
					if (u.nickName.equals(user)) {
						u.sendmessage("Note/" + nickName + "@" + note);
					}
				}
			} else if (protocol.equals("CreateRoom")) {
				// 1.현재같은방이 존재하는지 확인한다.
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation room = vc_room.elementAt(i);
					if (room.roomName.equals(message)) { // 만들고자하는방이름을 확인한다
						sendmessage("CreateRoomFail/ok");
						roomCheck = false;
						break;
					} else {
						roomCheck = true;
					}
				} // end for
				if (roomCheck == true) {
					// 1.방을 생성한다.
					RoomInfomation new_room = new RoomInfomation(message, this);
					// 2. 전체 방 벡터에 생성된 방을 저장한다.
					vc_room.add(new_room);
					// 3.사용자들에게 방과 방이름을 생성되었다고 알려준다.
					sendmessage("CreateRoom/" + message); // 자신에게 방 성공 메세지를 보낸다.
					broadCast("new_Room/" + message);
				}
			} else if (protocol.equals("Chatting")) {
				String msg = st.nextToken();
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						r.roomBroadcast("Chatting/" + nickName + "/" + msg);
					}
				}
			} else if (protocol.equals("JoinRoom")) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						// 신규접속자를 알린다.
						r.roomBroadcast("Chatting/[[알림]]/(((" + nickName
								+ " 입장))) ");
						r.addUser(this); // 해당 룸 객체에 자신을 추가시킨다.
						sendmessage("JoinRoom/" + message);
					}
				}
			} else if (protocol.equals("OutRoom")) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						r.removeRoom(this);
						sendmessage("OutRoom/ok");
						break;
					}
				}
			}
		}

		private void sendmessage(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 내부클래스
	class RoomInfomation {

		String roomName;
		Vector<UserInfomation> room_user_vc = new Vector<UserInfomation>();

		public RoomInfomation(String roomName, UserInfomation u) {
			this.roomName = roomName;
			this.room_user_vc.add(u);
			//와우 대박. ㅋㅋ
			u.myCurrentRoomName = roomName;
		}

		private void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다.
			for (int i = 0; i < room_user_vc.size(); i++) {
				UserInfomation u = room_user_vc.elementAt(i);
				u.sendmessage(str);
			}
		}

		private void addUser(UserInfomation u) {
			room_user_vc.add(u);
		}
		@Override
		public String toString() {
			return roomName;
		}

		private void removeRoom(UserInfomation u) {
			room_user_vc.remove(u);
			boolean empty = room_user_vc.isEmpty();
			if (empty) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(roomName)) {
						vc_room.remove(this);
						broadCast("EmptyRoom/"+roomName);
						broadCast("UserData_Updata/ok");
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}

