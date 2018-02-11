package rmi.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.*;

import rmi.server.*;

public class ServiceBrowser {
	JPanel mainPanel;
	JComboBox serviceList;
	ServiceServer server;
	
	public void buildGUI() {
		JFrame frame = new JFrame("RMI Browser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		frame.add(BorderLayout.CENTER, mainPanel);
		
		Object[] services = getServicesList();
		serviceList = new JComboBox(services);
		
		frame.add(BorderLayout.NORTH, serviceList);
		
		serviceList.addActionListener(new MyListListener());
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	private Object[] getServicesList() {
		Object obj = null;
		Object[] services = null;
		try {
			obj = Naming.lookup("rmi://localhost/ServiceServer");
			server = (ServiceServer) obj;
			services = server.getServiceList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return services;
	}
	
	private void loadService(Object serviceKey) {
		try {
			Service s = server.getService(serviceKey);
			mainPanel.removeAll();
			mainPanel.add(s.getGuiPanel());
			mainPanel.validate();
			mainPanel.repaint();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private class MyListListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object selection = serviceList.getSelectedItem();
			loadService(selection);
		}
	}
	
	public static void main(String[] args) {
		new ServiceBrowser().buildGUI();
	}
}
