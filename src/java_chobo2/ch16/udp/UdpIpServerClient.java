package java_chobo2.ch16.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpIpServerClient {
	
	public void strat() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		//데이터가 저장될 공간으로 byte 배열을 생성한다.
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg,1,serverAddress,7777);
		DatagramPacket inPacket = new DatagramPacket(msg,msg.length);
		
		datagramSocket.send(outPacket);
		datagramSocket.receive(inPacket);
		
		System.out.println("current server time : " + new String(inPacket.getData()));
		
		datagramSocket.close();
	}
	
	
	public static void main(String[] args) {
		try {
			new UdpIpServerClient().strat(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
