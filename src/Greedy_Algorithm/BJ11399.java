package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[caseN+1];
        for(int i=1; i<=caseN; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        int[] dp = new int[caseN+1];
        dp[0] = 0;
        int ans = dp[1];
        for(int i=1; i<=caseN; i++){
            dp[i] = dp[i-1] + time[i];
            ans += dp[i];
        }
        System.out.println(ans);
    }
}
