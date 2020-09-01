import java.util.ArrayList;
public class Nguyento {
	private int index=0;
	private int n=1000;
	private int sum=0; 
	ArrayList<Integer> Arr= new ArrayList<Integer>();
	public Nguyento() {
		
	};
	public synchronized void Search() {
		System.out.println("Tim so nguyen to tu 1 den 1000 : ");
		for(index=0; index<=n; index++) {
			for(int j=2; j<index; j++) {
				if(index%j==0) {
					break;
				}
				if(j==index-1) {
					Arr.add(index);
					System.out.println(index);
				}
			}
		}
		notify();
	}
	public synchronized void Sum() {
		if(index<n) {
			try {
				System.out.println("Waiting for Search");
				wait();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		for(int i=0; i<Arr.size(); i++) {
			sum+=Arr.get(i);
		}
		System.out.println("Tong cac so nguyen to tu 1 den 1000: "+ sum);
	}

}
