package Mathmatics;

import java.util.*;

public class BJ10872 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] * i;
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
}
