package Dynamic_Programming;

import java.util.Scanner;

public class BJ2903 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        dp[0] = 2;

        for(int i=1; i<=N; i++){
            dp[i] = 2 * dp[i-1] - 1;
        }

        System.out.println(dp[N]*dp[N]);
    }
}
