package testConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {
    public static Map<DatagramPacket, Integer> listSK;
    private int port;
    private InetAddress clientIP;
    private int clientPort;

    public Server(int port) {
        this.port = port;
    }


    private void execute() throws IOException {
        DatagramSocket server = new DatagramSocket(port);
        WriteServer writeServer = new WriteServer(server);
        writeServer.start();
       kickClient kick=new kickClient();
       kick.start();
        System.out.println("Server is Listening....");
        while (true) {
            String sms = ReceiveData(server);
            for (DatagramPacket item : listSK.keySet()) {
            	if(!(item.getAddress().equals(clientIP))&&item.getPort()==clientPort) {
            		SendData(sms, item.getAddress(), item.getPort(), server);	
            	}
            }
            System.out.println(sms);
        }
    }


    public static void main(String[] args) throws IOException {
        Server.listSK = new HashMap<DatagramPacket, Integer>();
        Server server = new Server(1733);
        server.execute();
    }

    private String ReceiveData(DatagramSocket server) throws IOException {
        byte[] arrData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(arrData, arrData.length);
        server.receive(receivePacket);
        clientIP = receivePacket.getAddress();
        clientPort = receivePacket.getPort();
        CheckDuplicate(receivePacket);
        return new String(receivePacket.getData()).trim();
    }

    private void CheckDuplicate(DatagramPacket packet) {
        for (DatagramPacket item : listSK.keySet()) {
            if (item.getAddress().equals(packet.getAddress()) && item.getPort() == packet.getPort()) { 
            listSK.replace(item, 0);
            return;// tìm thấy thoat ra ngay
            }
        }
        listSK.put(packet, 0);
    }

    private void SendData(String value, InetAddress host, int port, DatagramSocket server) throws IOException {
        byte[] temp = new byte[1024];
        temp = value.getBytes();
        DatagramPacket sentPacket = new DatagramPacket(temp, temp.length, host, port);
        server.send(sentPacket);
    }
}

class WriteServer extends Thread {
    private DatagramSocket server;

    public WriteServer(DatagramSocket server) {
        this.server = server;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String sms = sc.nextLine();
            try {
                for (DatagramPacket item : Server.listSK.keySet()) {
                    SendData("server:"+sms, item.getAddress(), item.getPort(), server);
                }
            } catch (Exception e) {
            }
        }
    }

    private void SendData(String value, InetAddress host, int port, DatagramSocket server) throws IOException {
        byte[] temp = new byte[1024];
        temp = value.getBytes();
        DatagramPacket sentPacket = new DatagramPacket(temp, temp.length, host, port);
        server.send(sentPacket);
    }
}    
class kickClient extends Thread {
	@Override
	public void run() {
		while(true) {
			for(Map.Entry<DatagramPacket, Integer> item: Server.listSK.entrySet()) {
				int timeExist=item.getValue();
				if (timeExist>15) {
					Server.listSK.remove(item.getKey());
					System.out.println("đã ngắt kết nối với " +item.getKey());
				}
				else {
					Server.listSK.replace(item.getKey(), timeExist+1);
				}
			}
		 try {
			 Thread.sleep(1000);
		} catch (Exception e) {
			//to do something
		}
		}
	}
}
