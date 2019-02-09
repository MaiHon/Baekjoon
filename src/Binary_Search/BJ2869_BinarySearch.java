package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2869_BinarySearch {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long a, b, v, start, end, mid, dap = 1000000001;

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        v = Long.parseLong(st.nextToken());

        start = 1;
        end = v;

        while(start < end){
            mid = (start + end)/2;
            if((mid-1)*(a-b)+a >= v){
                end = mid;
                dap = Math.min(mid, dap);
            }else{
                start = mid+1;
            }
        }
        System.out.println(dap);
    }
}
