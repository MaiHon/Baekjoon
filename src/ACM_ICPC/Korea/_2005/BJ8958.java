package ACM_ICPC.Korea._2005;

import java.util.*;
import java.io.*;

public class BJ8958 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			char[] line = br.readLine().toCharArray();
			int result = Count(line);
			bw.write(result + "\n");
		}
		bw.flush();
		
	}
	
	private static int Count(char arr[]) {
		int count = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='O') { 
				count++;
				sum += count;
			}
			else count=0;
		}
		
		return sum;
	}
	
}
