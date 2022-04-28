/*
 * 踰꾨툝�봽�젅�엫�씠 硫붿씤媛�吏�怨� �엳怨�
 * 踰꾨툝�룄 �뒪�깮�뿉 �엳怨�
 * �뵆�젅�씠�뼱�룄 �뒪�깮�뿉 �엳怨�
 * 
 * �옄諛붿뿉�꽌 留뚮뱶�뒗 紐⑤뱺 �봽濡쒓렇�옩��
 * 利� 硫붿씤�븿�닔瑜� 媛�吏� �겢�옒�뒪�뒗 紐⑤뱺 媛앹껜�쓽 heap�젙蹂대�� 媛�吏�怨� �엳�떎.**********************
 * 
 * - 踰꾨툝�봽�젅�엫�쓣 硫붿씤�쑝濡� 留뚮뱾�뿀�뒗�뜲
 * player�뿉 ���븳 �젙蹂�, bubble, backgroundMap �벑 ��遺�遺꾩쓽 二쇱냼媛믪쓣 媛�吏�怨� �엳�떎.
 * 
 * @ context媛쒕뀗
 * - main�뿉�뒗 �씠 �봽濡쒓렇�옩 �솚寃쎌젙蹂대�� 媛�吏�怨� �엳�떎.
 * �씠�윴 '媛앹껜�뿉���븳 �젙蹂�'瑜� context�씪 �븳�떎. 
 * 
 * 
 * - �룜�븘吏�怨� �삱�씪媛� bubble�씠 2珥덈뮘�뿉 �궗�씪吏�怨� 洹몃┝�쓣 �떎�떆 洹몃젮以섏빞 �븳�떎.
 * �씠 寃껋쓣 �쐞�빐 context�씪�뒗 媛쒕뀗�씠 �븘�슂
 * */

package tenco.com.test_17.test0001;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);

	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("C:\\workspaceboot_002\\workspaceboot_002\\tenco_01\\images/backgroundMap.png"));
		setContentPane(backgroundMap);

		player = new Player();
		add(player);

	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // CSS�쓽 absolute媛쒕뀗. 醫뚰몴媛믪쑝濡� �옄�쑀濡�寃� 洹몃┫ �닔 �엳�떎.

		setLocationRelativeTo(null);// JFrame�쐢�룄�슦 李쎌쓽 媛��슫�뜲�뿉 諛곗튂
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// true, false

					if (!player.isLeft() && !player.isLeftWallCrash()) { // 諛⑹뼱�쟻肄붾뱶
						player.left();
					}

					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:

					// �몮�떎 true true�릺�뼱�빞 up�샇異�
					if (!player.isUp() && !player.isDown()) { // �삱�씪媛덈븣 怨꾩냽 �삱�씪媛�吏� �븡寃�. �뼥�뼱吏� �썑 �떎�떆 �벐�젅�뱶 �깮�꽦�빐�빞�븿.
						player.up();
					}
					break;

				case KeyEvent.VK_SPACE: // space�늻瑜대㈃ 踰꾨툝諛쒖궗
					// space�늻瑜� �븣 留덈떎 踰꾨툝 媛앹껜 �깮�꽦
					// 洹몃━怨� Bubble�겢�젅�뒪 �궡遺��뿉�꽌�뒗 initThread()瑜� �넻�빐�꽌 �벐�젅�뱶瑜� 諛쒖깮�떆�궓�떎.
					// Thread run�븷�븣 player.getPlayerWay媛� LEFT�씠硫�
					// left�븿�닔 �샇異�(left諛⑺뼢�쑝濡� �룷臾몃룎�젮 踰꾨툝 諛쒖궗)

//					Bubble bubble = new Bubble(player);
//					Bubble bubble = new Bubble(mContext); // Frame �옄湲곗옄�떊�뿉 ���븳 �젙蹂대�� 二쇱엯.�솢�깘�븯硫� 踰꾨툝�씠 Frame�씠 吏��썙�졇�빞�븯�땲源�

				
					add(player.attackBubble());//****************************************************
					break;

				default:
					break;
				} // end of switch
			} // end of keyPressed

			// �궎蹂대뱶 �빐�젣 �씠踰ㅽ듃 泥섎━
			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;

				default:
					break;
				}

			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();

	} // end of main
} // end of class
