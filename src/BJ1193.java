import java.util.*;

public class BJ1193 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int iSum = 0;
		int top=0, buttom=0;
		
		
//		for(int i=1; i<4500; i++) {
//			iSum += i;
//			if(num<=iSum) {
//				if(i%2==0) {
//					top = i - (iSum-num);
//					buttom = 1 + (iSum-num);
//					break;
//				}
//				else if(i%2==1) {
//					top = 1 + (iSum-num);
//					buttom = i - (iSum-num);
//					break;
//				}
//			}
//		}
		
		int add = 1;
		while(true) {
			iSum += add;
			if(num<=iSum) {
				if(add%2==0) {
					top = add - (iSum-num);
					buttom = 1 + (iSum-num);
					break;
				} else if(add%2==1) {
					top = 1 + (iSum-num);
					buttom = add - (iSum-num);
					break;
				}
			}
			add += 1;
		}
		
		
		
		
		
		System.out.format("%d/%d\n", top, buttom);
	}
}
