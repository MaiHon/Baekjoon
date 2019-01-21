package Dynamic_Programming;

import java.io.*;

public class BJ1010 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testN = Integer.parseInt(br.readLine());

        for(int i=0; i<testN; i++){
            String nums[] = br.readLine().split(" ");
            int n = Integer.parseInt(nums[1]);
            int r = Integer.parseInt(nums[0]);

            int DP[][] = new int[r+1][n+1];

            for(int j=0; j<=n; j++) DP[1][j] = j;

            for(int j=2; j<=r; j++){
                for(int k=j; k<=n; k++){
                    for(int l=k; l>=j; l--){
                        DP[j][k] += DP[j-1][l-1];
                    }
                }
            }

            int ans = DP[r][n];
            bw.write(ans + "\n");
            bw.flush();
        }
    }
}
