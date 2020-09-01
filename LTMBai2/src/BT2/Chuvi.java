package BT2;

public class Chuvi extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		if(Mytheard.cd>0 && Mytheard.cr>0) {
		int D = 0;
		D= (Mytheard.cd +Mytheard.cr)*2;
		System.out.println("Chu vi HCN la: "+D);
		}
	}
	
}
