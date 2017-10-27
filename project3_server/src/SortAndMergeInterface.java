import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SortAndMergeInterface extends Remote {
	public int[] sort(int[] x) throws RemoteException;
	public int[] merge(int[] a, int[] b) throws RemoteException;
}
