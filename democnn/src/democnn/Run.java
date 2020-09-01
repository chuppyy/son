package democnn;

import javax.swing.JFrame;

public class Run {
	public static void main(String[] args){
		Giaodien giaodien= new Giaodien();
		giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giaodien.setSize(700, 600);
		giaodien.setVisible(true);
	}
}
