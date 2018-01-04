package sockets.chat.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientThread extends ChatServer implements Runnable {
	private Socket sock;
	PrintWriter out;
	Scanner in;
	
	public ClientThread(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		try {
			out = new PrintWriter(sock.getOutputStream());
			in = new Scanner(sock.getInputStream());
			
			while(!sock.isClosed()) {
				
				if(in.hasNextLine()) {
					String input = in.nextLine();				
					for (ClientThread client: super.getClients()) {
						PrintWriter writer = client.getWriter();
						writer.println(input);
						writer.flush();
					}					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PrintWriter getWriter() {
		return out;
	}
}
