package democnn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DanhsachSV {
	private ArrayList<Sinhvien> ds;
	public DanhsachSV() {
		super();
		ds = new ArrayList<Sinhvien>();
	}
	public static void addSV(Sinhvien sv) {
		String sql = "insert into SinhVien (Ten,Namsinh,Lop,MaP ) values (?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = DBconnection.getJDBCConnection().prepareStatement(sql);
			ps.setString(1, sv.getHoten());
			ps.setInt(2, sv.getNamsinh());
			ps.setString(3, sv.getLop());
			ps.setString(4, sv.getKtx());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteSV(String ms) {
		String sql = "delete from Sinhvien where MaSV='"+ms+"'";
		try {
			PreparedStatement ps=DBconnection.getJDBCConnection().prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void editSV(Sinhvien sv) {
		System.out.println("Tostring : "+sv.toString());
		try {
				String sql = "update Sinhvien set Ten=?, Namsinh=?, Lop=?,MaP=? where MaSV=?";
				PreparedStatement ps=DBconnection.getJDBCConnection().prepareStatement(sql);
				ps.setString(1, sv.getHoten());
				ps.setInt(2, sv.getNamsinh());
				ps.setString(3, sv.getLop());
				ps.setString(4, sv.getKtx());
				ps.setLong(5, sv.getMssv());
				ps.executeUpdate();
				ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean themSV(Sinhvien sv) {
		
		if(!ds.contains(sv)) {
			return ds.add(sv);
		}else {
//			try {
//				String sql = "insert into SinhVien (Ten,Namsinh,Lop,MaP ) values (?,?,?,?)";
//				PreparedStatement ps=DBconnection.getJDBCConnection().prepareStatement(sql);
//				ps.setString(1, sv.getHoten());
//				ps.setInt(2, sv.getNamsinh());
//				ps.setString(3, sv.getLop());
//				ps.setString(4, sv.getKtx());
//				ps.executeUpdate();
//				System.out.println("Tostring : "+sv.toString());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return false;
		//
	}
	public Sinhvien findSV(long mssv) throws SQLException {
		Sinhvien sv=new Sinhvien();
		DanhsachSV ds = new DanhsachSV();
		PreparedStatement ps=DBconnection.getJDBCConnection().prepareStatement("select * from dbo.SinhVien where MaSV=?");
		ps.setLong(1, mssv);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			sv.setMssv(rs.getLong("MaSV"));
			sv.setHoten(rs.getString("Ten"));
			sv.setNamsinh(rs.getInt("Namsinh"));
			sv.setLop(rs.getString("Lop"));
			sv.setKtx(rs.getString("MaP"));
			
		}
		return sv;
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
		for (Sinhvien sinhvien : ds) {
			if(sinhvien.getMssv()==mssv) {
				return true;
			}
		}
		return false;
	}
}