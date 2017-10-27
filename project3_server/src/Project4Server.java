import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Project4Server {

	public static void main(String[] args) {
		int port = 16790;
		String host = "localhost";
		try {
			CalculateSumServerImpl exportedObjt = new CalculateSumServerImpl();
			LocateRegistry.createRegistry(port);
			String registryURL = "rmi://" + host + ":" + port + "/ABC"; 
			Naming.rebind(registryURL, exportedObjt); 
			System.out.println("CalcuateSum Server ready.");
		} catch (RemoteException e) {
			System.out.println("can't create registry");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("can't rebind");
			e.printStackTrace();
		}
		

	}

}

