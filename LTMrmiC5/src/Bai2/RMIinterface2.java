package Bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIinterface2 extends Remote{
	public int Tong(int a, int b) throws RemoteException;
	public int Hieu(int a,int b) throws RemoteException;
	public float DientichHCN(int a,int b) throws RemoteException; 
}
