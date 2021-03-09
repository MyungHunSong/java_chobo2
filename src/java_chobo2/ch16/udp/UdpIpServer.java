package java_chobo2.ch16.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpIpServer {
	public void start() throws IOException {
		
		// 포트 7778번을 사용하는 소켓을 생성한다
		DatagramSocket socket = new DatagramSocket(7777);
		DatagramPacket inPacket;
		DatagramPacket outPacket;
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		
		while(true) {
			
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			socket.receive(inPacket);
			
			//수신한 패킷으로 부터 client의 IP주소와 Port를 얻는다.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			//서버와 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes();
			
			// 패킷을 생성해서 client에게 전송(send) 한다.
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
		}
	}// start
	
	public static void main(String[] args) {
		try {
			new UdpIpServer().start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
