package Bai4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai4ClientUDP {
	
	public static void main(String[] args) throws IOException {
		
		InetAddress address = InetAddress.getByName("localhost");
		DatagramSocket datagramSocket = new DatagramSocket();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String request = scanner.nextLine();
			if (request.equals("quit")) {
				System.out.println("Client Stopped.");
				datagramSocket.close();
				break;
			}
			DatagramPacket datagramPacket = new DatagramPacket(request.getBytes(), request.length(),address,7);
			datagramSocket.send(datagramPacket);
			byte[] data = new byte[6000];
			DatagramPacket datagramPacket2 = new DatagramPacket(data, data.length);
			datagramSocket.receive(datagramPacket2);
			String response = new String(datagramPacket2.getData(),0,datagramPacket2.getLength());
			if(response.equals("Exit ok")) {
				datagramSocket.close();
				break;
			}else	System.out.println("Received from Server:\n" + response);
		}
		
	}
}