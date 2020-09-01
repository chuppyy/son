package Start;

import java.util.ArrayList;

public class DanhsachSV {
	private ArrayList<Sinhvien> ds;
	public DanhsachSV() {
		super();
		ds = new ArrayList<Sinhvien>();
	}
	public boolean themSV(Sinhvien sv) {
		if(!ds.contains(sv)) { 
			return ds.add(sv);
		}
		return false;
		//
	}
	public ArrayList<Sinhvien> getDs(){
		return ds;
	}
	public int soSV() {
		return ds.size();
	}
	public boolean XoaSV(int index) {
		if(index>0 && index<ds.size()-1) {
			ds.remove(index);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean SuaSV(long mssv, String hoten, int namsinh, String lop, String ktx) {
		Sinhvien sv= new Sinhvien(mssv,hoten,namsinh,lop,ktx);
		if(ds.contains(sv)) {
			sv.setMssv(mssv);
			sv.setHoten(hoten);
			sv.setNamsinh(namsinh);
			sv.setLop(lop);
			sv.setKtx(ktx);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean Kiemtra(long mssv) {
		Sinhvien sv =  new Sinhvien(mssv);
		if(ds.contains(sv)) {
			return true;
		}
		return false;
	}
}
