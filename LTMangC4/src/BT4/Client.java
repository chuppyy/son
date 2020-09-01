package BT4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public void connect() {
		try {
			Socket socket = new Socket("localhost",10);
			
			//Sending
			PrintStream ps = new PrintStream(socket.getOutputStream());
			Scanner myObj = new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = null;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				//Receiving from server
				String response = br.readLine();
				if(response!=null) {
					System.out.println(response);
				}
				line = myObj.nextLine();
				ps.println(line);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		Client client = new Client();
		client.connect();
	}
}
