import java.rmi.Remote;

public interface Project4ServerInterface extends Remote {
    public int calculateSum(int n ) throws java.rmi.RemoteException;
}

