package buffktx;

public class KTX {
	public String MaP;
	public String TenP;
	public int Songuoi;
	public String Trangthai;
	public String getMaP() {
		return MaP;
	}
	public void setMaP(String maP) {
		MaP = maP;
	}
	public String getTenP() {
		return TenP;
	}
	public void setTenP(String tenP) {
		TenP = tenP;
	}
	public int getSonguoi() {
		return Songuoi;
	}
	public void setSonguoi(int songuoi) {
		Songuoi = songuoi;
	}
	public String getTrangthai() {
		return Trangthai;
	}
	public void setTrangthai(String trangthai) {
		Trangthai = trangthai;
	}
	public KTX(String maP, String tenP, int songuoi, String trangthai) {
		super();
		MaP = maP;
		TenP = tenP;
		Songuoi = songuoi;
		Trangthai = trangthai;
	}
	@Override
	public String toString() {
		return "KTX [MaP=" + MaP + ", TenP=" + TenP + ", Songuoi=" + Songuoi + ", Trangthai=" + Trangthai + "]";
	}
	
}
