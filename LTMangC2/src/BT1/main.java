package BT1;

public class main {
	public static void main(String[] args) {
		InLe inle = new InLe();
		inle.setName("in so le: ");
		InChan inchan = new InChan();
		inchan.setName("in so chan: ");
		Insonguyen innguyen = new Insonguyen();
		innguyen.setName("in so nguyen: ");
		InHoa inhoa= new InHoa();
		inhoa.setName("in chu hoa: ");
		
		inchan.start();
		inle.start();
		innguyen.start();
		inhoa.start();
	}
}
