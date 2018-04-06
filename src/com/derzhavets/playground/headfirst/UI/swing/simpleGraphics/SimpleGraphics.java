package com.derzhavets.playground.headfirst.UI.swing.simpleGraphics;

import javax.swing.JFrame;

public class SimpleGraphics {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		
		MyDrawPanel p = new MyDrawPanel();
		frame.getContentPane().add(p);
		
		frame.setVisible(true);
	}
}
