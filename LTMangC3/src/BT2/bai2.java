package BT2;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;
public class bai2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap URL");
		String url = sc.nextLine();
		try {
			URL u = new URL(url);
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
	}

}
