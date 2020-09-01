
package BT3;
 
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
 
public class ClientDemo extends ServerProgram{
 
   public static void main(String[] args) throws IOException {
 
       // Địa chỉ máy chủ.
       final String serverHost = "localhost";
 
       Socket socketOfClient = null;
       BufferedWriter os = null;
       BufferedReader is = null;
 
       try {
           // Gửi yêu cầu kết nối tới Server đang lắng nghe
           // trên máy 'localhost' cổng 7777.
           socketOfClient = new Socket(serverHost, 7777);
 
           // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
           os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
 
           // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
           is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
 
       } catch (UnknownHostException e) {
           System.err.println("Don't know about host " + serverHost);
           return;
       } catch (IOException e) {
           System.err.println("Couldn't get I/O for the connection to " + serverHost);
           return;
       }
       Scanner sc =new Scanner(System.in);
       System.out.print("May1: ");
       String send=sc.nextLine();
       os.write(send);
       os.newLine();
       os.flush();
       try {
           // Ghi dữ liệu vào luồng đầu ra của Socket tại Client.
           while(true)
           {
        	   
        	   String responseLine;
               if ((responseLine = is.readLine()) != null) {
                   System.out.println( responseLine);
                   
               }   
               if (responseLine.indexOf("OK") != -1) {
                   break;
               }
               System.out.print("May1: ");
               send=sc.nextLine();
               os.write(send);
               os.newLine();
               os.flush();
           }
           // Đọc dữ liệu trả lời từ phía server
           // Bằng cách đọc luồng đầu vào của Socket tại Client.
           
 
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