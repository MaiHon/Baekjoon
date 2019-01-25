package Dynamic_Programming;

import java.util.*;

public class BJ11057 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];

        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += (dp[i-1][k])%10007;
                }
            }
        }

        long ans =0;
        for(int i=0; i<10; i++){
            ans += dp[n][i];
        }
        ans %= 10007;

        System.out.println(ans);
    }
}
