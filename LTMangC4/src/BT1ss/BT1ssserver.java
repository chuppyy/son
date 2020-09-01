package BT1ss;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class BT1ssserver {
 
   public static void main(String args[]) throws IOException {
 
       ServerSocket listener = null;
       System.out.println("Server is waiting to accept user...");
       int clientNumber = 0;
       try {
           listener = new ServerSocket(7777);
       } catch (IOException e) {
           System.out.println(e);
           System.exit(1);
       }
 
       try {
           while (true) {
        	   Socket socketOfServer = listener.accept();
               new ServiceThread(socketOfServer, clientNumber++).start();
           }
       } finally {
           listener.close();
       }
 
   }
 
   private static void log(String message) {
       System.out.println(message);
   }
 
   private static class ServiceThread extends Thread {
	   String line;
       private int clientNumber;
       private Socket socketOfServer;
 
       public ServiceThread(Socket socketOfServer, int clientNumber) {
           this.clientNumber = clientNumber;
           this.socketOfServer = socketOfServer;
           log("New connection with client# " + this.clientNumber + " at " + socketOfServer);
       }
 
       @Override
       public void run() {
 
           try {
        	   BufferedReader is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
               BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
 
               while (true) {
            	   line = is.readLine();
	        	   for(int i=0;i<line.length();i++) {
	        		switch (line.charAt(i)) {
					case '0':
						os.write("Khong");
						os.newLine();
						os.flush();
						break;
					case '1':
						if(line.length()==2) {
						os.write("Muoi");
						os.newLine();
						os.flush();
						break;
						}else {
						os.write("Mot");
						os.newLine();
						os.flush();
						break;
						}
					case '2':
						os.write("Hai");
						os.newLine();
						os.flush();
						break;
					case '3':
						os.write("Ba");
						os.newLine();
						os.flush();
						break;
					case '4':
						os.write("Bon");
						os.newLine();
						os.flush();
						break;
					case '5':
						os.write("Nam");
						os.newLine();
						os.flush();
						break;
					case '6':
						os.write("Sau");
						os.newLine();
						os.flush();
						break;
					case '7':
						os.write("Bay");
						os.newLine();
						os.flush();
						break;
					case '8':
						os.write("Tam");
						os.newLine();
						os.flush();
						break;
					case '9':
						os.write("9");
						os.newLine();
						os.flush();
						break;
					

					default:
						os.write(">> Khong phai so nguyen");
						os.newLine();
						os.flush();
						break;
					}
	        	   }
              }
 
           } catch (IOException e) {
               System.out.println(e);
               e.printStackTrace();
           }
       }
   }
}