package Bai4;

public class Luong2 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = Nhapab.a+Nhapab.n; i < Nhapab.b-Nhapab.n; i++) {
            if (Nhapab.isPrimeNumber(i)) {
                System.out.print(" " + i);
            }
        }
	}
//	public static boolean isPrimeNumber(int n) {
//	    if (n < 2) {
//	        return false;
//	    }
//	    // check so nguyen to khi n >= 2
//	    int squareRoot = (int) Math.sqrt(n);
//	    for (int i = 2; i <= squareRoot; i++) {
//	        if (n % i == 0) {
//	            return false;
//	        }
//	    }
//	    return true;
//	}
	
}
