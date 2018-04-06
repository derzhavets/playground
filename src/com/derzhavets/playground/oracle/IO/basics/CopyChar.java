package com.derzhavets.playground.oracle.IO.basics;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyChar {
	public static void main(String[] args) throws IOException {
		
		FileReader in = null;
		FileWriter out = null;
		
		try {
			in = new FileReader(new File("assets/xanadu.txt"));
			
			// Bridge from char stream (InputStreamReader) to byte stream (FileInputStream)
			//	in = new InputStreamReader(new FileInputStream("assets/xanadu.txt"));
			
			out = new FileWriter(new File("assets/char-bridge-output.txt"));
			
			int c;
			
			while ((c = in.read()) != -1) {
				out.write(c);
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
