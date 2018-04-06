package com.derzhavets.playground.headfirst.UI.swing.twoButtons;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwoButtons {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		TwoButtons tb = new TwoButtons();
		tb.go();
	}
	
	private class ColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
	}
	
	private class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Label is dead");	
		}
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		MyDrawingPanel panel = new MyDrawingPanel();
		label = new JLabel("Initial label");
		JButton colorButton = new JButton("Change color");
		colorButton.addActionListener(new ColorListener());
		JButton labelButton = new JButton("Change label");
		labelButton.addActionListener(new LabelListener());
		
		frame.add(BorderLayout.EAST, label);
		frame.add(BorderLayout.WEST, labelButton);
		frame.add(BorderLayout.SOUTH, colorButton);
		frame.add(BorderLayout.CENTER, panel);
		
		frame.setVisible(true);
	}
}
