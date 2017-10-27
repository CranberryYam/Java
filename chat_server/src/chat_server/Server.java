package chat_server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import chat_server.DialogThread;

public class Server {
    static ServerSocket serverSocket;
    static int portNumber = 16790; //For the pace server this is the number we must use.
	
	public static void main(String[] args) {
	    serverSocket = null;
	    
	    try {
	      serverSocket = new ServerSocket(portNumber); 
	      acceptClients();
	    }catch (IOException e) {
	        System.out.println("Can't initial new serverSocket because" + e);
	        System.exit(0);
	    }
	}
		
	public static void acceptClients() {
		System.out.println("S: server begins at " + serverSocket.getLocalSocketAddress()+" port");
		ArrayList<DialogThread> dialogs = new ArrayList<DialogThread>();
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println("S: server accept"+clientSocket.getRemoteSocketAddress()+" client socket");	
				DialogThread dialog = new DialogThread(clientSocket,dialogs);
				Thread thread = new Thread(dialog);
				thread.start();
				dialogs.add(dialog);			
			} catch (Exception e) {
				System.out.println("server accept failed because " + e.getMessage());
			}
		}
	}

}
