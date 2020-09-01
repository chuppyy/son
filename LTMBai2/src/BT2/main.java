package BT2;

public class main {
	public static void main(String[] args) throws InterruptedException {
	Mytheard mt = new Mytheard();
	mt.start();
	synchronized (mt)
	{
		mt.wait();
	}

	Chuvi cv = new Chuvi();
	cv.start();
	DienTich dt = new DienTich();
	dt.start();
	}
}
