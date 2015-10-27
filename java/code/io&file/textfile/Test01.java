package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream("employee.txt")));
		String line;
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
	}
}
