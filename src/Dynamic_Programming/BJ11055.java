package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class BJ11055 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] list = new int[n+1];
        int[] dp = new int[n+1];

        int idx = 1;
        while(st.hasMoreTokens()){
            list[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = list[idx];
            idx++;
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                if(list[j]<list[i]){
                    dp[i] = Math.max(dp[j]+list[i], dp[i]);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}