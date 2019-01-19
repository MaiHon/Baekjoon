import java.io.*;
import java.util.*;

public class BJ14501 {
    static ArrayList<Integer> sum = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int days = Integer.parseInt(br.readLine());

        int[] day = new int[days+1];
        int[] money = new int[days+1];
        int[] DP = new int[days+1];

        for (int i=1; i<=days; i++) {
            String nums[] = br.readLine().split(" ");
            day[i] = Integer.parseInt(nums[0]);
            money[i] = Integer.parseInt(nums[1]);

            if(i+day[i]<=days+1) DP[i] = money[i];
        }


        for(int i=2; i<=days; i++) {
            if(i+day[i]<=days+1) {
                for (int j=1; j<i; j++) {
                    if (i-j>=day[j]) {
                        DP[i] = Math.max(money[i] + DP[j], DP[i]);
                    }
                }
            }
        }

        Arrays.sort(DP);
        bw.write(DP[days] + "\n");
        bw.flush();
    }
}