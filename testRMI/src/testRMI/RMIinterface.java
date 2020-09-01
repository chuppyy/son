package testRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIinterface extends Remote{
	
	public String Hello(String name) throws RemoteException;
	public int Tong(int a, int b) throws RemoteException;
	public int Hieu(int a, int b) throws RemoteException;
	public float Tich(int a,int b) throws RemoteException;
	public float Luythua(int a) throws RemoteException;
}

