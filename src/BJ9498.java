import java.io.*;
import java.util.*;

public class BJ9498 {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			String numS = br.readLine();
			int num = Integer.parseInt(numS);
			if(num>89) bw.write("A\n");
			else if(num>79) bw.write("B\n");
			else if(num>69) bw.write("C\n");
			else if(num>59) bw.write("D\n");
			else bw.write("F\n");
			bw.flush();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
