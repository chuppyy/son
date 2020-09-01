package BT2;

public class DienTich extends Thread{
	public static int cd,cr;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		if(Mytheard.cd>0 && Mytheard.cr>0) {
			int S=0;
			S=cd *cr;
			System.out.println("Dien tich HCN la: "+S);
		}
		
	}

}
