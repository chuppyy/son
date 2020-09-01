package BT2;

import java.util.Scanner;

public class Mytheard extends Thread{
	public static int cd,cr;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Nhap cd:");
		Scanner scanner= new Scanner(System.in);
		cd= scanner.nextInt();
		DienTich.cd=cd;
		System.out.println("Nhap cd:");
		//Scanner scanner= new Scanner(System.in);
		cr= scanner.nextInt();
		DienTich.cr=cr;
	}
}
