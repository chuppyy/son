package Bai1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	private static final int Port=13;
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		
		InetAddress serverAdress = InetAddress.getByName("127.0.0.1");
		Scanner sc =new Scanner(System.in);
		System.out.println("Nhap so nguyen: , nhap quit de ket thuc nhap!!!");
		String request = sc.next();
		while(!(request.equals("quit"))) {
			
			byte[] outputByte=request.getBytes();
			DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length, serverAdress,Port);
			socket.send(outputPack);
			
			
			for (int i = 0; i < request.length(); i++) {
				byte[] intputByte= new byte[60000];
				DatagramPacket inputPack=new DatagramPacket(intputByte, intputByte.length);
				socket.receive(inputPack);
				String inputStr = new String(inputPack.getData(),0,inputPack.getLength());
				System.out.print(inputStr+" ");
			}
			
			System.out.println("\nNhap so nguyen: , nhap quit de ket thuc nhap!!!");
			request = sc.next();
		}
	}
}
