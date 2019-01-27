package Dynamic_Programming;

import java.util.*;

public class BJ1699 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] dp = new int[num+1];

        for(int i=1; i<=num; i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[num]);
    }
}
