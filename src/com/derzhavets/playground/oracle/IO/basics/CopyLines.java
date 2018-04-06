package com.derzhavets.playground.oracle.IO.basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			
			in = new BufferedReader(new FileReader(new File("assets/xanadu.txt")));
			out = new PrintWriter(new FileWriter(new File("assets/buffered-output.txt")));
			
			String l;
			
			while ((l = in.readLine()) != null) {
				out.print(l + " | ");
			}
			
			System.out.println("Writing complete");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			};
			if (out != null) {
				out.close();
			}
		}
	}
}
