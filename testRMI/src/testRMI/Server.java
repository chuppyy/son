package testRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RMIinterface{

	
	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String Hello(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return "Xin chao "+name;
	}

	@Override
	public int Tong(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int Hieu(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public float Tich(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public float Luythua(int a) throws RemoteException {
		// TODO Auto-generated method stub
		return a*a;
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
