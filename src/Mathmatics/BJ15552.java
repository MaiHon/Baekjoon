package Mathmatics;

import java.io.*;
import java.util.*;

public class BJ15552 {
	public static void main(String args[]) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			String[] line = br.readLine().split(" ");			
			bw.write(Integer.parseInt(line[0]) + Integer.parseInt(line[1]) + "\n");
			
		}
		bw.flush();
	}
}
