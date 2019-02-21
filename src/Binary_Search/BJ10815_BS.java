package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10815_BS {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] map = new int[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int idx = Integer.valueOf(st.nextToken())+10000000;
            map[idx] = 1;
        }

        int m = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int idx = Integer.valueOf(st.nextToken())+10000000;
            if(map[idx]==1) sb.append(1 + " ");
            else sb.append(0 + " ");
        }

        System.out.println(sb);
    }
}
