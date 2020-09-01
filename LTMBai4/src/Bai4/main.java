package Bai4;

public class main{
	public static void main(String[] args) throws InterruptedException {
		Nhapab ab =new Nhapab();
		ab.start();
		synchronized (ab)
		{
			ab.wait();
		}
		Luong1 l1 = new Luong1();
		Luong2 l2= new Luong2();
		Luong3 l3 = new Luong3();
		l3.start();
		l2.start();
		l1.start();
		
		
		
	}
}		
//		if (Nhapab.a <= 2 && Nhapab.a<=Nhapab.b) {
//            System.out.print(2);
//        }
//        for (int i = Nhapab.a; i < Nhapab.b; i+=2) {
//            if (isPrimeNumber(i)) {
//                System.out.print(" " + i);
//            }
//        }
//
//	}
//
//public static boolean isPrimeNumber(int n) {
//    if (n < 2) {
//        return false;
//    }
//    // check so nguyen to khi n >= 2
//    int squareRoot = (int) Math.sqrt(n);
//    for (int i = Nhapab.a; i <= squareRoot; i++) {
//        if (n % i == 0) {
//            return false;
//        }
//    }
//    return true;
//}
//}
