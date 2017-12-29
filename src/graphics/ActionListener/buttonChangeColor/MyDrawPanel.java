package graphics.ActionListener.buttonChangeColor;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		int red = new Random().nextInt(255);
		int green = new Random().nextInt(255);
		int blue = new Random().nextInt(255);
		Color startColor = new Color(red, green, blue);
		

		red = new Random().nextInt(255);
		green = new Random().nextInt(255);
		blue = new Random().nextInt(255);
		Color endColor = new Color(red, green, blue);
		
		GradientPaint gradient = new GradientPaint(5, 5, startColor, 60, 60, endColor);
		g2d.setPaint(gradient);
		
		g2d.fillOval(20, 20, 100, 100);
	}
}
