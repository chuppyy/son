package Start;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Database {
	public Database() {
		super();
	}
	public DanhsachSV readSV(String part) throws Exception {
		DanhsachSV ds = new DanhsachSV();
		File f = new File(part);
		if(f.exists()) {
			Scanner s= new Scanner(f);
			while(s.hasNextLine()) {
				String line= s.nextLine();
				String[] data= line.split(",");
				Sinhvien sv=new Sinhvien(Long.parseLong(data[0]), data[1], Integer.parseInt(data[2]), data[3], data[4]);
				ds.themSV(sv);
			}
			s.close();
		}
		else {
			f.createNewFile();
		}
		return ds;
	}
	public void writeSV(String part,DanhsachSV ds) throws Exception{
		try(PrintWriter out= new PrintWriter(new FileOutputStream(part),true)){
			for(Sinhvien sv:ds.getDs()) {
				String data = sv.getMssv()+","+sv.getHoten()+","+sv.getNamsinh()+","+sv.getLop()+","+sv.getKtx();
				out.println(data);
			}
		}
	}
}
