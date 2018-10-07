import java.util.Scanner;
import java.util.Date;

public class BJ1924 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		Date newD = new Date();
		newD.setYear(107);       // 1900 is the basement .setYear(int n) => 1900 + n
		newD.setMonth(month-1);
		newD.setDate(day);
		
		switch(newD.getDay()) {
		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		}
		
	}
}
