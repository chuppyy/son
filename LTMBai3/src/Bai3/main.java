package Bai3;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		int n;
		System.out.println("Nhap so lan lap: ");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		for(int i = 0;i<=n;i++) {
			Taosonguye tao = new Taosonguye();
			tao.start();
			binhphuong bp= new binhphuong();
			bp.start();
		}
	}
}
