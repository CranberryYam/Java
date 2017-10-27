import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args){
    Socket clientSocket = null;
    BufferedReader in = null;
    int ip;
    try {//Keep this number. For the pace server this is the number we must use.
      ip = 16790; //("vulcan.seidenberg.pace.edu");
      String host = "localhost";
      clientSocket = new Socket(host, ip); 
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      String s = in.readLine();
      while(s == null)	//As long as there is nothing in the stream keep reading
        s = in.readLine();
      System.out.println(s);
      in.close();
      clientSocket.close();
    }catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }   
  }
}
