package com.derzhavets.playground.headfirst.rmi.server.services;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import com.derzhavets.playground.headfirst.rmi.server.Service;

public class DayOfTheWeekService implements Service {
	JLabel outputLabel;
	JComboBox month;
	JTextField day;
	JTextField year;
	
	@Override
	public JPanel getGuiPanel() {
		JPanel panel = new JPanel();
		JButton button = new JButton("Check it");
		button.addActionListener(new CheckButtonListener());
		outputLabel = new JLabel("Date appears here");
		DateFormatSymbols dateStuff = new DateFormatSymbols();
		month = new JComboBox<String>(dateStuff.getMonths());
		day = new JTextField(8);
		year = new JTextField(8);
		JPanel inputPanel = new JPanel(new GridLayout(3, 2));
		inputPanel.add(new JLabel("Month"));
		inputPanel.add(month);
		inputPanel.add(new JLabel("Day"));
		inputPanel.add(day);
		inputPanel.add(new JLabel("Year"));
		inputPanel.add(year);
		
		panel.add(inputPanel);
		panel.add(button);
		panel.add(outputLabel);
		
		return panel;
	}
	
	private class CheckButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int monthNum = month.getSelectedIndex();
			int dayNum = Integer.parseInt(day.getText());
			int yearNum = Integer.parseInt(year.getText());
			Calendar c = Calendar.getInstance();
			c.set(yearNum, monthNum, dayNum);
			Date date = c.getTime();
			String dayOfWeek = (new SimpleDateFormat("EEEE")).format(date);
			outputLabel.setText(dayOfWeek);
		}
	}
	
}
