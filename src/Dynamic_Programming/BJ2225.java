package Dynamic_Programming;

import java.util.*;

public class BJ2225 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=m; i++){
            dp[0][i] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                for(int k=0; k<=j; k++) {
                    dp[i][j] += dp[i-1][j-k];
                    dp[i][j] %= 1000000000;
                }
            }
        }

//        for(int i=0; i<=n; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[n][m]);

    }
}
