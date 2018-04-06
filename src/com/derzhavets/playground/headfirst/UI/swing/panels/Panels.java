package com.derzhavets.playground.headfirst.UI.swing.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Panels {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		JButton button1 = new JButton("Click me");
		JButton button2 = new JButton("Don' click me");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(button1);
		panel.add(button2);
		
		frame.add(BorderLayout.NORTH, panel);
		
		frame.setVisible(true);
	}
}
