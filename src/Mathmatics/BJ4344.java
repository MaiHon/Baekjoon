package Mathmatics;

import java.io.*;
import java.util.*;

public class BJ4344 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int caseNum = Integer.parseInt(br.readLine());
		for(int i=0; i<caseNum; i++) {
			float sum = 0;
			String[] nums = br.readLine().split(" ");
			int n = Integer.parseInt(nums[0]);
			for(int j=1; j<nums.length; j++) {
				sum += Integer.parseInt(nums[j]);
				
			}
			float avg = sum / (float)n;
			float count = 0;
			for(int j=1; j<nums.length; j++) {
				if(Integer.parseInt(nums[j]) > avg) count++;
			}
			
			System.out.format("%.3f%%\n",count/(float)n * 100);
		}
	}
}
