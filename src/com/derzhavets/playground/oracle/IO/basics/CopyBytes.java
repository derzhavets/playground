package com.derzhavets.playground.oracle.IO.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	public static void main(String[] args) throws IOException {
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(new File("assets/xanadu.txt"));
			out = new FileOutputStream(new File("assets/byte-output.txt"));
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
				System.out.print(c);
			}
			System.out.println("Writing complete.");
			
		} catch (FileNotFoundException e) {
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
