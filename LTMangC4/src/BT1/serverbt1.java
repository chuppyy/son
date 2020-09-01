package BT1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.attribute.standard.Severity;

public class serverbt1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket listener = null;
	       String line;
	       BufferedReader is;
	       BufferedWriter os;
	       Socket socketOfServer = null;
	       try {
	           listener = new ServerSocket(9999);
	       } catch (IOException e) {
	           System.out.println(e);
	           System.exit(1);
	       }
	 
	       try {
	           System.out.println("Server is waiting to accept user...");
	           socketOfServer = listener.accept();
	           System.out.println("Accept a client!");
	           is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
	           os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
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
	        	   //socketOfServer = listener.accept();
	           }
	 
	       } catch (IOException e) {
	           System.out.println(e);
	           e.printStackTrace();
	       }
	       System.out.println("Sever stopped!");
	 
	 	}
}
