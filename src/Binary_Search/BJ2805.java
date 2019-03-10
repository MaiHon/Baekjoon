package Binary_Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
    static long N,M;
    static long ans;
    static int[] heights;

    public static void main(String args[])throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/mah/Desktop/eko.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        heights = new int[(int)N];

        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            heights[i] = Integer.valueOf(st.nextToken());
            if(heights[i]>max) max = heights[i];
        }


        ans = Long.MIN_VALUE;
        binaraySearch(0, max);
        System.out.println(ans);
    }

    private static void binaraySearch(long down, long up){
//        System.out.println(down + " " + up);
        long tot = 0;
        long mid = 0;

        while(down<=up){
            mid = (down + up)/2;
            tot = sum(mid);
//            System.out.println(down + " " + up + " " + tot);
            if(tot<M){
                up = mid-1;
            }

            if(tot>=M){
                down = mid+1;
                ans = Math.max(ans, mid);
            }
        }
    }

    private static long sum(long height){
        long tot = 0;
        for(int i=0; i<N; i++){
            if(heights[i]>height){
                tot += heights[i] - height;
            }
        }
        return tot;
    }
}
