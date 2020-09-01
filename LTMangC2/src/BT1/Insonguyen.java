package BT1;

import java.util.Scanner;

public class Insonguyen extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Scanner scannner = new Scanner(System.in);
		int n = scannner.nextInt();
		for(int i = 0;i<=n; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	

}
