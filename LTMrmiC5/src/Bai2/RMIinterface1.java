package Bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIinterface1 extends Remote{
	public int Dodai(String x) throws RemoteException;
	public String Inhoa(String x) throws RemoteException;
	public String Congchuoi(String a, String b) throws RemoteException;
}
