import java.util.*;

public class BJ2292 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count=1;
		for(int i=0; i<19000; i++) {
			int sum = 0;
			for(int j=0; j<=i; j++) {
				sum += j;
			}
			int ai = 2 + 6*sum;
			if(ai<=num) count++;
			else break;
		}
		System.out.println(count);
	}
}
