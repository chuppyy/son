package testRMI;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			int a,b;
			String ten;
			RMIinterface myR =(RMIinterface)Naming.lookup("rmi://localhost/server");
			System.out.println("Moi nhap Lua Chon!!");
			System.out.println("1. Hello");
			System.out.println("2. Tinh Tong");
			System.out.println("3. Tinh Hieu");
			System.out.println("4. Tinh Tich");
			System.out.println("5. Tinh Luy Thua");
			Scanner sc = new Scanner(System.in);
			int luachon;
			luachon=sc.nextInt();
			while(luachon>=1&&luachon<=5) {
			switch (luachon) {
				case 1:{
					System.out.println("Nhap Ten cua ban");
					ten=sc.next();
					System.out.println(myR.Hello(ten));
					break;
				}
				case 2:{
					System.out.println("Nhap a: ");
					a=sc.nextInt();
					System.out.println("Nhap b: ");
					b=sc.nextInt();
					System.out.println("Tong a,b la: "+ myR.Tong(a, b));
					break;
				}
				case 3:{
					System.out.println("Nhap a: ");
					a=sc.nextInt();
					System.out.println("Nhap b: ");
					b=sc.nextInt();
					System.out.println("Hieu a,b la: "+ myR.Hieu(a, b));
					break;
				}
				case 4:{
					System.out.println("Nhap a: ");
					a=sc.nextInt();
					System.out.println("Nhap b: ");
					b=sc.nextInt();
					System.out.println("Tich a,b la: "+ myR.Tich(a, b));
					break;
				}
				case 5:{
					System.out.println("Nhap a: ");
					a=sc.nextInt();
					
					System.out.println("Luy Thua a la: "+ myR.Luythua(a));
					break;
				}
				default:{
					System.out.println("Sai lua chon!!!");
					break;
				}
			}
			System.out.println("Moi nhap Lua Chon!!");
			System.out.println("1. Hello");
			System.out.println("2. Tinh Tong");
			System.out.println("3. Tinh Hieu");
			System.out.println("4. Tinh Tich");
			System.out.println("5. Tinh Luy Thua");
		
			luachon=sc.nextInt();
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

