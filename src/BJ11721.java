import java.util.Scanner;

public class BJ11721 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		for(int j=0; j<str.length(); j++) {
			System.out.print(str.charAt(j));
			if(j%10==9) {
				System.out.println();
			}
		}	
	}
}
