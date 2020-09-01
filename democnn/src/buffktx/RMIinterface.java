package buffktx;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIinterface extends Remote{
	public Sinhvien addKTX(String ten, int namsinh, String lop, String ktx) throws RemoteException;
	public String getAll() throws RemoteException;
}
