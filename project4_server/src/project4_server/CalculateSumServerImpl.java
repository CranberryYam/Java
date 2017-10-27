package project4_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculateSumServerImpl extends UnicastRemoteObject implements Project4ServerInterface {

	private static final long serialVersionUID = 1L;

	public CalculateSumServerImpl() throws RemoteException {
		super();
		System.out.println("new Impl() object"); 
	}

	@Override
	public int calculateSum(int n) throws RemoteException {
		int product = 1;
		if(n>0) {
			for(int i=1;i<=n;i++) {
				product = product*i;
			}
		}
		return product;
	}
}

