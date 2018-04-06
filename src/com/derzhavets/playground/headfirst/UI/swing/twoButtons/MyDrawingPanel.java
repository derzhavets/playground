package com.derzhavets.playground.headfirst.UI.swing.twoButtons;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MyDrawingPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		int red = new Random().nextInt(255);
		int green = new Random().nextInt(255);
		int blue = new Random().nextInt(255);
		Color color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(50, 50, 50, 50);
		
	}
}
