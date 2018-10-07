import java.util.*;
import java.io.*;

public class BJ10817 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String nums[] = br.readLine().split(" ");
		int[] numList = new int[3];
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int c = Integer.parseInt(nums[2]);
		numList[0] = a;
		numList[1] = b;
		numList[2] = c;
		Arrays.sort(numList);
		
		bw.write(numList[1] + "\n");
		
		bw.flush();
	}
}
