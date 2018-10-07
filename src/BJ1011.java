import java.io.*;

public class BJ1011 {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int cycle = Integer.parseInt(br.readLine());
			for(int i=0; i<cycle; i++) {
				String num[] = br.readLine().split(" ");
				int count = 0;
				int start = Integer.parseInt(num[0]);
				int end = Integer.parseInt(num[1]);
				int theNum = end-start;
//				System.out.println(Math.round((float)Math.sqrt(101)));
				
				int maxNum = Math.round((float)Math.sqrt(theNum));
				int sum=0;
				count += maxNum-1;
				sum += ((maxNum*(maxNum+1))/2)-maxNum;
				count += (theNum/maxNum)-(maxNum-1);
				sum += maxNum * ((theNum/maxNum)-(maxNum-1));
				sum += ((maxNum*(maxNum+1))/2)-maxNum;
				count += maxNum-1;
				
//				System.out.println(sum);
				if(sum<theNum) {
					count += 1;
				}
				
				bw.write(String.valueOf(count));
				bw.newLine();
			}
			bw.flush();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
