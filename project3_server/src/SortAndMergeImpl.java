import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SortAndMergeImpl extends UnicastRemoteObject implements SortAndMergeInterface {

	protected SortAndMergeImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int[] sort(int[] x) throws RemoteException {
	    for(int i = 0; i < x.length ; i++){
	      int indexOfSmallest = findIndexOfSmallest(x, i);
	      int t = x[i];
	      x[i] = x[indexOfSmallest];
	      x[indexOfSmallest] = t;
	    }
	    return x;
	}

	@Override
	public int[] merge(int[] a, int[] b) throws RemoteException {
	    int aIndex = 0, bIndex = 0, cIndex = 0;
	    int[] c = new int[a.length + b.length];
	    while(aIndex < a.length && bIndex < b.length)
	      if(a[aIndex] < b[bIndex])
	        c[cIndex++] = a[aIndex++];
	      else
	        c[cIndex++] = b[bIndex++];

	    while(aIndex < a.length)
	      c[cIndex++] = a[aIndex++];
	    
	    while(bIndex < b.length)
	      c[cIndex++] = b[bIndex++];
	    return c;
	}

	  private static int findIndexOfSmallest(int[] a, int from){
		    int indexOfSmallest = from;

		    for(int i = from; i < a.length; i++)
		      if(a[i] < a[indexOfSmallest])
		        indexOfSmallest = i;
		    return indexOfSmallest;
		  }
}
