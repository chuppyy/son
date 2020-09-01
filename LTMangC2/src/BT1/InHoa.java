package BT1;

public class InHoa extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int i = 65;
		while(i<=90) {
			System.out.println(Thread.currentThread().getName()+ " "+(char)i);
			i++;
		}
	}
	

}
