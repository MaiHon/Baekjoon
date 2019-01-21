package Dynamic_Programming;

import java.util.*;
import java.io.*;

public class BJ1912 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] ans = new int[n];
        String[] num = br.readLine().split(" ");


        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(num[i]);
        }

        ans[0] = nums[0];

//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(ans));

        for(int i=1; i<n; i++){
            ans[i] = Math.max(ans[i-1]+nums[i], nums[i]);

        }

//        System.out.println(Arrays.toString(ans));
        Arrays.sort(ans);

        System.out.println(ans[n-1]);
    }
}

