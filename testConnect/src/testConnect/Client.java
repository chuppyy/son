package testConnect;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    private InetAddress host;
    private int port;

    public Client(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    private void execute() throws IOException {
        DatagramSocket client=new DatagramSocket();
    	Scanner sc= new Scanner(System.in);
    	
        System.out.println("Nhập tên của bạn :");
        String name= sc.nextLine();
        
        client.send(CreatePacket(name+" đã tham gia vào phòng chat"));
        
        ReadClient readClient=new ReadClient(client);
        readClient.start();
        WriteClient writeClient = new WriteClient(client,host,port,name);
        writeClient.start();
    }

    public static void main(String[] args) throws IOException {
        Client client=new Client(InetAddress.getLocalHost(),1733);
        client.execute();
    }
    private DatagramPacket CreatePacket (String value){
        byte [] arrData= value.getBytes();
        return new DatagramPacket(arrData,arrData.length,host,port);
    }

}

class ReadClient extends Thread{
    private DatagramSocket client;

    public ReadClient(DatagramSocket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
        	while(true) {
        		String sms= ReceiveData(client);
                System.out.println(sms);
        	}
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String ReceiveData(DatagramSocket client) throws IOException {
        byte[] temp=new byte[1024];
        DatagramPacket receive_Packet= new DatagramPacket(temp,temp.length);
        client.receive(receive_Packet);
        return new String(receive_Packet.getData()).trim();
    }
}


class WriteClient extends Thread{
    private DatagramSocket client;
    private InetAddress host;
    private int port;
    private String name;

    public WriteClient(DatagramSocket socket, InetAddress host, int port,String name) {
        this.client = socket;
        this.host = host;
        this.port = port;
        this.name=name;
    }

    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                String sms=sc.nextLine();
                DatagramPacket datagramPacket=CreatePacket(name+":"+sms);
                client.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private DatagramPacket CreatePacket (String value){
        byte [] arrData= value.getBytes();
        return new DatagramPacket(arrData,arrData.length,host,port);
    }
}
