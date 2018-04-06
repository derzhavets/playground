package com.derzhavets.playground.headfirst.IO.sockets.adviceApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import javax.swing.*;

public class AdviceClient {
	JTextArea display;
	
	public static void main(String[] args) {
		AdviceClient sc = new AdviceClient();
		sc.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("Daily Advices");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		display = new JTextArea(6,20);
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(false);
		
		JButton button = new JButton("Get advice");
		button.addActionListener(new buttonListener());
		
		panel.add(display);
		panel.add(button);
		frame.add(panel);
		
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
	
	private class buttonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Socket sock = new Socket("127.0.0.1", 4000);
				InputStreamReader input = new InputStreamReader(sock.getInputStream());
				BufferedReader reader = new BufferedReader(input);
				display.setText(reader.readLine());
				sock.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
