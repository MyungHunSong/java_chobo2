package java_chobo2.ch16.tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpServerClient {

	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			
			System.out.println("서버에 연결중입니다. 서버 Ip" + serverIp);
			
			Socket socket = new Socket(serverIp, 7777);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("서버로 부터 밭은 메세지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
			dis.close();
			socket.close();
			System.out.println("연결이 종료됨.");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
