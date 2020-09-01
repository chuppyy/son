package Bai1;

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
		System.out.println("Start server!!!!!!");
		while(true) {
			byte[] inputByte= new byte[60000];
			byte[] outputByte= new byte[60000];
			String out;
			DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
			socket.receive(inputPack);
			String inputStr= new String(inputPack.getData(),0,inputPack.getLength());
			for (int i = 0; i < inputStr.length(); i++) {
				switch(inputStr.charAt(i)) {
					case '0':{
						out="Khong";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '1':{
						out="Mot";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '2':{
						out="Hai";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '3':{
						out="Ba";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '4':{
						out="Bon";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '5':{
						out="Nam";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '6':{
						out="Sau";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '7':{
						out="Bay";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '8':{
						out="Tam";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
					case '9':{
						out="Chin";
						outputByte=out.getBytes();
						DatagramPacket outputPack=new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(),inputPack.getPort());
						socket.send(outputPack);
						break;
					}
				}
			}
		}
	}
}
