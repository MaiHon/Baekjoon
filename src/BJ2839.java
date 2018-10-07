import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BJ2839 {
	public static void main(String [] args) throws FileNotFoundException{
//		System.setIn(new FileInputStream("./src/BJ2839.txt"));
		Scanner sc = new Scanner(System.in);
		
		int sugar = sc.nextInt();
		int five = sugar/5;
		int remainder = sugar%5;
		int three = 0;
		
		int bag = 0;
		while(five>=0) {
			if(remainder%3==0) {
				three = remainder/3;
				remainder = 0;
				break;
			}
			five--;
			remainder += 5;
		}
		if(remainder==0) bag = five + three;
		else bag=-1;
		
		System.out.println(bag);
	}
}