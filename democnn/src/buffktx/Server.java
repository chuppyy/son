package buffktx;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.List;
import java.net.MalformedURLException;

public class Server extends UnicastRemoteObject implements RMIinterface{

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Sinhvien addKTX(String ten, int namsinh, String lop, String ktx) throws RemoteException {
		try {
			PreparedStatement ps = DBconnection.getJDBCConnection().prepareStatement("insert into dbo.SinhVien (  Ten, Namsinh, Lop, MaP ) values (?,?,?,?)");
			ps.setString(1, ten);
			ps.setInt(2, namsinh);
			ps.setString(3, lop);
			ps.setString(4, ktx);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getAll() throws RemoteException{
		ArrayList<KTX> listKTX= new ArrayList<KTX>();
		String result = "";
		try {
			PreparedStatement ps = DBconnection.getJDBCConnection().prepareStatement("select * from dbo.KTX");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				KTX kt=new KTX(rs.getString("MaP"), rs.getString("TenP"), rs.getInt("SoNguoi"), rs.getString("TrangThai"));
				listKTX.add(kt);
			}
			for(KTX ktx:listKTX) {
				result=(result+"     ").concat(ktx.MaP);
			}
			//return listKTX;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		try {
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost/server", new Server());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
