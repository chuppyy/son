package Bai3;

import java.util.Random;

public class Taosonguye extends Thread {
	public static int so;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(;;)
			{
				Random rd = new Random();
				so = rd.nextInt(20);
				sleep(2000);
			}
		}
		catch(InterruptedException e)
		{
			return;
		}

//		
	}

}
