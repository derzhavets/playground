package com.derzhavets.playground.headfirst.rmi.simplermi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	public void sayHello() throws RemoteException;
}
