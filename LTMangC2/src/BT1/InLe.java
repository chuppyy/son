package BT1;

import java.util.Scanner;

public class InLe extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i=0;i<n;i++) {
			if(i%2 != 0) {
				System.out.println(Thread.currentThread().getName()+" "+ i);
			}
		}
		}
}
