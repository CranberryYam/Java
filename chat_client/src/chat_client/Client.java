package chat_client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Client {
	private static final String host = "localhost";
	private static final int portNumber = 16790;
	
	private String userName;
	private String serverHost;
	private int serverPort;
	
  public static void main(String[] args){
	  Scanner scan = new Scanner(System.in);
      System.out.println("Please input username:");
      String user = scan.nextLine();
	  Client client = new Client(user, host, portNumber);
	  client.begin(); 
  }
  
  public Client(String userName, String serverHost, int serverPort) {
	  this.userName = userName;
	  this.serverHost = serverHost;
	  this.serverPort = serverPort;
  }
  private void begin() {
	   try {
		Socket clientSocket = new Socket(serverHost, serverPort);
		Thread gThread = new Thread(new GetMsgThread(clientSocket));
		gThread.start();
		Thread sThread = new Thread(new SendMsgThread(clientSocket, userName));
		sThread.start();
	} catch (IOException e) {
		System.out.println("clientSocket begin failed because " + e.getMessage());
	}	
  }
  
  
  
}

