package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class BJ11053 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int length = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        int[] list = new int[length+1];
        int idx = 1;
        while(st.hasMoreTokens()){
            list[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }


        int[] dp = new int[length+1];
        int ans = 1;

        dp[1] = 1;
        for(int i=2; i<=length; i++){
            for(int j=i; j>=0; j--){
                if(list[i]>list[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);


    }
}