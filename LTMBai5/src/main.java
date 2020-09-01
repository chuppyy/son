
public class main {
	public static void main(String[] args) {
		final Nguyento nguyento = new Nguyento();
		Thread t1= new Thread() {
			public void run() {
				nguyento.Search();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				nguyento.Sum();
			}
		};
		t1.start();
		t2.start();
	}
}
