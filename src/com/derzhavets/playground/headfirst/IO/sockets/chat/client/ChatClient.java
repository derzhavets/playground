package com.derzhavets.playground.headfirst.IO.sockets.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

import javax.swing.*;

public class ChatClient {
	private Socket socket = null;
	private int portNumber = 4200;
	private JTextArea incoming;
	private JTextField outgoing;
	private Scanner in;
	private PrintWriter writer;
	
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.go();
	}
	
	public void go() {
		buildUI();
		setUpNetworkingAndStart();
	}
	
	private void buildUI() {
		JFrame frame = new JFrame("Simplest Ever Chat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		incoming = new JTextArea(15,40);
		JScrollPane scroller = new JScrollPane(incoming);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		
		panel.add(incoming);
		panel.add(outgoing);
		panel.add(sendButton);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	private void setUpNetworkingAndStart() {
		try {
			socket = new Socket("127.0.0.1", portNumber);
			writer = new PrintWriter(socket.getOutputStream());
			in = new Scanner(socket.getInputStream());
			Thread t = new Thread(new AcceptServerMessages());
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private class AcceptServerMessages implements Runnable {
		@Override
		public void run() {
			while (!socket.isClosed()) {
				if (in.hasNext()) {
					incoming.append(in.nextLine() + "\n");
				}
			}
		}
	}
	
	private class SendButtonListener implements ActionListener {		
		@Override
		public void actionPerformed(ActionEvent e) {
			writer.println(outgoing.getText());
			writer.flush();
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
}
