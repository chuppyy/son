package democnn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Database {
	public Database() {
		super();
	}
	public DanhsachSV readSV() throws Exception {
		DanhsachSV ds = new DanhsachSV();
		PreparedStatement ps=DBconnection.getJDBCConnection().prepareStatement("select * from dbo.SinhVien");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Sinhvien sv= new Sinhvien(rs.getLong("MaSV"),rs.getString("Ten"),rs.getInt("Namsinh"),rs.getString("Lop"),rs.getString("MaP"));
			
			ds.themSV(sv);
		}
		return ds;
	}
	
}