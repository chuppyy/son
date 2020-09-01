package BT1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.Scanner;

public class clientbt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final String serverHost = "localhost";
		 
	       Socket socketOfClient = null;
	       BufferedWriter os = null;
	       BufferedReader is = null;
	 
	       try {
	    	   socketOfClient = new Socket(serverHost, 9999);
	    	   os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
	    	   is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
	 
	       } catch (UnknownHostException e) {
	           System.err.println("Don't know about host " + serverHost);
	           return;
	       } catch (IOException e) {
	           System.err.println("Couldn't get I/O for the connection to " + serverHost);
	           return;
	       }
	 
	       try {
	    	   System.out.println("Nhap so nguyen");
	    	   Scanner sc=new Scanner(System.in);
	    	   String send=sc.nextLine();
	    	   while(!(send.equals("quit"))) {
	    	   os.write(send);
	           os.newLine(); // kết thúc dòng
	           os.flush();  // đẩy dữ liệu đi.
	           String responseLine;
	           for (int i=0;i<send.length();i++) {
	        	   responseLine=is.readLine();
	        	   System.out.print(responseLine+ " ");
	           }
	           System.out.println("");
	           //os.newLine();
	           System.out.println("Nhap so nguyen, nhap 'quit' de kt! ");
	           send=sc.nextLine();
	           
	    	   }
	           os.close();
	           is.close();
	           socketOfClient.close();
	       } catch (UnknownHostException e) {
	           System.err.println("Trying to connect to unknown host: " + e);
	       } catch (IOException e) {
	           System.err.println("IOException:  " + e);
	       }
	}

}
