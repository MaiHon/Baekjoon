package Dynamic_Programming;

import java.io.*;
import java.util.*;


public class BJ9465 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseN = Integer.parseInt(br.readLine());
        for(int i=0; i<caseN; i++){
            int n = Integer.parseInt(br.readLine());
            String[] F = br.readLine().split(" ");
            String[] S = br.readLine().split(" ");
            int[][] stickers = new int[3][n+1];

            for(int j=1; j<=n; j++){
                stickers[1][j] = Integer.parseInt(F[j-1]);
                stickers[2][j] = Integer.parseInt(S[j-1]);
            }

            int[][] dp = new int[n+1][3];
            dp[1][0] = 0;
            dp[1][1] = stickers[1][1];
            dp[1][2] = stickers[2][1];

            for(int j=2; j<=n; j++){
                dp[j][0] = Math.max(dp[j-1][0], dp[j-1][1]);
                dp[j][0] = Math.max(dp[j][0], dp[j-1][2]);
                dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2]) + stickers[1][j];
                dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]) + stickers[2][j];
            }
            int ans = Math.max(dp[n][0], dp[n][1]);
            ans = Math.max(ans, dp[n][2]);
            bw.write(ans + "\n");
            bw.flush();
//            System.out.println(Arrays.toString(stickers[1]));
//            System.out.println(Arrays.toString(stickers[2]));
//            for(int j=0; j<=n; j++){
//                System.out.println(Arrays.toString(dp[j]));
//            }
        }
    }
}