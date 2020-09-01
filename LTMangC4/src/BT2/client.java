package BT2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public void connect() {
		try {
			Socket socket = new Socket("localhost",10);
			System.out.println("Connected");
			PrintStream ps = new PrintStream(socket.getOutputStream());
			Scanner myObj = new Scanner(System.in);
			String line="";

			//Sending
			System.out.println("Enter Caculation: ");
			while(true) {
				line = myObj.nextLine();
				if(checkCaculation(line).equals("false")) {
					System.out.println("Wrong syntax. Please enter again!");
				}else {
					ps.println(checkCaculation(line));
					break;
				}
			}
			
			//Receiving from server
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = br.readLine();
			if(response!=null) {
				System.out.println("Server answered: " + response);
			}
			myObj.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String checkCaculation(String line) {
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
	public static void main(String[] args) {
		client client = new client();
		client.connect();
	}
}