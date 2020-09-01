package Bai3;

public class binhphuong extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int s=0;
		s=Taosonguye.so*Taosonguye.so;
		System.out.println("Binh phuong: "+Taosonguye.so+": "+s);
	}
	
}
