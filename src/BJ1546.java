import java.io.*;
import java.util.*;

public class BJ1546 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		float nums[] = new float[N];
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		float sum = 0;
		Arrays.sort(nums);
		float max = nums[N-1];
		for(int j=0; j<nums.length; j++) {
			nums[j] = nums[j]/max * 100;
			sum += nums[j];
		}
		System.out.format("%.2f\n", sum/N);
		
	}
}
