package BT1ss;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class BT1ssclient {

  public static void main(String[] args) {
	  final String serverHost = "localhost";
	  Socket socketOfClient = null;
      BufferedWriter os = null;
      BufferedReader is = null;

      try {
    	  socketOfClient = new Socket(serverHost, 7777);
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