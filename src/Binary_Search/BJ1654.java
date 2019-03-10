package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {
    private static long n, k, ans;
    private static long[] lines;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.valueOf(st.nextToken());
        k = Long.valueOf(st.nextToken());

        lines = new long[(int)n];
        long max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            lines[i] = Long.valueOf(br.readLine());
            if(lines[i]>=max) max = lines[i];
        }

        ans = 0;
        binaraySearch(1, max);
        System.out.println(ans);
    }

    private static void binaraySearch(long left, long right){
        long mid = 0;

        while(left<=right){
            mid = (left+right)/2;
            long cAt = cntAndleft(mid, lines);

//            System.out.println(cAt + " " + left + " " + right + " " + mid);
            if(cAt<k){
                right = mid-1;
            }

            if(cAt>=k){
                left = mid+1;
                ans = Math.max(ans, mid);
            }
        }
    }

    private static long cntAndleft(long mid, long[] lines){
        long cnt = 0;

        for(int i=0; i<n; i++){
            if(lines[i]>=mid){
                cnt += lines[i]/mid;
            }
        }
        return cnt;
    }
}
