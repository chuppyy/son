/*5.	Viết chương trình cho phép người dùng nhập vào địa chỉ các trang web và
kiểm soát việc truy cập các trang web của người dùng.
Trong đó, khi người dùng truy cập đến 1 trang web có trong danh sách cấm
thì thông báo cho người dùng biết.
Khi người dùng truy cập đến trang web không có trong danh sách cấm 
thì lấy nội dung trang web về hiển thị lên màn hình.
Người dùng có thể nhập địa chỉ IP hoặc Hostname.*/
package BT5;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class bai5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String a[]= {"www.facebook.com","www.youtube.com"};
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap Hostname hoac IP");
		String url = sc.nextLine();
		for (int i=0;i<a.length;i++) {
			InetAddress ip = InetAddress.getByName(url);
			InetAddress ipc = InetAddress.getByName(a[i]);
			if(a[i].equals(url) || ipc.equals(ip)) {
				System.out.println("Ban khong the truy cap trang web cam!!!");
				return;
			}
			else {
				System.out.println("complete!!");
				try {
					String URL = "https://"+url;
					URL u=new URL(URL);
					URLConnection uc = u.openConnection();
					InputStream bis;
					bis=(InputStream)uc.getContent();
					while ((i=bis.read())>0) {
						System.out.print((char)i);
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
	}

}
