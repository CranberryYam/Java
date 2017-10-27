import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class SortAndMergeServer {
	public static void main(String[] args) {
		int port = 16790;
		String host = "localhost";
		try {
			SortAndMergeImpl exportedObjt = new SortAndMergeImpl();
			LocateRegistry.createRegistry(port);
			String registryURL = "rmi://" + host + ":" + port + "/ABC"; 
			Naming.rebind(registryURL, exportedObjt); 
			System.out.println("MergeAndSort Server ready.");
		} catch (RemoteException e) {
			System.out.println("can't create registry");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("can't rebind");
			e.printStackTrace();
		}
		

	}
}
