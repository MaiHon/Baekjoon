import java.io.*;
import java.util.*;

public class BJ1110 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		System.out.println(cycle(num));
	}
	
	
	private static int cycle(int n) {
		int ten = n/10;
		int one = n%10;
		int count = 0;
		int tmp;
		
		while(true) {
			tmp = ten;
			ten = one;
			one = (tmp + one)%10;
			count++;
			if((ten*10+one) == n) break;
		}
		return count;
	}
}
