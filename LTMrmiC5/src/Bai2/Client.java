package Bai2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		String a,b;
		int x,y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap server cần kết nối:  ");
		String server= sc.next();
		while (server.equals("server1")||server.equals("server2")) {
			if(server.equals("server1")) {
				try {
					RMIinterface1 myR = (RMIinterface1) Naming.lookup("rmi://localhost/server1");
					System.out.println("Moi nhap Lua Chon!!");
					System.out.println("1. Xem do dai chuoi nhap vao");
					System.out.println("2. In hoa chuoi");
					System.out.println("3. Cong 2 chuoi");
					int luachon=sc.nextInt();
					sc.nextLine();
					switch(luachon) {
						case 1:{
							System.out.println("Nhap chuoi: ");
							a=sc.nextLine();
							System.out.println("Do dai chuoi la: "+ myR.Dodai(a));
							break;
						}
						case 2:{
							System.out.println("Nhap chuoi: ");
							a=sc.nextLine();
							System.out.println("Chuoi sau khi in hoa la: "+ myR.Inhoa(a));
							break;
						}
						case 3:{
							System.out.println("Nhap chuoi a: ");
							a=sc.nextLine();
							System.out.println("Nhap chuoi b: ");
							b=sc.nextLine();
							System.out.println("a+b = " + myR.Congchuoi(a, b));
							break;
						}
					}
					
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(server.equals("server2")) {
				try {
					RMIinterface2 myR2 = (RMIinterface2) Naming.lookup("rmi://localhost/server2");
					System.out.println("Moi nhap Lua Chon!!");
					System.out.println("1. Tong 2 so");
					System.out.println("2. Hieu 2 so");
					System.out.println("3. Dien tich HCN");
					int luachon = sc.nextInt();
					switch(luachon) {
						case 1:{
							System.out.println("Nhap x: ");
							x=sc.nextInt();
							System.out.println("Nhap y: ");
							y=sc.nextInt();
							System.out.println("x+y="+myR2.Tong(x, y));
							break;
						}
						case 2:{
							System.out.println("Nhap x: ");
							x=sc.nextInt();
							System.out.println("Nhap y: ");
							y=sc.nextInt();
							System.out.println("x-y="+myR2.Hieu(x, y));
							break;
						}
						case 3:{
							System.out.println("Nhap cd: ");
							x=sc.nextInt();
							System.out.println("Nhap cr: ");
							y=sc.nextInt();
							System.out.println("Dien tich HCN la"+myR2.DientichHCN(x, y));
							break;
						}
					}
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Nhap server cần kết nối:  ");
			server= sc.next();
		}
		System.out.println("Ket thuc ct:");
		
	}
}
