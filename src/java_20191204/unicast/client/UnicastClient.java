package java_20191204.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener{
	//메세지를 지속적으로 보내기 위한 부분 필요
	//GUI로 간단히만...
	private JFrame jframe;
	private JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	
	//이번건 개인 채팅용
	public UnicastClient(String id,String ip,int port){
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		jframe = new JFrame("Unicast Chatting");
		/***north start****/
		JPanel  j1 = new JPanel();
		//패널로 해야 여러개 생성 가능
		JLabel jl1=new JLabel("User ID : ["+id+"]");
		JLabel jl2=new JLabel("Server IP : "+ip);
		//flow layout이라 바꿔줘야 함...
		j1.setLayout(new BorderLayout());
		j1.add(jl1,BorderLayout.CENTER);
		j1.add(jl2,BorderLayout.EAST);
		/***north end****/
		/*****************Center****/
		jta = new JTextArea("",20,50);
		JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//									수직 수평 스크롤 여부
		jta.setBackground(new Color(200,200,255));
		jta.setEditable(false);
		/******************CE****/
		
		/*********SouthS****/
		JPanel  j2 = new JPanel();
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		j2.setLayout(new BorderLayout());
		j2.add(jtf,BorderLayout.CENTER);
		j2.add(jbtn,BorderLayout.EAST);
		/******************SE****/
		
		jframe.add(j1,BorderLayout.NORTH);
		jframe.add(jsp);
//		,boarderLayout.center
		jframe.add(j2,BorderLayout.SOUTH);
		
		
		jframe.pack();
		//버튼 같은거 있으면 맞춰서 줘
		jframe.setResizable(false);
		jframe.setVisible(true);
		//창 닫아도 사라지지 않음,감춰진거고 죽지 않아서...나중에 알려줌
		
		//btn event
		jbtn.addActionListener(this);
		//					액션리스너(인터페이스)
		jtf.addActionListener(this);
		
		jframe.addWindowListener(new WindowAdapter() {
			//위의 버튼 누르는거
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			public void windowOpened(WindowEvent e){
				jtf.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("MOEW","192.168.0.223",3000);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// event handling
		Object obj = e.getSource();
		String message = jtf.getText();
		if(obj == jbtn){
			jta.append(id +" : "+ message +"\n");
			jtf.setText("");
		}else if(obj == jtf){
			//	이벤트...걸면 엔터치면 커서가 창으로 이동하니까...그걸 이용.
			jta.append(id +" : "+ message +"\n");
			jtf.setText("");
		}
		
	}

}
