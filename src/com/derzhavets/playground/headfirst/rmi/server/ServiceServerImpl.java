package com.derzhavets.playground.headfirst.rmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import com.derzhavets.playground.headfirst.rmi.server.services.DayOfTheWeekService;
import com.derzhavets.playground.headfirst.rmi.server.services.DiceService;
import com.derzhavets.playground.headfirst.rmi.server.services.MiniMusicService;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
	
	HashMap<String, Object> serviceList;
	
	protected ServiceServerImpl() throws RemoteException {
		setUpServices();
	}

	private void setUpServices() {
		serviceList = new HashMap<String, Object>();
		serviceList.put("Dice Rolling Service", new DiceService());
		serviceList.put("Day Of The Week Service", new DayOfTheWeekService());
		serviceList.put("Mini Music Service", new MiniMusicService());
	}
	
	@Override
	public Object[] getServiceList() throws RemoteException {
		System.out.println("In remote");
		return serviceList.keySet().toArray();
	}

	@Override
	public Service getService(Object serviceKey) throws RemoteException {
		return (Service) serviceList.get(serviceKey);
	}
	
	public static void main(String[] args) {
		try {
			String name = "Service";
			ServiceServerImpl server = new ServiceServerImpl();
			ServiceServer stub = (ServiceServer) UnicastRemoteObject.exportObject(server, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind(name, stub);
			System.out.println("Server is up");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
