package Printing;

import java.util.Scanner;

public class BJ2739 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			System.out.format("%d * %d = %d\n", num, i, num*i);
		}
	}
}
