package Bai3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static final int Port=13;
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress serverAdress = InetAddress.getByName("127.0.0.1");
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			//Gui
			System.out.print("Máy 1: ");
			String request=sc.nextLine();
			byte[] outputByte = request.getBytes();
			DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length,serverAdress,Port);
			socket.send(outputPack);
			
			//Nhan
			byte[] intputByte= new byte[60000];
			DatagramPacket inputPack=new DatagramPacket(intputByte, intputByte.length);
			socket.receive(inputPack);
			String inputStr = new String(inputPack.getData(),0,inputPack.getLength());
			System.out.println("Máy 2: "+ inputStr);
		}
	}
}
