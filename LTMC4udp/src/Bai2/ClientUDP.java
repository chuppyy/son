package Bai2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientUDP {

	private static String checkCaculation(String line) {
		String op="", a="", b="";
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i)==' ') continue;
			else if(line.charAt(i)=='+'||line.charAt(i)=='-'||line.charAt(i)=='*'||line.charAt(i)=='/') {				
				if((a.equals(""))||(!op.equals(""))) return "false";
				else {
					op+=line.charAt(i);
				}
			}else if(Character.getNumericValue(line.charAt(i))<10){
				if(op.equals("")) {
					a+=line.charAt(i);
				}else {
					b+=line.charAt(i);
				}
			}else {
				return "false";
			}
		}
		if(op.equals("")||op.equals("")||op.equals("")) return "false";
		String result=op+" "+a+" "+b;
		return result;
	}
	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName("localhost");
		DatagramSocket datagramSocket = new DatagramSocket();
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("Your request: ");
			String request = scanner.nextLine();
			if (request.equals("quit")) {
				System.out.println("Client Stopped.");
				datagramSocket.close();
				break;
			}
			if(checkCaculation(request).equals("false")) {
				System.out.println("errr");
			}else {
				request = checkCaculation(request);
				DatagramPacket datagramPacket = new DatagramPacket(request.getBytes(), request.length(),address,7);
				datagramSocket.send(datagramPacket);
						
				byte[] data = new byte[6000];
				DatagramPacket datagramPacket2 = new DatagramPacket(data, data.length);
				datagramSocket.receive(datagramPacket2);
				String response = new String(datagramPacket2.getData(),0,datagramPacket2.getLength());
				System.out.println("Received from Server: " + response);
			}
			
		}
		
	}

}