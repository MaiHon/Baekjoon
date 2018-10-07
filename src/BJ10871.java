import java.io.*;
import java.util.*;

public class BJ10871 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] first = br.readLine().split(" ");
		String[] second = br.readLine().split(" ");
		
		
		
		for(int i=0; i<second.length; i++) {
			if(Integer.parseInt(second[i]) < Integer.parseInt(first[1])) {
				bw.write(second[i] + " ");
			}
		}
		bw.flush();
	}
}
