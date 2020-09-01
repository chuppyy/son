package democnn;


public class Sinhvien {
	private long mssv;
	private String hoten;
	private int namsinh;
	private String lop;
	private String ktx;
	public long getMssv() {
		return mssv;
	}
	public void setMssv(long mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getKtx() {
		return ktx;
	}
	public void setKtx(String ktx) {
		this.ktx = ktx;
	}
	public Sinhvien(long mssv, String hoten, int namsinh, String lop, String ktx) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.lop = lop;
		this.ktx = ktx;
	}
	
	public Sinhvien(long mssv) {
		super();
		this.mssv = mssv;
	}
	public Sinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sinhvien [mssv=" + mssv + ", hoten=" + hoten + ", namsinh=" + namsinh + ", lop=" + lop + ", ktx=" + ktx
				+ "]";
	}
	
}
