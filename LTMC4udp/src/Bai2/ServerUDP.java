package Bai2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class ServerUDP {

	private static double Caculations(String line) {
		String a="", b="";
		char op=line.charAt(0);
		boolean aDone=false;
		for(int i=2; i<line.length(); i++) {
			if(line.charAt(i)==' ') {
				aDone=true;
				continue;
			}
			if(!aDone) {
				a+=line.charAt(i);
			}else {
				b+=line.charAt(i);
			}
		}
		if(op=='+') return (Integer.parseInt(a)+Integer.parseInt(b));
		else if(op=='-') return (Double.parseDouble(a)-Double.parseDouble(b));
		else if(op=='*') return Double.parseDouble(a)*Double.parseDouble(b);
		else if(op=='/') return Double.parseDouble(a)/Double.parseDouble(b);
		return 0;
	}
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(7);
		Scanner scanner = new Scanner(System.in);
		byte[] data = new byte[6000];
		System.out.println("Server started");
		while (true) {
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
			datagramSocket.receive(datagramPacket);
			String request = new String(datagramPacket.getData(),0,datagramPacket.getLength());
			System.out.println("Receive from Client: "+ request);
			double result = Caculations(request);
			String response = "Result = "+ Double.toString(result);
			System.out.println("Send to client: "+ response);
			DatagramPacket datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
			datagramSocket.send(datagramPacket2);
		}
	}
}