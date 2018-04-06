package com.derzhavets.playground.oracle.IO.basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class ScanSum {
	public static void main(String[] args) {
		
		Scanner s = null;
		double sum = 0;
		
		try {
			
			s = new Scanner(new BufferedReader(new FileReader("assets/usnumbers.txt")));
			s.useLocale(Locale.US);
			
			while (s.hasNext()) {
				if (s.hasNextDouble()) {
					sum += s.nextDouble();
				} else {
					s.next();
				}
			}
			
			System.out.println(sum);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
	}
}
