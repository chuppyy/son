package Bai4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai4ServerUDP {
	private String username="admin";
	private String password="123";
	private static boolean login=true;
	private static ArrayList<String> account = new ArrayList<String>();
	private static boolean checkAccount(String username, String password) {
		for(int i=0; i<account.size(); i++) {
			if(account.get(i).equals(username +"/"+password)) {
				return true;
			}
		}
		return false;
	} 
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(7);
		byte[] data = new byte[6000];
		System.out.println("Server started");
		
		while (login) {
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
			datagramSocket.receive(datagramPacket);
			String response = "1. Login\n2. Register\n3. Exit";
			DatagramPacket datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
			datagramSocket.send(datagramPacket2);
			datagramSocket.receive(datagramPacket);
			String Username, Password;
			String request = new String(datagramPacket.getData(),0,datagramPacket.getLength());
			switch (request) {
			case "1":
				System.out.println("Client requesting login");
				response= "Enter Username: ";
				datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
				datagramSocket.send(datagramPacket2);
				datagramSocket.receive(datagramPacket);
				Username = new String(datagramPacket.getData(),0,datagramPacket.getLength());
				
				response= "Enter Password: ";
				datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
				datagramSocket.send(datagramPacket2);
				datagramSocket.receive(datagramPacket);
				Password = new String(datagramPacket.getData(),0,datagramPacket.getLength());
				if(checkAccount(Username, Password)) {
					response= "Login Successful";
					datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
					datagramSocket.send(datagramPacket2);
					login=false;
				}else {
					response= "Username or password is incorrect!";
					datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
					datagramSocket.send(datagramPacket2);
				}
				
				break;
			case "2":
				
				System.out.println("Client requesting registy");
				response= "Enter Username for new Account : ";
				datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
				datagramSocket.send(datagramPacket2);
				datagramSocket.receive(datagramPacket);
				Username = new String(datagramPacket.getData(),0,datagramPacket.getLength());
				
				response= "Enter Password: ";
				datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
				datagramSocket.send(datagramPacket2);
				datagramSocket.receive(datagramPacket);
				Password = new String(datagramPacket.getData(),0,datagramPacket.getLength());
				if(Username.equals("")||Password.equals("")) {
					response= "Username or password is empty!";
					datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
					datagramSocket.send(datagramPacket2);
				}else {
					response= "Register Successfull!";
					account.add(Username+"/"+Password);
					datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
					datagramSocket.send(datagramPacket2);
				}
				break;
			case "3":
				System.out.println("Client exited");
				response= "Exit ok";
				datagramPacket2 = new DatagramPacket(response.getBytes(), response.length(),datagramPacket.getAddress(),datagramPacket.getPort());
				datagramSocket.send(datagramPacket2);
				break;
			default:
				break;
			}
		}
	}
}