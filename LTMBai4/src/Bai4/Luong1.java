package Bai4;

import java.util.Scanner;

public class Luong1 extends Thread{
	
	Scanner sc = new Scanner(System.in);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		if (Nhapab.a <= 2) {
            System.out.print(2);
        }
        for (int i = Nhapab.a; i < Nhapab.a+Nhapab.n; i++) {
            if (Nhapab.isPrimeNumber(i)) {
                System.out.print(" " + i);
            }
        }
	}
	
}
