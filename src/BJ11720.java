import java.math.BigInteger;
import java.util.Scanner;

public class BJ11720 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cycle = sc.nextInt();
		BigInteger num = sc.nextBigInteger();
		sc.close();
		BigInteger sum = BigInteger.valueOf(0);
		for(int i=0; i<cycle; i++) {
			BigInteger remainder = num.remainder(BigInteger.valueOf(10));
			sum = sum.add(remainder);
//			System.out.println("sum " + sum);
			num = num.divide(BigInteger.valueOf(10));
//			System.out.println("nums " + num);
		}	
		
		System.out.println(sum);
	}
}

/*
	String inputs = sc.next();
	
	int result = 0;
	for(int i=0; i<n; i++){
		Integer.parseInt(inputs.substring(i, i+1));
	}

*/