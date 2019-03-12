package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
    private static int n;
    private static long min, max;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        int[] nums = new int[n];
        int[] order = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            order[i] = Integer.valueOf(st.nextToken());
        }

        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        dfs(1, 0, order, nums, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int idx, int[] order, int[] nums, int val){
        if(depth==n){
            min = Math.min(min, val);
            max = Math.max(max, val);
            return;
        }

        for(int i=0; i<4; i++){
            if(order[i]==0) continue;
            order[i]--;

            switch (i){
                case 0:
                    val += nums[idx+1];
                    break;
                case 1:
                    val -= nums[idx+1];
                    break;
                case 2:
                    val *= nums[idx+1];
                    break;
                case 3:
                    val /= nums[idx+1];
                    break;
            }
            idx++;
            dfs(depth+1, idx, order, nums, val);

            idx--;
            order[i]++;
            switch (i){
                case 0:
                    val -= nums[idx+1];
                    break;
                case 1:
                    val += nums[idx+1];
                    break;
                case 2:
                    val /= nums[idx+1];
                    break;
                case 3:
                    val *= nums[idx+1];
                    break;
            }
        }
    }
}
