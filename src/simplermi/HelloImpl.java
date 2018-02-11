package simplermi;

import java.rmi.RemoteException;

public class HelloImpl implements Hello {
	@Override
	public void sayHello() throws RemoteException {
		System.out.println("Well, Hello!");
	}
}
