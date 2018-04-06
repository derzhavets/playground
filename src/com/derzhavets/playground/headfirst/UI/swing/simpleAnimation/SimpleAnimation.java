package com.derzhavets.playground.headfirst.UI.swing.simpleAnimation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class SimpleAnimation {
	private int x;
	private int y;
	
	public static void main(String[] args) {
		SimpleAnimation sa = new SimpleAnimation();
		sa.go();
	}
	
	private class DrawingPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval(x, y, 30, 30);
		}
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		DrawingPanel panel = new DrawingPanel();
		
		frame.add(panel);
		frame.setVisible(true);
		
		for (int i = 0; i < 300; i++) {
			x++;
			y++;
			frame.repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
