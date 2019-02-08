package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2352 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseN = Integer.parseInt(st.nextToken());
        int[] values = new int[caseN+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=caseN; i++){
            int v = Integer.parseInt(st.nextToken());
            values[i] = v;
        }

        int[] dp = new int[caseN+1];

        dp[1]=1;
        for(int i=2; i<=caseN; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(values[i]>values[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[caseN]);
    }
}

