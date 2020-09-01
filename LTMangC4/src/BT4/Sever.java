package BT4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
	private String username="admin";
	private String password="123";
	public void service() {
		try {
			System.out.println("Server started"); 
			System.out.println("Waiting for a client ..."); 
			ServerSocket server = new ServerSocket(10);
			Socket socket=  server.accept();
			// Request sign in
			String requestUsername=null, requestPassword=null;

			PrintStream ps = new PrintStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
			while(true){
				ps.println("username: ");
				System.out.println("Requesting username from a client");
				requestUsername = br.readLine();
				
				ps.println("password: ");
				System.out.println("Requesting password from a client");
				requestPassword = br.readLine();
				if(requestUsername.equals(username)&&requestPassword.equals(password)) {
					ps.println("successful connection");
					System.out.println("Accepted connection");
					break;
				}else {
					ps.println("Wrong username or password! Please enter again");
					System.out.println("Wrong account");
					br.readLine();
				}
			}
			//server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Sever server = new Sever();
		server.service();
	}
}
