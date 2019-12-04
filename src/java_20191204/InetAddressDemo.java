package java_20191204;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	//socket통신에 필요,작은 dns 역할

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress i = InetAddress.getLocalHost();
		//우리는 				언노운 오류뜬...ip 주소 받으려고.
		System.out.printf("호스트 이름 : %s%n",i.getHostName());
		System.out.printf("호스트 ip addr : %s%n",i.getHostAddress());
		
		InetAddress i1 = InetAddress.getByName("naver.com");
		System.out.printf("호스트(도메인) 이름 : %s%n",i1.getHostName());
		System.out.printf("호스트 ip addr : %s%n",i1.getHostAddress());

	}

}
