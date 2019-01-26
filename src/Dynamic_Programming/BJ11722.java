package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class BJ11722 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] list = new int[n+1];
        int idx = 1;
        while(st.hasMoreTokens()){
            list[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=i; j>0; j--){
                if(list[j]>list[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}
