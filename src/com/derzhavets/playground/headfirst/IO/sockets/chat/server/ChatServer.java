package com.derzhavets.playground.headfirst.IO.sockets.chat.server;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {
	private ServerSocket serverSocket;
	private int portNumber = 4200;
	private static ArrayList<ClientThread> clients;
	
	public ArrayList<ClientThread> getClients() {
		return clients;
	}

	public void go() {
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Server is up and listening port " + portNumber);
			acceptClients();
		} catch (IOException e) {
			System.err.println("Couldn't listen on port " + portNumber);
			System.exit(1);
		}
	}
	
	private void acceptClients() {
		clients = new ArrayList<ClientThread>();
		while (true) {
			try {
				Socket sock = serverSocket.accept();
				ClientThread client = new ClientThread(sock);
				clients.add(client);
				System.out.println(clients.size());
				Thread t = new Thread(client);
				t.start();
				System.out.println("New connection established.");
			} catch (IOException e) {
				System.err.println("Accept failed on port " + portNumber);
			}
		}
	}
	
	public static void main(String[] args) {
		ChatServer app = new ChatServer();
		app.go();
	}
}
