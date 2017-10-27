import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;

public class Project4Client {

	private static Scanner sc;

	public static void main(String[] args) {
		try {
			Project4ServerInterface p4 = (Project4ServerInterface)Naming.lookup("rmi://localhost:16790/ABC");
			System.out.println("Lookup completed " );
			System.out.println("Enter a positive number");
			sc = new Scanner(System.in);
			int number = sc.nextInt();
			int result = p4.calculateSum(number);
			System.out.println("The sum is: "+result);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			System.out.println("Lookup failed " );
		}
	}

}

