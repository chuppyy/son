package Bai2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server1 extends UnicastRemoteObject implements RMIinterface1{

	protected Server1() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int Dodai(String x) throws RemoteException {
		return x.length();
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public String Inhoa(String x) throws RemoteException {
		// TODO Auto-generated method stub
		x.split(" ");
		return x.toUpperCase();
	}

	@Override
	public String Congchuoi(String a, String b) throws RemoteException {
		// TODO Auto-generated method stub
		a.split(" ");
		b.split(" ");
		return a+b;
	}
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("Server hoat dong");
			Naming.rebind("rmi://localhost/server1", new Server1());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
