package ACM_ICPC.Korea._2014;

import java.util.*;
import java.io.*;

public class BJ10250 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(System.out));
		
		int testNum = Integer.parseInt(br.readLine());
		for(int i=0; i<testNum; i++) {
			String nums[] = br.readLine().split(" ");
			int height = Integer.parseInt(nums[0]);
			int width = Integer.parseInt(nums[1]);
			int cos = Integer.parseInt(nums[2]);
			
			int x = cos/height;
			int z = cos%height;
			int y = cos-x*height;
			int ans = 0;
			if(z==0) ans = height*100 + x;
			else ans = z*100 + x + 1;
			
			bw.write(Integer.toString(ans));
			bw.newLine();
		}
		bw.flush();
		
		
	}
}
