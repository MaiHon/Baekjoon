package Greedy_Algorithm;

import java.io.*;
import java.util.*;

public class BJ2352_NlogN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ports = new int[N];
        for (int i = 0; i < N; i++) ports[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];
        dp[0] = ports[0];
        int len = 1;

        for(int i=1; i<N; i++){
            if(dp[len-1]<ports[i]){
                dp[len] = ports[i];
                len++;
            }else{
                dp[binarySearch(0, len, dp, ports[i])] = ports[i];
            }
        }
        System.out.println(len);

    }

    static int binarySearch(int start, int end, int[] ports, int value){
        int ret = 0;
        int mid = 0;

        while(start<=end){
            mid = (start+end)/2;
            if(ports[mid]>=value){
                ret = mid;
                end = mid-1;
            }else if(ports[mid]<value){
                start = mid+1;
            }
        }
        return ret;
    }

}