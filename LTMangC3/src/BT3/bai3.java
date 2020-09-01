/*3.	Viết chương trình sử dụng các phương thức getLocalHost(), getByName() 
của đối tượng InetAddress để in ra địa chỉ của localhost, địa chỉ URL của một website.*/


package BT3;
import java.net.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class bai3 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		System.out.println("Nhap url: ");
		Scanner sc = new Scanner(System.in);
		String url = sc.nextLine();
			InetAddress ip ;
			ip = InetAddress.getByName(url);
			System.out.println("Host name: "+ ip.getHostName());
			System.out.println("ip address: "+ ip.getHostAddress());
		
	}

}
