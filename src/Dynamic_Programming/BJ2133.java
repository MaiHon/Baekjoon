package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2133 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];

        dp[0] = 1;
        for(int i=2; i<=N; i+=2){
            dp[i] = dp[i-2]*3;
            for(int j=4; i-j>=0; j+=2){
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
