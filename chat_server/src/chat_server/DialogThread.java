package chat_server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class DialogThread implements Runnable {
	    private Socket socket;
	    private Scanner in;
	    private PrintWriter out;
	    private ArrayList<DialogThread> dialogs;
	    
	    public DialogThread(Socket socket,ArrayList<DialogThread> dialogs) {
			this.socket = socket;
			this.dialogs = dialogs;
		}
		
		@Override
		public void run() {
			System.out.println("client thread is running");

			try {
				out = new PrintWriter(socket.getOutputStream(), true);
			    out.println("you're conncting to the server");
			    in = new Scanner(socket.getInputStream());
			    
			    while (!socket.isClosed()) {
					if(in.hasNextLine()) {
						String newMessage = in.nextLine();
						System.out.println("S: "+newMessage);
						for(DialogThread dialog:dialogs){
							PrintWriter aOut = dialog.out;
							if(aOut != null){
								aOut.write(newMessage+"\r\n");
								aOut.flush();
							}
						}
					}	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
}
