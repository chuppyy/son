package BT2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class sever {
	public void service() {
		try {
			System.out.println("Server started"); 
			System.out.println("Waiting for a client ..."); 
			ServerSocket server = new ServerSocket(10);
			Socket socket=  server.accept();
			System.out.println("Client accepted\n");
			
			// Get data from client
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
			String request = br.readLine();
			if(request!=null) {
				System.out.println("Received from a client:" + request);
				//Calculations
				PrintStream ps = new PrintStream(socket.getOutputStream());
				String response = String.valueOf(Caculations(request));
				
				//Response to client
				ps.println("Result = "+ response);
			}
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double Caculations(String line) {
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
	public static void main(String[] args) {
		sever server = new sever();
		server.service();
	}
}