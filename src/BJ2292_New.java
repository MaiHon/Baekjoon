import java.util.*;

public class BJ2292_New {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int count = 1;
		int dnum = 1;
		int add = 6;
		
		while(true) {
			if(num <= dnum) {
				break;
			}
			
			dnum += add;
			add += 6;
			count++;
		}
		
		System.out.println(count);
		
	}
}
