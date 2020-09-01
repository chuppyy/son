package buffktx;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import democnn.Sinhvien;

public class Client {
	public static boolean checkMaP(String MaP) {
		if(MaP.equals("A101")||MaP.equals("A100")||MaP.equals("A102")||MaP.equals("A103")||MaP.equals("A104")) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		try {
			String yc=null;
			RMIinterface myR= (RMIinterface)Naming.lookup("rmi://localhost/server");
			System.out.println("Ban muon dat phong KTX?y/n");
			Scanner sc = new Scanner(System.in);
			yc=sc.nextLine();
			if(yc.equals("y")) {
				System.out.println("----------Danh sach phong KTX:-----------");
				System.out.println(myR.getAll());
				System.out.println("Nhap ten:");
				String name=sc.nextLine();
				System.out.println("Nhap lop:");
				String lop=sc.nextLine();
				System.out.println("Phong muon dat: ");
				String ktx=sc.nextLine();
				while(true) {
					if(checkMaP(ktx)) {
						break;
					}else {
						System.out.println("Ban da nhap sai phong!!. Moi nhap lai:");
						ktx=sc.nextLine();
					}
				}
				System.out.println("Nam sinh:");
				int namsinh=sc.nextInt();
				myR.addKTX(name, namsinh, lop, ktx);
			}
			System.out.println("Cam on ban da dang ky. Chung toi se phan hoi ban som nhat!");
			//System.out.println(myR.getAll());
			
			//			for(Sinhvien sv:ds.getDs()) {
//				String[] row = {sv.getMssv()+"",sv.getHoten(),sv.getNamsinh()+"",sv.getLop(),sv.getKtx()};
//				model.addRow(row);
//			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
