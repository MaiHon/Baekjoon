package Dynamic_Programming;

        import java.io.*;

public class BJ9461 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseN = Integer.parseInt(br.readLine());
        for(int i=0; i<caseN; i++){
            int num = Integer.parseInt(br.readLine());
            //int[] dp = new int[num+1];  -> when the num is 100, the answer is over int range
            long[] dp = new long[num+1];

            dp[1] = 1;
            if(num>1) dp[2] = 1;
            if(num>2) dp[3] = 1;
            if(num>3) dp[4] = 2;
            if(num>4) dp[5] = 2;
            for(int j=6; j<=num; j++){
                dp[j] = dp[j-1] + dp[j-5];
            }
            System.out.println(dp[num]);
        }
    }
}
