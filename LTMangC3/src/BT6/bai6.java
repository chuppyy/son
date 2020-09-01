/*6.	Viết chương trình cho phép người dùng nhập vào các địa chỉ URL và lưu lại các thông tin
(Hostname, địa chỉ IP) của các trang web mà người dùng đã truy cập (không trùng lặp thông tin)*/
package BT6;

import java.io.ObjectInputStream.GetField;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bai6 {
	private static void resultList(List l) {
		for(int i=0;i<l.size()-1;i++) {
			for(int j=i+1;j<l.size();j++) {
				if((l.get(i)).equals(l.get(j))) {
					l.remove(j);
					j--;
				}
			}
		}
	}
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		List<String> listHost = new ArrayList<String>();
		List<String> listIP = new ArrayList<String>();
		String url;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap URL. Nhap 'DUNG' de ket thuc:");
		url=sc.nextLine();
		while (!("DUNG".equals(url))) {
			
			try {
				URL u = new URL(url);
				String host = u.getHost();
				InetAddress ip = InetAddress.getByName(host);
				listHost.add(ip.getHostName());
				listIP.add(ip.getHostAddress());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url=sc.nextLine();
		}
		resultList(listIP);
		resultList(listHost);
		for (String s : listHost) {
			System.out.println("list Host:"+s+" ");
		}
		for (String s : listIP) {
			System.out.println("list IP:"+s+" ");
		}
		
	}

}
