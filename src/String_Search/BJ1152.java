package String_Search;

import java.util.*;
import java.io.*;

public class BJ1152 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] words = br.readLine().split(" ");
		int count = 0;
		for(int i=0; i<words.length; i++) {
			if(words[i].length() != 0) count++;
		}
		bw.write(count + "\n");
		bw.flush();
	}
	
	
}
