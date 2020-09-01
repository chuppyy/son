package BT2;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class clientss2 {
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
  public static void main(String[] args) {
	  final String serverHost = "localhost";
	  Socket socket = null;
      BufferedWriter os = null;
      BufferedReader is = null;

      try {
    	  socket = new Socket(serverHost, 7777);
    	  os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    	  is = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
      } catch (UnknownHostException e) {
          System.err.println("Don't know about host " + serverHost);
          return;
      } catch (IOException e) {
          System.err.println("Couldn't get I/O for the connection to " + serverHost);
          return;
      }

      try {
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
          System.err.println("Trying to connect to unknown host: " + e);
      } catch (IOException e) {
          System.err.println("IOException:  " + e);
      }
  }

}