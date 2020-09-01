package BT1;
import java.net.*;
import java.util.Scanner;

public class bai1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Nhap URL: ");
			Scanner sc = new Scanner(System.in);
			String url;
			url=sc.nextLine();
			URL u = new URL(url);
			System.out.println("URL: "+u);
			System.out.println("Ten file la: " + u.getFile());
			System.out.println("Ten host la: " +u.getHost());
			System.out.println("So hieu cong: "+ u.getPort());
			System.out.println("Kieu giao thuc: " + u.getProtocol());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
