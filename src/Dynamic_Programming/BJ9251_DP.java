package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Bottom-up solution
public class BJ9251_DP {
    public static void main(String args[])throws IOException {
        long stime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int f_len = first.length;
        int s_len = second.length;

        int[][] dp = new int[f_len+1][s_len+1];
        for(int i=0; i<f_len; i++){
            for(int j=0; j<s_len; j++){
                if(first[i]==second[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[f_len][s_len]);
        long etime = System.currentTimeMillis();
        System.out.println(etime-stime);
    }
}
