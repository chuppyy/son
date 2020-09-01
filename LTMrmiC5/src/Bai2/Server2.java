package Bai2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server2  extends UnicastRemoteObject implements RMIinterface2{

	protected Server2() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

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
	public float DientichHCN(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return (a+b)*2;
	}
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1098);
			System.out.println("server 2 is start");
			Naming.rebind("rmi://localhost/server2", new Server2());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
