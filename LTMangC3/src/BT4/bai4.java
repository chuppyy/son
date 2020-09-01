package BT4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.Scanner;

public class bai4 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		System.out.println("Nhap url:");
		Scanner sc = new Scanner(System.in);
		String url = sc.nextLine();
		URL u = new URL(url);
		try {
			URLConnection uc = u.openConnection();
			Date docSent = new Date(uc.getDate());
			Date docLastModified = new Date(uc.getLastModified());
			Date docExpiration = new Date(uc.getExpiration());
			System.out.println("Ngay tao tai lieu: "+docSent);
			System.out.println("Ngay sua doi lan cuoi: "+ docLastModified);
			System.out.println("Ngay het han: "+docExpiration);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
