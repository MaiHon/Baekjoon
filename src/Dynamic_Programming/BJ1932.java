package Dynamic_Programming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1932 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][n+1];
        int[][] map = new int[n+1][n+1];

        dp[1][0] = map[1][0] = Integer.parseInt(br.readLine());

        for(int i=2; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=0; i<=n; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }

        for(int i=2; i<=n; i++){
            dp[i][0] = dp[i-1][0] + map[i][0];
            for(int j=1; j<i; j++){
                dp[i][j] = map[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }

//        System.out.println();
//        for(int i=0; i<=n; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        Arrays.sort(dp[n]);
        System.out.println(dp[n][n]);
    }
}
