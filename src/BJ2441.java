import java.util.Scanner;

public class BJ2441 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=0; j<i-1; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=num+1-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
}
