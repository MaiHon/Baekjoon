import java.io.*;
import java.util.*;

public class BJ2577 {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		
		int result[] = howMany(a, b, c);
		for(int i=0; i<10; i++) {
			bw.write(result[i] + "\n");
		}
		bw.flush();
	}
	
	private static int[] howMany(int a, int b, int c) {
		int result = a * b * c;
		int nums[] = new int[10];
		for(int i=0; i<10; i++) {
//			System.out.println(result);
//			System.out.println(i);
			if(i==result%10) {
				nums[i]++;
				result /= 10;
				if(result==0) break;
				i=-1;
			}
			
		}
		
		return nums;
	}
	
}
