package java_20191205.multicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//브로드캐스트는...받는 쓰레드에서  처리 해야함.
//			우리는 통신규약(http나 ftp같은)이 애매함...싹 다 보내주는거 딱 하나.
//			패킷이나 소켓속의 데이터 패턴같은.
//	구분자보다는,byte 길이로 정의하는게 좋다.(아이디 글자수 제한 같은...)토큰을 생성하는(토큰 화) 구분자(딜리미터)는 위험함.
public class MulticastClient implements ActionListener {
	// 메세지를 지속적으로 보내기 위한 부분 필요
	// GUI로 간단히만...
	private JFrame jframe;
	private JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	private BufferedWriter bw;
	private BufferedReader br;
	private Socket socket;

	// 이번건 개인 채팅용
	//파일보내는건...스트링체이닝 노...필요....FTP
 	public MulticastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;

		jframe = new JFrame("Unicast Chatting");
		/*** north start ****/
		JPanel j1 = new JPanel();
		// 패널로 해야 여러개 생성 가능
		JLabel jl1 = new JLabel("User ID : [" + id + "]");
		JLabel jl2 = new JLabel("Server IP : " + ip);
		// flow layout이라 바꿔줘야 함...
		j1.setLayout(new BorderLayout());
		j1.add(jl1, BorderLayout.CENTER);
		j1.add(jl2, BorderLayout.EAST);
		/*** north end ****/
		/***************** Center ****/
		jta = new JTextArea("", 20, 50);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// 수직 수평 스크롤 여부
		jta.setBackground(new Color(200, 200, 255));
		jta.setEditable(false);
		/****************** CE ****/

		/********* SouthS ****/
		JPanel j2 = new JPanel();
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		j2.setLayout(new BorderLayout());
		j2.add(jtf, BorderLayout.CENTER);
		j2.add(jbtn, BorderLayout.EAST);
		/****************** SE ****/

		jframe.add(j1, BorderLayout.NORTH);
		jframe.add(jsp);
		// ,boarderLayout.center
		jframe.add(j2, BorderLayout.SOUTH);

		jframe.pack();
		// 버튼 같은거 있으면 맞춰서 줘
		jframe.setResizable(false);
		jframe.setVisible(true);
		// 창 닫아도 사라지지 않음,감춰진거고 죽지 않아서...나중에 알려줌

		// btn event
		jbtn.addActionListener(this);
		// 액션리스너(인터페이스)
		jtf.addActionListener(this);

		jframe.addWindowListener(new WindowAdapter() {
			// 위의 버튼 누르는거
			public void windowClosing(WindowEvent e) {
				try {
					
					bw.write("exit");
					bw.newLine();
					bw.flush();
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
	}

	private void connect() {
		try {

			socket = new Socket(ip, port);
			// 아예 요청이 포함되어있고 생성됐으면 연결된것임.

			// 입출력 소켓 생성
			// 하지만...결국 재사용은 buffered만 있으면 됨.
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 아직은...enter 상호작용과 연결 안함.

			
			MultiClientThread mct = new MultiClientThread(br,jta);
			//							버퍼드 리더와 화면인 jst넘겨야함...하지만 this로 넘겨도.
			//			여러개 넘기기엔 this가 좀 편하긴 함...
			Thread t = new Thread(mct);
			t.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MulticastClient("223", "192.168.0.203", 3000).connect();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// event handling
		Object obj = e.getSource();
		String message = jtf.getText();
		if (obj == jbtn) {
			try {
				bw.write(id + " : " + message);
				bw.newLine();
				// 다 만들고...나중에 붙여넣으면 됨.
				bw.flush();
				// 보냈으면...이제 받으면 됨. 메시지를 서버에서 클라이언트 한테만 보내니까.

				//보내고
				//지우고
				jtf.setText("");

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj == jtf) {
			// 이벤트...걸면 엔터치면 커서가 창으로 이동하니까...그걸 이용.
			try {
				bw.write(id + " : " + message);
				bw.newLine();
				bw.flush();

				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
