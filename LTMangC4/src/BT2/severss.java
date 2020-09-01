package BT2;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class severss {
 
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
   public static double Caculations(String line) {
		String a="", b="";
		char op=line.charAt(0);
		boolean aDone=false;
		for(int i=2; i<line.length(); i++) {
			if(line.charAt(i)==' ') {
				aDone=true;
				continue;
			}
			if(!aDone) {
				a+=line.charAt(i);
			}else {
				b+=line.charAt(i);
			}
		}
		if(op=='+') return (Integer.parseInt(a)+Integer.parseInt(b));
		else if(op=='-') return (Integer.parseInt(a)-Integer.parseInt(b));
		else if(op=='*') return Integer.parseInt(a)*Integer.parseInt(b);
		else if(op=='/') return Integer.parseInt(a)/Integer.parseInt(b);
		return 0;
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
        	
   			// Get data from client
   			BufferedReader br = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));				
   			String request = br.readLine();
   			if(request!=null) {
   				System.out.println("Received from a client:" + request);
   				//Calculations
   				PrintStream ps = new PrintStream(socketOfServer.getOutputStream());
   				String response = String.valueOf(Caculations(request));
   				
   				//Response to client
   				ps.println("Result = "+ response);
   			}
           } catch (IOException e) {
               System.out.println(e);
               e.printStackTrace();
           }
       }
   }
}