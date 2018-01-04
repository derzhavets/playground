package sockets.adviceApp;

import java.io.*;
import java.net.*;
import java.util.Random;

public class AdviceServer {
	private String[] advices = {"Go home", "Shave your legs", "Rest and Vest", "Don't do that", "Procrastinate",
			"Check things", "Cast spell", "Ring the bells", "Push the button"};
	
	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(4000);
			
			while (true) {
				Socket sock = serverSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String adv = getAdvice();
				writer.println(adv);
				System.out.println(adv);
				writer.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getAdvice() {
		return advices[new Random().nextInt(advices.length)];
	}
	
	public static void main(String[] args) {
		AdviceServer ss = new AdviceServer();
		ss.go();
	}
}
