import java.util.*;

public class BJ2920 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int line[] = new int[8];
		for(int i=0; i<8; i++) {
			line[i] = sc.nextInt();
		}
		
		String output = "";
		for(int i=0; i<7; i++) {
			if(line[i]+1 == line[i+1]) output = "ascending";
			else if(line[i] == line[i+1]+1) output = "descending";
			else {
				output = "mixed";
				break;
			}
		}
		
		System.out.println(output);
		
			
	}
}
