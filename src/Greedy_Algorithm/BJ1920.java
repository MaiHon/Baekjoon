package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] checker = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            checker[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(checker);

        for(int i=0; i<m; i++){
            int ans = BinarySearch(0, checker.length-1, checker, nums[i]);
            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

    static int BinarySearch(int s, int e, int[] list, int target){
        int mid=0;
        int end = e;

        while(s<=e){
            mid = (s+e)/2;
            if(list[mid]==target) return 1;
            else if(list[mid]>target) e = mid - 1;
            else if(list[mid]<target) s = mid + 1;
        }
        return 0;
    }
}
