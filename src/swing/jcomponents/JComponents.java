package swing.jcomponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JComponents {
	JTextField field;
	JLabel label;
	
	public static void main(String[] args) {
		JComponents jc = new JComponents();
		jc.go();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(field.getText());	
		}
	}
	
	private void go() {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		label = new JLabel("Enter your name");
		field = new JTextField(20);
		JButton button = new JButton("Show name");
		button.addActionListener(new ButtonListener());
		
		panel.add(label);
		panel.add(field);
		panel.add(button);
		
		frame.add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}

}
