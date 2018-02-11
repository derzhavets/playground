package simplermi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends HelloImpl {
	public HelloServer() {};
	
	public static void main(String[] args) {
		try {
			HelloImpl obj = new HelloImpl();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
			Registry reg = LocateRegistry.getRegistry();
			reg.bind("Hello", stub);
			System.out.println("Server is up");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
