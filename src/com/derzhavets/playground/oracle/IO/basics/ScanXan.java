package com.derzhavets.playground.oracle.IO.basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanXan {
	public static void main(String[] args) {
		
		Scanner s = null;
		
		try {
			
			s = new Scanner(new BufferedReader(new FileReader("assets/xanadu.txt")));
			
			s.useDelimiter(", \\s*");
			
			while (s.hasNext()) {
				System.out.println(s.next());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
