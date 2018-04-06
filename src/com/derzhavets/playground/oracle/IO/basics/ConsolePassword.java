package com.derzhavets.playground.oracle.IO.basics;

import java.io.Console;
import java.util.Arrays;

public class ConsolePassword {
	public static void main(String[] args) {
		
		Console c = System.console();
		if (c == null) {
			System.err.println("No console");
			System.exit(1);
		}
		
		while (true) {

			System.out.println("Enter passwords that match: ");
			char[] oldPassword = c.readPassword("Enter your old password: ");
			char[] newPassword = c.readPassword("Enter your new password: ");
			
			if (Arrays.equals(oldPassword, newPassword)) {
				break;
			} else {
				System.out.println("Passwords don't match, try again: ");
			}
			
		}
		
		System.out.println("Good job!");
	}
}
