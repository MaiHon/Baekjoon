package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class BJ11054 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int idx=1;
        int[] list = new int[n+1];
        while(st.hasMoreTokens()){
            list[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        int[] left = new int[n+1];
        int[] right = new int[n+1];
        int[] ans = new int[n+1];

        for(int i=1; i<=n; i++) {
            left[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (list[j] < list[i]) {
                    left[i] = Math.max(left[j]+1, left[i]);
                }
            }
        }
        for(int i=n; i>=1; i--){
            for(int j=n; j>=i; j--){
                if(list[j]<list[i]){
                    right[i] = Math.max(right[j]+1, right[i]);
                }
            }
            ans[i] = left[i] + right[i];
        }

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
//        System.out.println(Arrays.toString(ans));
        Arrays.sort(ans);
        bw.write(ans[n]+"\n");
        bw.flush();
    }
}
