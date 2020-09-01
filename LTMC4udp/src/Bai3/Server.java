package Bai3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
	private static final int Port =13;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket socket=new DatagramSocket(Port);
		while(true) {
			//Nhan
			byte[] inputByte = new byte[60000];
			DatagramPacket inputPack =new DatagramPacket(inputByte, inputByte.length);
			socket.receive(inputPack);
			String inputStr=new String(inputPack.getData(),0,inputPack.getLength());
			System.out.println("Máy 1 : "+inputStr);
			
			//Gui
			System.out.print("Máy 2 : ");
			String request = sc.nextLine();
			byte[] outputByte = request.getBytes();
			DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length,inputPack.getAddress(),inputPack.getPort());
			socket.send(outputPack);
		}
	}
}
