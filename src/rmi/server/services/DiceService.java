package rmi.server.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import rmi.server.*;

public class DiceService implements Service {
	JLabel label;
	JComboBox<String> numOfDice;

	@Override
	public JPanel getGuiPanel() {
		JPanel panel = new JPanel();
		JButton button = new JButton("Roll it");
		String[] choices = {"1", "2", "3", "4", "5"};
		numOfDice = new JComboBox<String>(choices);
		label = new JLabel("Dice value here");
		button.addActionListener(new RollButtonListener());
		
		panel.add(numOfDice);
		panel.add(button);
		panel.add(label);
		return panel;
	}
	
	private class RollButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String diceOutput = "";
			String selection = (String) numOfDice.getSelectedItem();
			int numOfDiceToRoll = Integer.parseInt(selection);
			for (int i = 0; i < numOfDiceToRoll; i++) {
				int r = new Random().nextInt(7);
				diceOutput += (" " + r);
			}
			label.setText(diceOutput);
		}		
	}

}
