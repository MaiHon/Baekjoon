
public class BJ4673 {
	public static void main(String args[]) {
		boolean nums[] = new boolean[10001];
		for(int i=0; i<=10000; i++) {
			int tthousand = i/10000;
			int thousand = (i-tthousand*10000)/1000;
			int hundrad = (i-tthousand*10000-thousand*1000)/100;
			int ten = (i-tthousand*10000-thousand*1000-hundrad*100)/10;
			int remainder = i%10;
			int dn = i + tthousand + thousand + hundrad + ten + remainder;
		
			if(dn<=10000) {
//				System.out.format("%d, %d\n", i, dn);
				nums[dn] = true;
			}
			
		}
		for(int i=1; i<10000; i++) {
//			System.out.println(nums[i]);
			if(!nums[i]) System.out.println(i);
		}
	}
}



/*
	private static int getDn(int n){
			int dn = n;
			while(n>0){
				dn += n % 10;
				n /= 10;
			}
			
	-> using method for finding dn. 

*/