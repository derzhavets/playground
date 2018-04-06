package com.derzhavets.playground.headfirst.UI.swing.simpleGraphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(10, 10, 100, 100);
	}
}
