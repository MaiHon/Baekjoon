import java.io.*;
import java.util.*;

public class BJ9095 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseN = Integer.parseInt(br.readLine());

        for(int i=0; i<caseN; i++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            dp[0]=0;
            if(n>=1) dp[1]=1;
            if(n>=2) dp[2]=2;
            if(n>=3) dp[3]=4;

            for(int j=4; j<=n; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            bw.write(dp[n] + "\n");
        }
        bw.flush();
    }
}
