import java.util.Scanner;

public class BJ1065 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		
		int hundrad=num/100;
		int ten= num/10%10;
		int one=num%10;
		int count=99;
		if(hundrad==0) count = num;
		
		for(int i=1; i<=hundrad; i++) {
			
			if(i<hundrad) {
				for(int j=0; j<=9; j++) {
					for(int k=0; k<=9; k++) {
						if((i - j) == (j - k)) {
//							System.out.println("1");
							count++;
						}
					}
				}
			}
			else {
				for(int j=0; j<=ten; j++) {
					if(j<ten) {
						for(int k=0; k<=9; k++) {
							if((hundrad - j) == (j - k)) {
//								System.out.println("2");
								count++;
							}
						}
					}
					else {
						for(int k=0; k<=one; k++) {
							if((hundrad - j) == (j - k)) {
//								System.out.println("3");
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}




/* 

	private static int CheckHanNumber(int n){
		int num1 = n/100;
		int num2 = n/10%10;
		int num3 = n%10;
	
		if(num2*2 == num1 + num3){
				return 1;
		}
		return 0;
*/